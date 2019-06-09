package Lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreeTraversal {
	List<String> k_nodes=new ArrayList<String>();
	Node head=null;
	Node target_node=null;
	int distance;
	
	public void MakeTree(String input) {
		int index = 0;
		
		Node current_node = null;	
		
				
		Matcher m=Pattern.compile("([A-Za-z0-9]+)").matcher(input);
		System.out.println(input);
		if(m.find(1))
			{
			head=new Node(m.group(),null,null,null);
			current_node=head;
			index=m.end();
			}
		
		
		while(index<input.length()) {
		char data=input.charAt(index);
			if(data==' ')
			{
				index++;
				continue;
			}
			if(data=='(')
			{
				Node blank_node=new Node("Null",null,null,current_node);
				if(current_node.left==null)
					current_node.left=blank_node;
				else
					current_node.right=blank_node;
				current_node=blank_node;
				index++;
				continue;
			}
			
			if(data==')')
			{
				current_node=current_node.parent;
				++index;
				continue;
			}
			else
			{
				String str="";
				for(;String.valueOf(input.charAt(index)).matches("[A-Za-z0-9]");index++)
					str+=String.valueOf(input.charAt(index));
				//new_node=new Node(str,null,null,current_node);
				current_node.data=str;
					
			}
		}
		level_order(head);
		}
	
		
	public void level_order(Node node) {
		
		Queue<Node> q=new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			if(!q.element().data.equalsIgnoreCase("null"))
				System.out.print(q.element().data+" ");
			if(q.element().left!=null)
				q.add(q.element().left);
			if(q.element().right!=null)
				q.add(q.element().right);
			q.remove();
		}
		
		
	}
	
	
	public  void find_node(Node node,String data) {
		//System.out.println("Searching for "+data);
		if(node==null)
			return;
		//System.out.println(node.data);
		if(node.data.equals(data))
		{
			target_node=node;
			//System.out.println("Node found ");
		}
		
		find_node(node.left,data);
		find_node(node.right,data);
				
		
	}
	

	public void movedown(Node node,int dist) {
		
		if(node==null || node.data.equalsIgnoreCase("null"))
		{
			//++dist;
			return;
		}
		
		if(dist==0)
		{
			k_nodes.add(node.data);
			System.out.println("In move down "+node.data);
			System.out.println(k_nodes);
			return;
		}
		
		movedown(node.left,--dist);
		++dist;
		movedown(node.right,--dist);
		
		
	}
	
	
	public void nodeAtk(String node, int distance) {
		System.out.println(k_nodes);
		find_node(head,node);
		movedown(target_node,distance);
		while(distance>0 && target_node!=head ) {
			Node current_node=target_node.parent;
			--distance;
			if(distance==0)
				{k_nodes.add(current_node.data);System.out.println("In while loop "+current_node.data);break;}
			if(current_node.left==target_node)
				movedown(current_node.right,distance-1);
			else
				movedown(current_node.left,distance-1);
			target_node=current_node;
			
		}
		System.out.println(k_nodes);
			
	}
		
	
	public static void main(String[] args) {
		TreeTraversal tree=new TreeTraversal();
		
		Scanner in =new Scanner(System.in);
		List<String> lines=new ArrayList<String>();
		for(int i=0;i<4;i++)
			lines.add(in.nextLine());
		System.out.println(lines.get(0));
		in.close();
		tree.distance=Integer.parseInt(lines.get(2));
		
		tree.MakeTree(lines.get(0));
		tree.nodeAtk(lines.get(1), tree.distance);
		

}
			
}




	


