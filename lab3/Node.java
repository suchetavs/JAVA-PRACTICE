package lab3;

public class Node {
	
	String data;
	Node left;
	Node right;
	Node parent;
	int height;
	
	
	public Node(String data,Node left,Node right,int height,Node parent) {
		this.data=data;
		this.left=left;
		this.right=right;
		this.height=height;
		this.parent=parent;
		
	}
	
	
		
	
	
}
