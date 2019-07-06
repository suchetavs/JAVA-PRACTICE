import java.util.Scanner;

public class TreeQueries {	
	static class Node1{
		
		String data;
		Node1 left;
		Node1 right;
		public Node1(String data, Node1 left, Node1 right) {
			
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		int nodes,queries;
		String input;
		Scanner in=new Scanner(System.in);
		input=in.nextLine();
		nodes=Integer.parseInt(input.split("\\s")[0]);
		queries=Integer.parseInt(input.split("\\s")[1]);
		String[] node=new String[nodes];
		node=in.nextLine().split("\\s");
		if(nodes!=0)
			Node1 root=new Node1(node[0],null,null);
		for(int i=0;i<nodes;i++)
		{
			
			
		}
		

	}

}
