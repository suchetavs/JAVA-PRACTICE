import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Debug {

	public static void main(String[] args) {
		String lol="lion";
		Pattern p=Pattern.compile("(["+lol+"].{3,}?["+lol+"])");
		Matcher m=p.matcher("qploresinazxrhqknhoilerthf");
		
		 //for (int i = 0; m.find(i); i = m.start() + 1)
		
		int start=0;
		while(m.find(start)) {
			System.out.println(m.group()+" ");
			start=m.start()+1;
		}
	//	System.out.println(m.end());
		

	}
}
	


