import java.util.Comparator;

/*Sorting of the fringe using the given node information*/
public class Compare_Node implements Comparator<Node_Formation> { 

	@Override
	public int compare(Node_Formation o1, Node_Formation o2) {
		return (int) (o1.heuristic - o2.heuristic);
	}
}
