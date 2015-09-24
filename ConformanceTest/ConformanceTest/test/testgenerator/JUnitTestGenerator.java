package testgenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

/**
 * The main class for generating tests.
 */
public class JUnitTestGenerator 
{
	private String XML_Path = "ccoinbox.xml";
	
	private JUnitWriter Writer;
	private StateMachine MachineInstance;
	
	public JUnitTestGenerator(String xmlPath) 
	{
		if(xmlPath != null)
			XML_Path = xmlPath;

		PersistenceStateMachine.loadStateMachine(XML_Path);
		MachineInstance = StateMachine.getInstance();
	}
	
	public void GenerateTestClass()
	{
		StateNode startNode = StateNode.GenerateTree(MachineInstance);
		ArrayList<ArrayList<Transition>> paths = new ArrayList<ArrayList<Transition>>();
		
		// TODO generate the paths

		Writer = new JUnitWriter(MachineInstance.getPackageName(), MachineInstance.getClassName(), paths);
		Writer.Save();
	}
	
	public static void main(String[] args) 
	{
		JUnitTestGenerator JUTG;
		if(args.length > 0)
		{
			File f = new File(args[0]);
			if(f.exists())
			{
				JUTG = new JUnitTestGenerator(args[0]);
			}
			else
			{
				System.out.println("ERROR: File not found");
				return;
			}
		}
		else
		{
			JUTG = new JUnitTestGenerator(null);
		}
		
		JUTG.GenerateTestClass();
	}

}
