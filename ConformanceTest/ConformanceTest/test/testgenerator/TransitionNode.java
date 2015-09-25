package testgenerator;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;

/**
 * Used to represent and generate the round trip path tree.
 */
public class TransitionNode
{
	public boolean Visited = false;
	public ArrayList<TransitionNode> Children;
	public Transition Value;
	
	private TransitionNode(Transition val)
	{
		Value = val;
		Children = new ArrayList<TransitionNode>();
	}
	
	// Yes I know how the name might be interpreted. The method name is descriptive and hilarious.
	public void MakeChildren(ArrayList<TransitionNode> allNodes)
	{
		// Find the children (to == from)
		for(TransitionNode t : allNodes)
		{
			if(Value.getTo().getName().equals(t.Value.getFrom().getName()))
			{
				Children.add(t);
			}
		}

	}
	
	public static TransitionNode GenerateTree(StateMachine s)
	{
		List<Transition> allTransitions = s.getTransitions();
		ArrayList<TransitionNode> allNodes = new ArrayList<TransitionNode>();

		TransitionNode startNode = null;
		for(Transition t : allTransitions)
		{
			TransitionNode node = new TransitionNode(t);
			allNodes.add(node);
			
			if(node.Value.getFrom().getName().equals(s.getStartState().getName()))
			{
				startNode = node;
			}
		}
		
		for(TransitionNode n : allNodes)
		{
			n.MakeChildren(allNodes);
		}
		
		return startNode;
	}
}
