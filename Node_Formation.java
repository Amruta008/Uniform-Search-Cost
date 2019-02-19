/* Graph creation*/
public class Node_Formation implements Comparable<Node_Formation> {
	
	//variables used
	Node_Formation parent;
	Node_Formation child;
	int depth;
	float pathCost;
	float heuristic;
	String currentState;
	
	//constructor to create a node
	public Node_Formation (Node_Formation parent, int depth, float pathCost, String currentState, float heuristic) {
		this.parent = parent;
		this.depth = depth;
		this.pathCost = pathCost;
		this.heuristic = heuristic;
		this.currentState = currentState;
	}
	
	// the function overrides the parent function to use its own type of arguments.
	@Override
	public int compareTo(Node_Formation o) {
		return Float.compare(this.pathCost, o.pathCost);
	}

}
