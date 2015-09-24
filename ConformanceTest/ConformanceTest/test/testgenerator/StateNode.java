package testgenerator;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse429.conformancetest.statemodel.State;
import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;

/**
 * Used for making the round trip tree.
 */
public class StateNode 
{
	public ArrayList<Transition> Transitions; // Transitions going out from this node
	private ArrayList<StateNode> States;
	public boolean Visited;
	public State CurrentState;
	
	// TODO: test that the tree is generated properly
	// Fills in a single node. Used to construct the rest of the tree
	private StateNode(State state, List<Transition> pTransitions, ArrayList<StateNode> states)
	{
		Visited = false;
		CurrentState = state;
		Transitions = new ArrayList<Transition>();
		States = states;
		
		// Get all transitions which have the current node as FROM and add them to the list
		// of transitions going out
		for(Transition t : pTransitions)
		{
			if(t.getFrom().getName().equals(CurrentState.getName()))
			{
				Transitions.add(t);
			}
		}
	}
	
	// Constructs the entire tree and returns the start node
	public static StateNode GenerateTree(StateMachine s) 
	{
		ArrayList<StateNode> States = new ArrayList<StateNode>();
		StateNode StartState = null;
		for(State state : s.getStates())
		{
			StateNode currentStateNode = new StateNode(state, s.getTransitions(), States);
			States.add(currentStateNode);
			
			if(state.getName().equals(s.getStartState().getName()))
			{
				StartState = currentStateNode;
			}
		}
		
		return StartState;
	}
	
	public StateNode TraverseTransition(Transition t)
	{
		for(StateNode s : States)
		{
			if(t.getTo().getName().equals(s.CurrentState.getName()))
			{
				return s;
			}
		}
		
		return null; // SHOULD NOT HAPPEN
	}
}
