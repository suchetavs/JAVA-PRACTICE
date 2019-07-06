package Practice;

import java.util.Scanner;

public class TreeQueries {

	public static void main(String[] args) {
		int node_size, query_size;
		String input;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		String[] data1=input.split("\\s");
		node_size = Integer.parseInt(data1[0]);
		query_size = Integer.parseInt(data1[1]);
		String[] nodes = new String[node_size];
		String[] queries = new String[query_size];
		//ArrayList<Node1> nodelist = new ArrayList<>();
		nodes = in.nextLine().split("\\s");
		for (int i = 0; i < query_size; i++) {
			queries[i] = in.nextLine();
		}
		in.close();
		for (int q_iter = 0; q_iter < query_size; q_iter++) {
			
			String[] query_parts=queries[q_iter].split("\\s");
			int index=findXfLV(query_parts);
			
			char qtype = queries[q_iter].charAt(0);
			switch(qtype) {
			case '1' : 
			if(index==-1) continue;
			 System.out.println(nodes[index]);break;
			case '2' :
				sumLtR(query_parts, nodes);break;
			case '3' : 
				if(index==-1) continue;
				String data = query_parts[3];
				nodes[index] = data;
				break;
				
			}
				

		}
	}

	private static void sumLtR(String[] query_parts, String[] nodes) {
		int l = Integer.parseInt(query_parts[1]);
		int r = Integer.parseInt(query_parts[2]);
		int s_index = (int) ((Math.pow(2, l - 1)) - 1);
		int l_index = (int) ((Math.pow(2, r)) - 1);
		int sum = 0;
		for (int i = s_index; i < l_index && i < nodes.length; i++)
			sum += Integer.parseInt(nodes[i]);
		System.out.println(sum);
	}

	private static int findXfLV(String[] query_parts) {
		int level = Integer.parseInt(query_parts[2]);
		int node_pos = Integer.parseInt(query_parts[1]);
		// Node1 start=root;
		// int l=0;
		int s_index = (int) (Math.pow(2, level - 1) - 1);
		int l_index = (int) (Math.pow(2, level) - 1);
		if ((s_index + node_pos) <= l_index)
			return s_index + node_pos - 1;
		else
			return -1;

	}


}
