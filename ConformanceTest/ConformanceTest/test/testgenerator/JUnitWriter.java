package testgenerator;

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

	private static String ConditionTODO = "// TODO: The above transition has a condition: ";
	private static String ActionTODO = "// TODO: Check that the action holds: ";
	
	
	public JUnitWriter(String packageName, String className, ArrayList<ArrayList<Transition>> paths) 
	{
		PackageName = packageName;
		ClassName = className.split("\\.", 2)[0];
		TestClassName = "GeneratedTest" + ClassName;
		Paths = paths;
		PackageImports = new ArrayList<String>();
		
		// Import basic JUnit stuff
		PackageImports.add("static org.junit.Assert.*");
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
		output = output + indent(indentation) + GVarName + " = new " + ClassName + "();\n";
		indentation--;
		output = output + indent(indentation) + "}\n\n";

		// Add the tests
		output = output + "\n" + GenerateTestCases(indentation);
		
		// Close the class
		indentation--;
		output = output + indent(indentation) + "}";
		
		// Write the file
		String filepath = "test\\" + PackageName.replace('.', '\\') + "\\";
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
	
	private String GenerateTestCases(int indentation)
	{
		String ret = "";
		int tripNumber = 0;
		
		// For each path
		for(ArrayList<Transition> path : Paths)
		{
			tripNumber++;
			ret = ret + indent(indentation) + "@Test\n";
			ret = ret + indent(indentation) + "public void testTrip" + tripNumber + "() {\n";
			indentation++;
	
			// For each transition in the path
			for(Transition t : path)
			{
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
				
				// Now check for whether or not we're inserting comments
				String condition = t.getCondition();
				String action = t.getAction();
				if(condition != null && !condition.equals(""))
				{
					ret = ret + indent(indentation) + ConditionTODO + t.getCondition() + "\n";
				}
				
				if(action != null && !action.equals(""))
				{
					ret = ret + indent(indentation) + ActionTODO + t.getAction() + "\n";
				}
				ret = ret + "\n";
			}
						
			indentation--;
			ret = ret + "\n" + indent(indentation) + "}\n\n";
		}
		return ret;
	}
}
