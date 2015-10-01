package testgenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import ca.mcgill.ecse429.conformancetest.statemodel.StateMachine;
import ca.mcgill.ecse429.conformancetest.statemodel.Transition;
import ca.mcgill.ecse429.conformancetest.statemodel.persistence.PersistenceStateMachine;

/**
 * The main class for generating tests.
 */
public class JUnitTestGenerator 
{
	private String XML_Path;
	
	private JUnitWriter Writer;
	private StateMachine MachineInstance;
	
	public JUnitTestGenerator(String xmlPath) 
	{
		if(xmlPath != null)
			XML_Path = xmlPath;
		else
			XML_Path = "ccoinbox.xml";

		PersistenceStateMachine.loadStateMachine(XML_Path);
		MachineInstance = StateMachine.getInstance();
	}
	
	public void GenerateTestClass()
	{
		ArrayList<ArrayList<Transition>> paths = GeneratePaths();

		Writer = new JUnitWriter(MachineInstance.getPackageName(), MachineInstance.getClassName(), paths);
		Writer.Save();
	}
	
	/**
	 * Uses the graph generated and makes the round trips using DFS.
	 * Uses DFS on the edges
	 * @return An arraylist of all paths for the test.
	 */
	private ArrayList<ArrayList<Transition>> GeneratePaths()
	{
		TransitionNode startNode = TransitionNode.GenerateTree(MachineInstance);
		ArrayList<ArrayList<Transition>> paths = new ArrayList<ArrayList<Transition>>();
		
		Stack<TransitionNode> nodeStack = new Stack<TransitionNode>();
		nodeStack.push(startNode);
		startNode.Visited = true;
		
		ArrayList<Transition> currentPath = new ArrayList<Transition>();
		
		while(!nodeStack.empty())
		{
			TransitionNode currentNode = nodeStack.pop();
			Transition prevNode;

			if(currentPath.size() > 0)
			{
				prevNode = currentPath.get(currentPath.size() - 1);
				while(!prevNode.getTo().getName().equals(currentNode.Value.getFrom().getName()))
				{
					currentPath.remove(currentPath.size() - 1); // remove the last one
					prevNode = currentPath.get(currentPath.size() - 1);
				}
			}
			currentPath.add(currentNode.Value);
			
			boolean LeafReached = true;
			for(TransitionNode neighbour : currentNode.Children)
			{
				if(!neighbour.Visited)
				{
					nodeStack.push(neighbour);
					neighbour.Visited = true;
					LeafReached = false;
				}
			}
				
			// If we reached a leaf in our round trip path tree, save a copy of the path
			if(LeafReached)
			{
				paths.add(new ArrayList<Transition>(currentPath));
			}
			
			// If we've arrived somewhere we've already been, get rid of that transition
			if(HasReturnedToAPrevNode(currentPath))
			{
				currentPath.remove(currentPath.size() - 1);
			}
		}
		
		return paths;
	}
	
	private boolean HasReturnedToAPrevNode(ArrayList<Transition> currentPath) 
	{
		String currentState = currentPath.get(currentPath.size() - 1).getTo().getName();
		
		for(Transition t : currentPath)
		{
			if(t.getFrom().getName().equals(currentState))
				return true;
		}
		return false;
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
