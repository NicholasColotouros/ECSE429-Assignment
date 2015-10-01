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
	public void testTrip1() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;

		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: The above transition has a condition: curQtrs > 3
		// TODO: Check that the action holds: totalQtrs = totalQtrs + 2; curQtrs = curQtrs - 2;


	}

	@Test
	public void testTrip2() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;

		SMachine.vend();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: The above transition has a condition: curQtrs == 3
		// TODO: Check that the action holds: totalQtrs = totalQtrs + 2; curQtrs = 1; allowVend = false;


	}

	@Test
	public void testTrip3() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;

		SMachine.vend();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: The above transition has a condition: curQtrs == 2
		// TODO: Check that the action holds: totalQtrs = totalQtrs + 2; curQtrs = 0; allowVend = false;


	}

	@Test
	public void testTrip4() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;


	}

	@Test
	public void testTrip5() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;


	}

	@Test
	public void testTrip6() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1; allowVend = true;

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: curQtrs = 0; allowVend = false;


	}

	@Test
	public void testTrip7() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0;


	}

	@Test
	public void testTrip8() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds: curQtrs = curQtrs + 1;

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: curQtrs = 0;


	}

	@Test
	public void testTrip9() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0;


	}

	@Test
	public void testTrip10() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds: totalQtrs = 0; curQtrs = 0; allowVend = false;

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));


	}

}