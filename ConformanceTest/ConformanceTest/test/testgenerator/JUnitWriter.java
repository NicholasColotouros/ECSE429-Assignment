package testgenerator;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ca.mcgill.ecse429.conformancetest.statemodel.Transition;

/**
 * Used to output the test cases as a java file.
 * Used by the test generator.
 */
public class JUnitWriter 
{
	private String PackageName;
	private ArrayList<String> PackageImports;
	private String ClassName;		// The class being tested
	private String TestClassName;	// The class that is doing the testing (ie the one being generated)
	private ArrayList<ArrayList<Transition>> Paths; // Arraylist of the paths to be made into test methods
	private static String GVarName = "SMachine"; // The global variable name to be used that holds the state machine

	private static String ConditionComment = "// The following transition has a condition: ";
	private static String ActionComment = "// Check that the action holds: ";
	
	
	public JUnitWriter(String packageName, String className, ArrayList<ArrayList<Transition>> paths) 
	{
		PackageName = packageName;
		ClassName = className.split("\\.", 2)[0];
		TestClassName = "GeneratedTest" + ClassName;
		Paths = paths;
		PackageImports = new ArrayList<String>();
		
		// Import basic JUnit stuff
		PackageImports.add("static org.junit.Assert.*");
		PackageImports.add("org.junit.After");
		PackageImports.add("org.junit.Before");
		PackageImports.add("org.junit.Test");
	}

	public void AddPackageImport(String p)
	{
		PackageImports.add(p);
	}

	public void RemovePackageImport(String p)
	{
		PackageImports.remove(p);
	}
	
