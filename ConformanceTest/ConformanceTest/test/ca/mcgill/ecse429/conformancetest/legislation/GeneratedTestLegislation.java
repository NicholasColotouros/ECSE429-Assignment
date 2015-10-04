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
	public void testTrip1() { //inPreparation -> inHouseOfCommons -> finalized
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// Check that the action holds: isCommonsBill = true;
		//@todo manually: Check action isCommonsBill = true

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		// The following transition has a condition: !getIsCommonsBill()
		//@todo manually: Check condition !getIsCommonsBill()
		SMachine.votePasses();
		assertTrue("State finalized not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("finalized"));


	}

	@Test
	public void testTrip2() { //inPreparation -> inHouseOfCommons -> inSenate -> finalized
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// Check that the action holds: isCommonsBill = true;
		//@todo manually: Check action isCommonsBill = true

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		// The following transition has a condition: getIsCommonsBill()
		//@todo manually: Check condition getIsCommonsBill()
		SMachine.votePasses();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));

		// The following transition has a condition: getIsCommonsBill()
		//@todo manually: Check condition getIsCommonsBill()
		SMachine.votePasses();
		assertTrue("State finalized not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("finalized"));


	}

	@Test
	public void testTrip3() { //inPreparation -> inHouseOfCommons -> inSenate -> inHouseOfCommons
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// Check that the action holds: isCommonsBill = true;
		//@todo manually: Check action isCommonsBill = true

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		// The following transition has a condition: getIsCommonsBill()
		//@todo manually: Check condition getIsCommonsBill()
		SMachine.votePasses();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));

		// The following transition has a condition: !getIsCommonsBill()
		//@todo manually: Check condition !getIsCommonsBill()
		SMachine.votePasses();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));


	}

	@Test
	public void testTrip4() { //inPreparation -> inHouseOfCommons -> inSenate -> inPreparation
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// Check that the action holds: isCommonsBill = true;
		//@todo manually: Check action isCommonsBill = true

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		// The following transition has a condition: getIsCommonsBill()
		//@todo manually: Check condition getIsCommonsBill()
		SMachine.votePasses();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));

		SMachine.voteFails();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));


	}

	@Test
	public void testTrip5() { //inPreparation -> inHouseOfCommons -> inPreparation
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// Check that the action holds: isCommonsBill = true;
		//@todo manually: Check action isCommonsBill = true

		SMachine.introduceInHouse();
		assertTrue("State inHouseOfCommons not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inHouseOfCommons"));

		SMachine.voteFails();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));


	}

	@Test
	public void testTrip6() { //inPreparation -> inSenate
		SMachine = new Legislation();
		assertTrue("State inPreparation not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inPreparation"));
		// Check that the action holds: isCommonsBill = true;
		//@todo manually: Check action isCommonsBill = true

		SMachine.introduceInSenate();
		assertTrue("State inSenate not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("inSenate"));
		// Check that the action holds: isCommonsBill = false;
		//@todo manually: Check action isCommonsBill = false


	}

}