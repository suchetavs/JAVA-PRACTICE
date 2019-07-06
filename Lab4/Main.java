
package Lab4;
import java.util.Scanner;

public class Main {
	String res="";
	String preorder="";
	int l_height,r_height;

	public void insert(Node node,Node parent,String direction,int data,int height) {
		//max_height=height;
		if(node==null && direction.equals("left"))
		{
			parent.left=new Node(data,null,null,height+1);
			return;
			
		}
		
		if(node==null && direction.equals("right"))
		{
			parent.right=new Node(data,null,null,height+1);
			return;
			
		}
				
		if(data<node.data)
		{
			
			insert(node.left,node,"left",data,node.height);
		}
		else if(data>node.data)
		{	insert(node.right,node,"right",data,node.height);
		
		}
		
		
		
	}
	
	

	
	public void preorder(Node node,String direction) {
				
		if(node==null)
			return;
		
		if(direction==null)
			preorder+=node.data+" ";
		
		else if(direction.equalsIgnoreCase("left")) {
			l_height=node.height;
		}
		
		else if(direction.equalsIgnoreCase("right")) {
			r_height=node.height;
		}
			
		
		preorder(node.left,direction);
		preorder(node.right,direction);
		
		
	}
	
	public void find_avl(Node node) {
		//System.out.println(res);
		if(node.left==null || node.right==null)
			return;
		System.out.println(((l_height-node.left.height)-(r_height-node.right.height)));
		
		if(Math.abs(((l_height-node.left.height)-(r_height-node.right.height)))>1)
			{
			
			res="NOT";
			//return;
			}
		
		find_avl(node.left);
		find_avl(node.right);
		
				
	}
		
	
	
	
	public static void main(String[] args) {
		Main m=new Main();
		Scanner in=new Scanner(System.in) ;
		String data= in.nextLine();
		String[] data_array =data.split("\\s");
		Node head=new Node(Integer.parseInt(data_array[0]),null,null,0);
		//current_node=head;
						
		
		for(int i=1;i<data_array.length-1;i++) {
			
			int value=Integer.parseInt(data_array[i]);
			//System.out.println(value);
			m.insert(head,null,null,value,0);		
						
			
		}
		
		m.preorder(head,null);
		
		m.preorder(head.left,"left");
		m.preorder(head.right,"right");
		m.l_height--;
		m.r_height--;
				
		System.out.println(m.l_height+" "+m.r_height);
		m.find_avl(head);
		//System.out.println();
		
		if(!m.res.equals("NOT"))
			System.out.println(m.preorder.substring(0, m.preorder.length()-1));
		else
			System.out.println("NOT");
		
		
		
		
	}

}
