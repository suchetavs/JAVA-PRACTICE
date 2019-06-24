import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNodes {
	
	class Node{
		int data;
		Node left;
		Node right;
		int height;
		
		public Node(int data, Node left, Node right, int height) {
			
			this.data = data;
			this.left = left;
			this.right = right;
			this.height = height;
		}
				
	}
	
	
	public HashMap<Node,Integer> in_order(Node node,HashMap<Node,Integer> s) {
		
		if(node==null)
			return s;
		in_order(node.left,s);
		//System.out.print(node.data+" ");
		s.put(node,node.data);
		//System.out.println(s);
		in_order(node.right,s);
		
		return s;
		
	}
	
	
	
	
	 int[][]  swapNodes(int[][] indexes , int[] queries ) {
		
		int[][] result=new int[queries.length][indexes.length];
		HashMap<Node,Integer> inOrder=new LinkedHashMap<Node,Integer>();
		int size=indexes.length,maxh=0;
		HashMap<Integer,List<Node>> nodeH=new HashMap<>();
		Queue<Node> treeNodes=new LinkedList<>();
		Node root=new Node(1,null,null,1);
		treeNodes.add(root);
		for(int i=0;i<size;i++) {
			Node current_node=treeNodes.remove();
			maxh=current_node.height;
			
			if(nodeH.containsKey(maxh))
			{
				List<Node> current_list=nodeH.get(maxh);
				current_list.add(current_node);
				nodeH.put(maxh, current_list);
			}
			else
			{
				List<Node> current_list=new ArrayList<>();
				current_list.add(current_node);
				nodeH.put(maxh,current_list);
			
			}
			current_node.left=(indexes[i][0]==-1)?(null):(new Node(indexes[i][0],null,null,current_node.height+1));
			current_node.right=(indexes[i][1]==-1)?(null):(new Node(indexes[i][1],null,null,current_node.height+1));
			if(current_node.left!=null)
				treeNodes.add(current_node.left);
			if(current_node.right!=null)
				treeNodes.add(current_node.right);
		
		
		}
		int count=-1;
		for(int c:queries)
		{
			count++;
			inOrder.clear();
			for(int i=1;i<=maxh;i++) {
				if(i*c<maxh)
				{	List<Node> nodeList =nodeH.get(i*c);
					for(Node node:nodeList)
					{
						Node temp=node.left;
						node.left=node.right;
						node.right=temp;
					}
					
				}
				else
				{
				
				in_order(root,inOrder);
				for(int k=0;k<inOrder.size();k++)
				{
					result[count][k]=(int)inOrder.values().toArray()[k];
				}
				//System.out.println();
				break;
				}
			}
				
		}
		
		return result;
	
        
    }
	
		
	
	public static void main(String[] args) {
		SwapNodes swap=new SwapNodes();
		
		int[][] indexes= new int[][] {{2,3},{4,-1},{5,-1},{6,-1},{7,8},{-1,9},{-1,-1},{10,11},{-1,-1},{-1,-1},{-1,-1}};
		int[] queries=new int[] {2,4};
		int[][] result=swap.swapNodes(indexes,queries);
		/*
		 * for(int i:result[1]) System.out.print(i+" "); System.out.println(); for(int
		 * i:result[0]) System.out.print(i+" ");
		 */
		//System.out.println(result[0]);
		//System.out.println(result[1]);

	}

}
