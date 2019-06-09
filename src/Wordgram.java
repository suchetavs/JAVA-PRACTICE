import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Wordgram {

	public static void main(String[] args) {
	 Scanner in=new Scanner(System.in);
	 String data="";String line = null;
	 List<String> lines=new ArrayList<>();
	 while(in.hasNextLine())
	 {
		line=in.nextLine();
		if(line.isEmpty())
		break;
		
		lines.add(line);
	 	 
	}
	 HashMap<String,Integer> gram_freq=new HashMap<>();

	 int gram_length=Integer.parseInt(lines.get(lines.size()-1));
	 String regex="([A-Za-z]{"+gram_length+"})";

	 
	 for(int i=1;i<lines.size()-1;i++) {
		 	 
			 	Pattern p=Pattern.compile(regex);
				Matcher m=p.matcher(lines.get(i));
				for (int mat = 0; m.find(mat); mat = m.start() + 1) {
				        if(gram_freq.containsKey(m.group()))
							  gram_freq.replace(m.group(),gram_freq.get(m.group()), gram_freq.get(m.group())+1);
				        else
							  gram_freq.put(m.group(), 1);
				        
				    }
	 
		 }
		 	 
	 
	 
	 List<String> ans = new ArrayList<>();
	 Integer max=Collections.max(gram_freq.values());
	// System.out.println(max);
	
	 for( Entry<String,Integer> ent:gram_freq.entrySet()) {
		 if(ent.getValue()==max)
			 ans.add(ent.getKey());
			 
		 	 }
	 
	 String final_ans;
	 if(ans.size()==1)
		 final_ans=ans.get(0);
	 else
	 {
		 Collections.sort(ans);
		 final_ans=ans.get(0);
	 }
	 
	 switch(gram_length) {
	 
	 	case 1: System.out.println("Unigram "+final_ans);
	 			break;
	 	case 2: System.out.println("Bigram "+final_ans);
	 			break;
	 	case 3: System.out.println("Trigram "+final_ans);
	 			break;
			 
	 }
	}
}
