package Lab5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String input=in.nextLine();
		String sample=in.nextLine();
		char[] letters=sample.toCharArray();
		for(int l=sample.length()-2;l<input.length();l++) {
			
			Pattern p=Pattern.compile("(["+sample+"].{"+l+"}["+sample+"])");
			Matcher m=p.matcher(input);
			int start=0;
			while(m.find(start))
			{
				int find_flag=0;
				String substr=m.group();
				//System.out.println(substr);
				for(char c:letters)
				{
					if(substr.contains(String.valueOf(c)))
						continue;
					else
					{
						find_flag=1;
						break;
					}
				}
				if(find_flag==0)
					{System.out.println(substr);
					System.exit(0);}
					
				start+=1;
				}
				
			}
		
		
		
		}

	}