	public void Save()
	{
		int indentation = 0;
		
		// Package name and imports
		String output = "package " + PackageName + ";\n\n";
		for(String s : PackageImports)
		{
			output = output + "import " + s + ";\n";
		}
		
		// Class and global variables
		output = output + "\n" + "public class " + TestClassName + " {" + "\n";
		indentation++;
		
		output = output + indent(indentation) +  ClassName + " " + GVarName +";\n";
		
		// Setup and teardown methods
		output = output + "\n" + indent(indentation) + "@Before\n";
		output = output + indent(indentation) + "public void Setup() {" + "\n";
		indentation++;
		output = output + indent(indentation) + "assertNull(" + GVarName + ");\n";
		output = output + indent(indentation) + GVarName + " = new " + ClassName + "();\n";
		indentation--;
		output = output + indent(indentation) + "}\n\n";

		output = output + "\n" + indent(indentation) + "@After\n";
		output = output + indent(indentation) + "public void Teardown() {" + "\n";
		indentation++;
		output = output + indent(indentation) + GVarName + " = null;\n";
		output = output + indent(indentation) + "assertNull(" + GVarName + ");\n";
		indentation--;
		output = output + indent(indentation) + "}\n\n";
		
		// Add the tests
		output = output + "\n" + GenerateTestCases(indentation);
		
		// Close the class
		indentation--;
		output = output + indent(indentation) + "}";
		
		// Write the file
		String filepath = "test/" + PackageName.replace('.', '/') + "/";
		File file = new File(filepath);
		file.mkdirs();
		
		try (FileWriter o = new FileWriter(filepath + TestClassName + ".java");)
		{
			o.write(output);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private String indent(int n)
	{
		String output = "";
		for(int i = 0; i < n; i++)
		{
			output = output + "\t";
		}
		return output;
	}
	
	private String GenerateStateSequences(ArrayList<Transition> path) 
	{	
		ArrayList<String> states = new ArrayList();
		
		for(Transition t : path)
		{
			states.add(t.getTo().getName());
		}
		
		return String.join(" -> ", states);
	}
	
	private String GenerateTestCases(int indentation)
	{
		String ret = "";
		int tripNumber = 0;
		
		// For each path
		for(ArrayList<Transition> path : Paths)
		{
			tripNumber++;
			ret = ret + indent(indentation) + "@Test\n";
			ret = ret + indent(indentation) + "public void testTrip" + tripNumber + "() { //" + GenerateStateSequences(path) + "\n";
			indentation++;
	
			// For each transition in the path
			for(Transition t : path)
			{
				// Check the condition before executing transition
				String condition = t.getCondition();
				if(condition != null && !condition.equals(""))
				{
					ret = ret + indent(indentation) + ConditionComment + t.getCondition() + "\n";
					ret += GenerateAssertStatement(t.getCondition(), "condition", indentation);
				}
				
				// If we see @ it must be the constructor
				if(t.getEvent().contains("@"))
				{
					ret = ret + indent(indentation) + GVarName + " = new " + ClassName + "();\n";
				}
				
				// Otherwise it's a method call
				else
				{
					ret = ret + indent(indentation) + GVarName + "." + t.getEvent() + "();\n";
				}
				ret = ret + indent(indentation) + "assertTrue(\"State " + t.getTo().getName() + " not reached. The current state is: \" + " + GVarName + ".getState(), "
						+ GVarName + ".getState().toString().equals(\"" + t.getTo().getName() + "\"));\n";
				
				
				// Check the actions after transition
				String action = t.getAction();
				if(action != null && !action.equals(""))
				{
					ret = ret + indent(indentation) + ActionComment + t.getAction() + "\n";
					ret += GenerateAssertStatement(t.getAction(), "action", indentation);
				}
				ret = ret + "\n";
			}
						
			indentation--;
			ret = ret + "\n" + indent(indentation) + "}\n\n";
		}
		return ret;
	}
	
	private void TrimStringArray (String[] array) {
		for (int i=0; i<array.length; i++) {
			array[i] = array[i].trim();
		}
	}
	
	private String GenerateAssertStatement(String statementsString, String conditionOrAction, int indentation) {
		String output = "";
		String[] statements = statementsString.split(";");
		TrimStringArray(statements);
		
		for (String eachStatement: statements) {
			String[] tokens = eachStatement.split(" ");
			TrimStringArray(tokens);
			
			//determine if the assert statement can be easily generated, if yes, determine if it is a boolean or int
			if (tokens.length == 3 && !tokens[0].substring(0, 2).equalsIgnoreCase("is") &&
					!tokens[0].substring(0, 3).equalsIgnoreCase("!is") &&
					(tokens[2].equalsIgnoreCase("true") || tokens[2].equalsIgnoreCase("false"))) { //boolean
				
				output += indent(indentation) + "assertTrue(\"" + conditionOrAction.substring(0, 1).toUpperCase()
						+ conditionOrAction.substring(1) + ": " + eachStatement + " was not satisfied.\", ";
				
				output += GVarName + ".is" + tokens[0].substring(0, 1).toUpperCase() + tokens[0].substring(1) + "() ";
				
				output += (tokens[1].equals("=") ? "==" : tokens[1]) + " " + tokens[2]  + ");\n";
				
			} else if (tokens.length == 3 && !tokens[0].substring(0, 3).equalsIgnoreCase("get") 
					&& isInteger(tokens[2])) { //int
				
				output += indent(indentation) + "assertTrue(\"" + conditionOrAction.substring(0, 1).toUpperCase()
						+ conditionOrAction.substring(1) + ": " + eachStatement + " was not satisfied.\", ";
				
				output += GVarName + ".get" + tokens[0].substring(0, 1).toUpperCase() + tokens[0].substring(1) + "() ";
				
				output += (tokens[1].equals("=") ? "==" : tokens[1]) + " " + tokens[2]  + ");\n";
				
			} else {// too difficult to generate automatically
				
				output += indent(indentation) + "//@todo manually: Check " + conditionOrAction + " " + eachStatement + "\n";
				
			}
		}
		
		return output;
	}
	
	private static boolean isInteger(String str) {
	    if(str.isEmpty()) return false;
	    for(int i = 0; i < str.length(); i++) {
	        if(i == 0 && str.charAt(i) == '-') { // in case it's a negative number
	            if(str.length() == 1) {
	            	return false;
	            } else {
	            	continue;
	            }
	        }
	        if(Character.digit(str.charAt(i),10) < 0) {
	        	return false;
	        }
	    }
	    return true;
	}
}
