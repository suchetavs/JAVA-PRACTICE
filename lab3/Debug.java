package lab3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Debug {

	public static void main(String[] args) {
		String input="(F(BS (AD) (78 (C) (E))) (G (I (H) ())))";
		String regex="\\([A-Z0-9]*\\)";
		Matcher m=Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(input);
		
		
		
//head.data=String.valueOf(nodes.charAt(1));
		
		
		/*int start=2;
		while(start<input.length()){
			
			
			if(m.find(start) && input.charAt(m.end())!=')')
				{
				//String node_data=m.group();
				
				//System.out.println(m.start()+" "+m.end());
				System.out.println(m.group());
				start=m.end()+1;
				}
			else if(m.find(start) && input.charAt(m.end())==')')
			{
				start++;
				//System.out.println(m.group());
			}
			else
				start++;
		}

	}*/

		System.out.println("()".subSequence(1, 1));
		
}
}