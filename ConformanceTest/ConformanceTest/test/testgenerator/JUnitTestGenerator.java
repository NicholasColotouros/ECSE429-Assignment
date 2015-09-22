package testgenerator;

import java.util.ArrayList;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class JUnitTestGenerator 
{
	public static String XML_PATH = "ccoinbox.xml";
	
	private JUnitWriter writer;
	private StateMachine machineInstance;
	
	public JUnitTestGenerator() {}
	
	public void FillInClassInfo()
	{
		PersistenceStateMachine.loadStateMachine(XML_PATH);
		machineInstance = StateMachine.getInstance();
		
		writer = new JUnitWriter(machineInstance.getPackageName(), machineInstance.getClassName());
	}
	
	public void GenerateTests()
	{
		
	}
	
	public void SaveTests ()
	{
		// TODO
		writer.Save();
	}
	
	public static void main(String[] args) 
	{
		JUnitTestGenerator JUTG = new JUnitTestGenerator();
		JUTG.FillInClassInfo();
		JUTG.GenerateTests();
		JUTG.SaveTests();
	}

}
