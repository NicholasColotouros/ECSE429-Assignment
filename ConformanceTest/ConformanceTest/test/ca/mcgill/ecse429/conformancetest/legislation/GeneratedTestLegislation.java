package ca.mcgill.ecse429.conformancetest.legislation;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneratedTestLegislation {
	Legislation SMachine;

	@Before
	public void Setup() {
		assertNull(SMachine);
		SMachine = new Legislation();
	}


	@After
	public void Teardown() {
		SMachine = null;
		assertNull(SMachine);
	}


	@Test
	public void testTrip1() {
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// TODO: Check that the action holds: isCommonsBill = true;

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		SMachine.votePasses();
		assertTrue("State finalized not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("finalized"));
		// TODO: The above transition has a condition: !getIsCommonsBill()


	}

	@Test
	public void testTrip2() {
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// TODO: Check that the action holds: isCommonsBill = true;

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		SMachine.votePasses();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));
		// TODO: The above transition has a condition: getIsCommonsBill()

		SMachine.votePasses();
		assertTrue("State finalized not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("finalized"));
		// TODO: The above transition has a condition: getIsCommonsBill()


	}

	@Test
	public void testTrip3() {
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// TODO: Check that the action holds: isCommonsBill = true;

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		SMachine.votePasses();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));
		// TODO: The above transition has a condition: getIsCommonsBill()

		SMachine.votePasses();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));
		// TODO: The above transition has a condition: !getIsCommonsBill()


	}

	@Test
	public void testTrip4() {
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// TODO: Check that the action holds: isCommonsBill = true;

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		SMachine.votePasses();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));
		// TODO: The above transition has a condition: getIsCommonsBill()

		SMachine.voteFails();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));


	}

	@Test
	public void testTrip5() {
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// TODO: Check that the action holds: isCommonsBill = true;

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		SMachine.voteFails();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));


	}

	@Test
	public void testTrip6() {
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// TODO: Check that the action holds: isCommonsBill = true;

		SMachine.introduceInSenate();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));
		// TODO: Check that the action holds: isCommonsBill = false;


	}

}