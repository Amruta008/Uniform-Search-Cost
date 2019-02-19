import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*Performing Search by navigating through the graph formed*/
public class Navigate {

/* Uninformed Search to find the minimum distance from source to destination*/
	public void UninformerdSearch(ArrayList<String> list, String source, String destination) {
		
		//Variables used
		Node_Formation parentNode = new Node_Formation (null, 0, 0, source, 0);
		ArrayList<Node_Formation> fringe = new ArrayList<Node_Formation>();
		
		//forming a fringe with nodes staring with the origin
		fringe.add(parentNode);
		Node_Formation target = null;
		int expandNodes = 0;
		
		ArrayList<String> visited = new ArrayList<String>();
		
		//Perform the search until the fringe it empty and the target or the goalstate is not reached
		while (!(fringe.isEmpty()) && target == null) {
			
			Node_Formation currentNode = fringe.remove(0);
			//Counter for expanding nodes
			expandNodes++;
			
			//The current node contains the destination then goal found
			if (currentNode.currentState.equals(destination)) {
				target = currentNode;
			}
			else {
				if(visited.contains(currentNode.currentState)){}
				
				else {
					visited.add(currentNode.currentState);
					
					for (String temp : list) {
						// check if the temp state and tokenize it to string
						if (temp.contains(currentNode.currentState)) {
							//Tokenize: convert input to string format
							StringTokenizer tokenString = new StringTokenizer(temp, " ");
							String city1 = tokenString.nextToken();
							String city2 = tokenString.nextToken();
							float cost = (float) Integer.parseInt(tokenString.nextToken());
							
							//formation of child nodes
							if (currentNode.currentState.equals(city1)) {
								Node_Formation city = new Node_Formation(currentNode, currentNode.depth+1, currentNode.pathCost+cost, city2, 0);
								fringe.add(city);
							}
							else {
								Node_Formation city = new Node_Formation(currentNode, currentNode.depth+1, currentNode.pathCost+cost, city1, 0);
								fringe.add(city);
							}
							
						}
					}
					Collections.sort(fringe, new Compare_Node());
				}
			}
		}
		
		//Display the path along with the cost and expanded nodes
		if (target == null) {
			System.out.println("Nodes Expanded: " + expandNodes);
			System.out.println("Distance: Infinity \nRoute : \nNone");
		}
		else {
			target.child = null;
			System.out.println("Nodes Expanded: " + expandNodes);
			System.out.println("Distance: " + target.pathCost + "\nRoute : ");
			while (target.parent != null) {
				target.parent.child = target;
				target = target.parent;
			}
			while (target.child != null) {
				System.out.println(target.currentState + " to " + target.child.currentState + " " + (target.child.pathCost - target.pathCost) + "km");
				target = target.child;
			}
		}
		
	}

	/* Informed Search Strategy */
	public void InformedSearch(ArrayList<String> inputText, String source, String destination,
			ArrayList<String> heuristicText) {

		//Variables used
		Node_Formation parentNode = new Node_Formation (null, 0, 0, source, 0);
		ArrayList<Node_Formation> fringe = new ArrayList<Node_Formation>();
		
		fringe.add(parentNode);
		Node_Formation target = null;
		int expand = 0;
		float heuristicValue = 0;
		
		ArrayList<String> visited = new ArrayList<String>();
		
		while (!(fringe.isEmpty()) && target == null) {
			
			Node_Formation currentNode = fringe.remove(0);
			//Counter for nodes expanded
			expand++;
			
			//The current node contains the destination then goal found
			if (currentNode.currentState.equals(destination)) {
				target = currentNode;
			}
			else {
				if(!(visited.contains(currentNode.currentState))){
					visited.add(currentNode.currentState);
					float cost;
					for (String temp : inputText) {
						if (temp.contains(currentNode.currentState)) {
							//Tokenize: convert input and heuristic to string format
							StringTokenizer tokenString = new StringTokenizer(temp, " ");
							String city1 = tokenString.nextToken();
							String city2 = tokenString.nextToken();
							cost = (float) Integer.parseInt(tokenString.nextToken());
							if (currentNode.currentState.equals(city1)) {
								//using heuristic as its informed search to get the pathcost
								for (String hueristic : heuristicText) {
									StringTokenizer heuristicTokenString = new StringTokenizer(hueristic, " ");
									String city = heuristicTokenString.nextToken();
									float heuristicCost = (float) Integer.parseInt(heuristicTokenString.nextToken());
									if (city.equalsIgnoreCase(city2)) {
										heuristicValue = heuristicCost;
										Node_Formation cityValue = new Node_Formation(currentNode, (int)(currentNode.pathCost+cost), currentNode.pathCost+cost, city2, currentNode.pathCost+cost+heuristicValue);
										fringe.add(cityValue);
									}
								}
							}
							else if (currentNode.currentState.equals(city2)) {
								for (String hueristic : heuristicText) {
									StringTokenizer heuristicTokenString = new StringTokenizer(hueristic, " ");
									String city = heuristicTokenString.nextToken();
									float heuristicCost = (float) Integer.parseInt(heuristicTokenString.nextToken());
									if (city.equalsIgnoreCase(city1)) {
										heuristicValue = heuristicCost;
										Node_Formation cityValue = new Node_Formation(currentNode, (int)(currentNode.pathCost+cost), currentNode.pathCost+cost, city1, currentNode.pathCost+cost+heuristicValue);
										fringe.add(cityValue);
									}
								}
							}
						}
					}
					//Sorting of fringe
					Collections.sort(fringe, new Compare_Node());
				}

			}
		}
		
		//Display the path along with the cost and expanded nodes
		if (target == null) {
			System.out.println("Nodes Expanded: " + expand);
			System.out.println("Distance : Infinity \nRoute : \nNone");
		}
		else {
			target.child = null;
			System.out.println("Nodes Expanded: " + expand);
			System.out.println("Distance : " + (target.pathCost) + "\nRoute : ");
			while (target.parent != null) {
				target.parent.child = target;
				target = target.parent;
			}
			while (target.child != null) {
				System.out.println(target.currentState + " to " + target.child.currentState + " " + (target.child.pathCost - target.pathCost)+ "km");
				target = target.child;
			}
		}
	}
}