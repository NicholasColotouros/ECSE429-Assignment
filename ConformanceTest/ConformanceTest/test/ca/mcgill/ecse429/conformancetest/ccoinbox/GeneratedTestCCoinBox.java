package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneratedTestCCoinBox {
	CCoinBox SMachine;

	@Before
	public void Setup() {
		assertNull(SMachine);
		SMachine = new CCoinBox();
	}


	@After
	public void Teardown() {
		SMachine = null;
		assertNull(SMachine);
	}


	@Test
	public void testTrip1() { //empty -> notAllowed -> allowed -> allowed
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;
		//@todo manually: Check action curQtrs = curQtrs + 1
		assertTrue("Action: allowVend = true was not satisfied.", SMachine.isAllowVend() == true);

		// The following transition has a condition: curQtrs > 3
		assertTrue("Condition: curQtrs > 3 was not satisfied.", SMachine.getCurQtrs() > 3);
		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: totalQtrs = totalQtrs + 2; curQtrs = curQtrs - 2;
		//@todo manually: Check action totalQtrs = totalQtrs + 2
		//@todo manually: Check action curQtrs = curQtrs - 2


	}

	@Test
	public void testTrip2() { //empty -> notAllowed -> allowed -> notAllowed
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;
		//@todo manually: Check action curQtrs = curQtrs + 1
		assertTrue("Action: allowVend = true was not satisfied.", SMachine.isAllowVend() == true);

		// The following transition has a condition: curQtrs == 3
		assertTrue("Condition: curQtrs == 3 was not satisfied.", SMachine.getCurQtrs() == 3);
		SMachine.vend();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: totalQtrs = totalQtrs + 2; curQtrs = 1; allowVend = false;
		//@todo manually: Check action totalQtrs = totalQtrs + 2
		assertTrue("Action: curQtrs = 1 was not satisfied.", SMachine.getCurQtrs() == 1);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);


	}

	@Test
	public void testTrip3() { //empty -> notAllowed -> allowed -> empty
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;
		//@todo manually: Check action curQtrs = curQtrs + 1
		assertTrue("Action: allowVend = true was not satisfied.", SMachine.isAllowVend() == true);

		// The following transition has a condition: curQtrs == 2
		assertTrue("Condition: curQtrs == 2 was not satisfied.", SMachine.getCurQtrs() == 2);
		SMachine.vend();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = totalQtrs + 2; curQtrs = 0; allowVend = false;
		//@todo manually: Check action totalQtrs = totalQtrs + 2
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);


	}

	@Test
	public void testTrip4() { //empty -> notAllowed -> allowed -> allowed
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;
		//@todo manually: Check action curQtrs = curQtrs + 1
		assertTrue("Action: allowVend = true was not satisfied.", SMachine.isAllowVend() == true);

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1


	}

	@Test
	public void testTrip5() { //empty -> notAllowed -> allowed -> empty
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;
		//@todo manually: Check action curQtrs = curQtrs + 1
		assertTrue("Action: allowVend = true was not satisfied.", SMachine.isAllowVend() == true);

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);


	}

	@Test
	public void testTrip6() { //empty -> notAllowed -> allowed -> empty
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;
		//@todo manually: Check action curQtrs = curQtrs + 1
		assertTrue("Action: allowVend = true was not satisfied.", SMachine.isAllowVend() == true);

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: curQtrs = 0; allowVend = false;
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);


	}

	@Test
	public void testTrip7() { //empty -> notAllowed -> empty
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);


	}

	@Test
	public void testTrip8() { //empty -> notAllowed -> empty
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// Check that the action holds: curQtrs = curQtrs + 1;
		//@todo manually: Check action curQtrs = curQtrs + 1

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: curQtrs = 0;
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);


	}

	@Test
	public void testTrip9() { //empty -> empty
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);


	}

	@Test
	public void testTrip10() { //empty -> empty
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;
		assertTrue("Action: totalQtrs = 0 was not satisfied.", SMachine.getTotalQtrs() == 0);
		assertTrue("Action: curQtrs = 0 was not satisfied.", SMachine.getCurQtrs() == 0);
		assertTrue("Action: allowVend = false was not satisfied.", SMachine.isAllowVend() == false);

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));


	}

}