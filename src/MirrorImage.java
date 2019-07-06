import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MirrorImage {
	static Node foundnode;
	static class Node{
		int data;
		Node left,right,parent;
	
		public Node(int data, Node left, Node right,Node parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent=parent;
		
		}
			
		
	}
	
	
	public static void findnode(String s,Node node) {
		
		if(node==null)
			return;
		//System.out.print(node.data+" ");
		
		  if(node.data==Integer.parseInt(s)) {
			  foundnode=node;
			  return; 
		  }
		 
		findnode(s,node.left);
		findnode(s,node.right);
				
	}
	
	
	public static void main(String[] args) {
	//	MirrorImage mi=new MirrorImage();
		Scanner in=new Scanner(System.in);
		//Node foundnode;
		List<String> Nodes=new ArrayList<>();
		List<String> queries=new ArrayList<>();
		String[] sizes=in.nextLine().split("\\s");
		for(int i=0;i<Integer.parseInt(sizes[0])-1;i++)
			Nodes.add(in.nextLine());
		for(int i=0;i<Integer.parseInt(sizes[1]);i++)
			queries.add(in.nextLine());
		
		in.close();
		Node root=new Node(1,null,null,null);
		Node current_node=null;
		
		
		for(int i=0;i<Nodes.size();i++)
		{
		//System.out.println(Nodes.get(i));
		String[] data=Nodes.get(i).split("\\s");
		//System.out.println(data[0]);
		findnode(data[0],root);
		current_node=foundnode;
		if(data[2].equalsIgnoreCase("L"))
			current_node.left=new Node(Integer.parseInt(data[1]),null,null,current_node);
		else
			current_node.right=new Node(Integer.parseInt(data[1]),null,null,current_node);
				
		}
		
		
		for(int q=0;q<queries.size();q++)
		{
			
			Stack<String> path=new Stack<>();
			findnode(queries.get(q),root);
			if(foundnode==root)
				{System.out.println(root.data);continue;}
			while(foundnode!=root)
			{
				if(foundnode.parent.left==foundnode)
				{
					/* System.out.println("Left"); */path.push("Left");foundnode=foundnode.parent;}
				else
				{
					/* System.out.println("Right"); */path.push("Right");foundnode=foundnode.parent;}
					
			}
			Node n=root;
			while(!path.isEmpty() && n!=null)
			{	
				if(path.pop().contentEquals("Left"))
					n=n.right;
				else
					n=n.left;
					
			}
			if(n==null)
				System.out.println("-1");
			else
				System.out.println(n.data);
		}
		
}
}
