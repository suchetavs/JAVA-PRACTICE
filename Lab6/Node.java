package Lab6;

import java.util.List;

public class Node {

	String data;
	List<Node> neighbours;
	String status;

	
	public Node(String data, List<Node> neighbours,String status) {
		this.data = data;
		this.neighbours = neighbours;
		this.status=status;
	}
	
	
	public void addNeighbour(Node node) {
			
		neighbours.add(node);
		
	}
	
	
	
	
	
	
	
}
