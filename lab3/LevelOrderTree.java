package lab3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.reflect.generics.tree.Tree;

public class LevelOrderTree {

	public void preOrder(Node head) {
		
		if(head==null)
			return;
		if(head.data!="")
			System.out.println(head.data);
		
		preOrder(head.left);
		preOrder(head.right);
		
			
	}
	

	
	
	public static void main(String[] args) {
		
		LevelOrderTree tree=new LevelOrderTree();
		
		Node head=new Node(null,null,null,1,null);
		Node current_node;
		String input="(F (B (A) (D (C) (E))) (G () (I (H) ())))";
		String regex1="\\([A-Z0-9]*";
		String regex2="\\([A-Z0-9]*\\)";
		Matcher m1=Pattern.compile(regex1, Pattern.CASE_INSENSITIVE).matcher(input);
		Matcher m2=Pattern.compile(regex2, Pattern.CASE_INSENSITIVE).matcher(input);
		Scanner in=new Scanner(System.in);
		ArrayList<String> lines=new ArrayList<String>();
		
		/*while(in.hasNext()) {
			String data=in.nextLine();
			if(data.isEmpty())
				break;
			else
				lines.add(data);
			}*/
		in.close();
		
		//input=lines.get(0);
		head.data=String.valueOf(input.charAt(1));
		current_node=head;
		
		
		int start=2;
		while(start<input.length()){
			
			
			if(m1.find(start) && m1.end()<input.length() && input.charAt(m1.end())!=')')
				{
				String data=m1.group();
				Node new_node=new Node(data.substring(1),null,null,current_node.height+1,current_node);
				if(current_node.left==null)
					current_node.left=new_node;
				else
					current_node.right=new_node;
				current_node=new_node;
				start=m1.end()+1;
				}
						
			else if(m2.find(start))
			{
				String data=m2.group();
				Node new_node=new Node(data.substring(1,data.length()-1),null,null,current_node.height+1,current_node);
				
					if(current_node.left==null)
						current_node.left=new_node;
					else
						current_node.right=new_node;
								
				start=m1.end();
			
			}
			
			else if(input.charAt(start)==')')
				{
				current_node=current_node.parent;
				++start;
				}
			else
				++start;
		}
		
		
		tree.preOrder(head);

	}

}
