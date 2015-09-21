package testgenerator;

import java.util.ArrayList;

import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

public class JUnitTestGenerator 
{
	public static String XML_PATH = "..\\..\\ccoinbox.xml";
	
	
	private JUnitWriter writer;
	
	public void FillInClassInfo()
	{
		// TODO
	}
	
	public void GenerateTests()
	{
		// TODO
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
