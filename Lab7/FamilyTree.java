package Lab7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class FamilyTree {
	static Node foundNode;
	static Queue<String> preorder=new LinkedList<>();
	static Queue<String> relations=new LinkedList<>();
	static boolean desf=false,ancestorf=false;
	static class Node{
		String data;
		Node left,right,parent;
		public Node(String data, Node left, Node right, Node parent) {
			
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		
		
	}
	public static void findNode(String data,Node root) {
		
		if(root==null)
			return;
		if(root.data.equalsIgnoreCase(data))
			foundNode=root;
		findNode(data,root.left);
		findNode(data,root.right);

		
		
	}
public static void preOrder(Node root) {
		
		if(root==null)
			return;
		
		if(!preorder.contains(root.data))
			preorder.add(root.data);
			
		preOrder(root.left);
		preOrder(root.right);
	}

public static void preOrderCustom(Node root,String data) {
	if(root==null)
		return;
	if(root.data.equalsIgnoreCase(data))
		{desf=true;ancestorf=true;return;}
			
	preOrderCustom(root.left,data);
	preOrderCustom(root.right,data);
}

public static void resetvars() {
	foundNode=null;
	desf=false;
	ancestorf=false;
}



private static void ancestor(String[] data, Node root) {
	findNode(data[0],root);
	if(foundNode==null)
		relations.add("F");
	else {
	preOrderCustom(foundNode,data[2]);
	if(ancestorf)
		relations.add("T");
	else
		relations.add("F");
	}
		
}
private static void sibling(String[] data, Node root) {
	Node node1,node2;
	findNode(data[0],root);
	node1=foundNode;
	findNode(data[2],root);
	node2=foundNode;
	if(node1==null|| node2==null)
		relations.add("F");
	else
	{
		if(node1.parent==node2.parent)
			relations.add("T");
		else
			relations.add("F");
	}
	
}

private static void descendant(String[] data, Node root) {
	findNode(data[2],root);
	if(foundNode==null)
		relations.add("F");
	else {
	preOrderCustom(foundNode,data[0]);
	if(ancestorf)
		relations.add("T");
	else
		relations.add("F");
	}
	
}
private static void child(String[] data, Node root) {
	
	findNode(data[2],root);
	if(foundNode==null)
		relations.add("F");
	else
	{
		if(foundNode.left!=null && foundNode.left.data.equalsIgnoreCase(data[0]))
			relations.add("T");
		else if (foundNode.right!=null && foundNode.right.data.equalsIgnoreCase(data[0]))
			relations.add("T");
		else
			relations.add("F");
	}
	
	
}

	
	
	
	
	public static void main(String[] args) {
		String preorders="",relation="";
		Node current_parent=null;
		Scanner in=new Scanner(System.in);
		Node root = null;
		int count=Integer.parseInt(in.nextLine());
		for(int i=0;i<count;i++)
		{
			foundNode=null;
			if(root==null)
			{
			String[] data=in.nextLine().split("\\s");
			root=new Node(data[0],null,null,null);
			if(data.length>1)
				root.left=new Node(data[1],null,null,root);
									
			}
			else
			{
				String[] data=in.nextLine().split("\\s");
				findNode(data[0],root);
				current_parent=foundNode;
				if(foundNode!=null) {
				if(foundNode.left==null)
					foundNode.left=new Node(data[1],null,null,foundNode);
				else
					foundNode.right=new Node(data[1],null,null,foundNode);
				}
					
			}
		}
		preOrder(root);
		Iterator<String> iter=preorder.iterator();
		while(iter.hasNext())
			preorders+=(preorder.remove()+" ");
		
		int q_count=Integer.parseInt(in.nextLine());
		for(int i=0;i<q_count;i++)
		{
			resetvars();
			String[] data=in.nextLine().split("\\s");
			switch (data[1]) {
			
			case "child": child(data,root);
			break;
			case "descendant": descendant(data,root);
			break;
			case "sibling": sibling(data,root);
			break;
			case "ancestor": ancestor(data,root);
			break;
			default: relations.add("F");
			break;
			
			
			}
				
				
		}
		Iterator<String> iter2=relations.iterator();
		while(iter2.hasNext())
			relation+=(relations.remove()+" ");
		if(relation.length()>0)
			{System.out.print(relation.substring(0, relation.length()-1));
			System.out.println();}
			
		
		
		if(preorders.length()>0)
			{System.out.print(preorders.substring(0, preorders.length()-1));
			System.out.println();}
		
				
		}
	
	}


