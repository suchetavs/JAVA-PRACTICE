package Practice;

import java.util.Scanner;

public class AVLTree {
	String output="";
	public void makeTree(Node node,int data,String direction)
	{
		if(data<node.data)
			if(node.left==null)
				{node.left=new Node(data,null,null);
				return;
				}
			else
				makeTree(node.left,data,null);
		
		if(data>node.data)
			if(node.right==null)
				{node.right=new Node(data,null,null);
				return;
				}
			else
				makeTree(node.right,data,null);
	}
		
		
	public void preorder(Node root) {
				
		if(root==null)
			return;
		if(Math.abs(find_height(root.left)-find_height(root.right))>1)
		{
			System.out.println("NOT");
			System.exit(0);
		}
		output+=(root.data+" ");
		
		
		preorder(root.left);
		preorder(root.right);
		
		
		
	}
	
	
	public int find_height(Node node) {
		if(node==null)
			return 0;
		
		return (1+Math.max(find_height(node.left), find_height(node.left)));
	}
			
	

	public static void main(String[] args) {
		Node head=null;
		AVLTree tree=new AVLTree();
		Scanner in=new Scanner(System.in);
		String data_read=in.nextLine();
		String[] input=data_read.substring(0, data_read.length()-2).split("\\s");
		
		for(int i=0;i<input.length;i++)
		{
			int data=Integer.parseInt(input[i]);
			if(head==null)
				head=new Node(data,null,null);
			tree.makeTree(head,data,null);
			
			
		}
		
		tree.preorder(head);
		System.out.println(tree.output);
		System.out.println(tree.find_height(head));
		

	}

}
