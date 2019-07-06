package Lab2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ngram {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int num_lines=in.nextInt();
		String data="";
		//System.out.println(data.length);
		//data=in.next().split("\\n");
		while(in.hasNext()) {
			
			String line=in.nextLine();
			if(line.isEmpty())
				break;
			data+=line;
			
		}
		System.out.println(data);
		
	/*	int gram_size=Integer.parseInt(data[data.length-1]);
		
		HashMap<Integer,String> map=new HashMap<>();
		
		for(int i=0;i<data.length;i++) {
			
			Pattern p=Pattern.compile("[A-Za-z]+");
			Matcher m=p.matcher(data[i]);
			if(m.matches())
				System.out.println(m.group());
			
			
		}*/
		
		
		

	}

}
