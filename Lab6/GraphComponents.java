package Lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphComponents {
	static List<String> datalist=new ArrayList<String>();
	public static void traverse(List<Node> nodelist) {
		int count=0;
		
		for(Node node: nodelist)
		{
			
			if(!datalist.contains(node.data))
				datalist.add(node.data);
			
			for(Node neighbor:node.neighbours)
				if(!datalist.contains(neighbor.data))
					datalist.add(neighbor.data);
		}
		
		for(String data:datalist)
			System.out.println(data);
		
				
	}
	
	public static void DFS(Node node,List<Node> nodelist) {
		//int count=0;
		/*if(node.status.equalsIgnoreCase("v"))
			return;*/
		node.status="v";
		for(Node neighbor:node.neighbours)
		{
			if(!neighbor.status.equalsIgnoreCase("v")) {
				neighbor.status="v";
				DFS(neighbor,neighbor.neighbours);
			}
		}
		
		return;
		
		
	}
	
	
	
	public static void main(String[] args) {
		int result = 1;
		Scanner in=new Scanner(System.in);
		String vertices=in.nextLine();
		String edges=in.nextLine();
		List<Node> nodelist=new ArrayList<>();
				
		for(int i=0;i<Integer.parseInt(edges);i++) {
			int flag1=0,flag2=0;
			String input=in.nextLine();
			String data1=input.split("\\s")[0];
			String data2=input.split("\\s")[1];
			Node node1=null,node2=null;
			for(int n=0;n<nodelist.size();n++) {
				if(nodelist.get(n).data.equalsIgnoreCase(data1))
					{flag1=1;node1=nodelist.get(n);}
				if(nodelist.get(n).data.equalsIgnoreCase(data2))
					{flag2=1;node2=nodelist.get(n);}
			}
			if(flag1==0)
				{node1=new Node(data1,new ArrayList<Node>(),"unvisited");nodelist.add(node1);}
			if(flag2==0)
				{node2=new Node(data2,new ArrayList<Node>(),"unvisited");nodelist.add(node2);}
			
			node1.addNeighbour(node2);
			node2.addNeighbour(node1);
		}
				
		//System.out.println(nodelist);
		int count=0;
		for(Node n:nodelist) {
		if(!n.status.equalsIgnoreCase("v"))
				{DFS(n,nodelist);count++;}
		}	
		
		
		
		
		count=count+Integer.parseInt(vertices)-nodelist.size();
		if(count>1)
			result=0;
		System.out.println(result+" "+count);
			
		}
		

}
