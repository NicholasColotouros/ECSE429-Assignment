package ca.mcgill.ecse429.conformancetest.ccoinbox;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GeneratedTestCCoinBox {
	CCoinBox SMachine;

	@Before
	public void Setup() {
		SMachine = new CCoinBox();
	}


	@Test
	public void testTrip1() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip2() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip3() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip4() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip5() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip6() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.vend();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: The above transition has a condition.
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State allowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("allowed"));
		// TODO: Check that the action holds.

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip7() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip8() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip9() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.


	}

	@Test
	public void testTrip10() {
		SMachine = new CCoinBox();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.addQtr();
		assertTrue("State notAllowed not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("notAllowed"));
		// TODO: Check that the action holds.

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.reset();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));
		// TODO: Check that the action holds.

		SMachine.returnQtrs();
		assertTrue("State empty not reached. The current state is: " + SMachine.getState(), SMachine.getState().toString().equals("empty"));


	}

}