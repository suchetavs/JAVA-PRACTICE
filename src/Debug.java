import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Debug {

	public static void main(String[] args) {
		Pattern p=Pattern.compile("(\\(\\))");
		Matcher m=p.matcher("(F (B (A) (D (C) (E))) (G () (I (H))))");
		
		 //for (int i = 0; m.find(i); i = m.start() + 1)
		
		if(m.find(5))
			System.out.println(m.group());
		System.out.println(m.end());
		

	}
}
	


