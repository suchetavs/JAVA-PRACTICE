package Lab3;

import java.util.Comparator;
import java.util.List;

public class ListComparator implements Comparator<String> {

	    private final List<String> orderedList;
	  //  private boolean appendFirst;

	    public ListComparator(List<String> orderedList) {
	        this.orderedList = orderedList;
	        //this.appendFirst = appendFirst;
	    }

	    //will compare by taking o1 and o2 to be knodes
	    @Override
	    public int compare(String o1, String o2) {
	    	//System.out.println(o1+" "+o2);
	        if (orderedList.contains(o1) && orderedList.contains(o2))
	            {
	        //	System.out.println(orderedList.indexOf(o1));
	        //	System.out.println(orderedList.indexOf(o2));
	        	return orderedList.indexOf(o2) - orderedList.indexOf(o1);
	            
	            }
		/*
		 * else if (orderedList.contains(o1)) return (appendFirst) ? 1 : -1; else if
		 * (orderedList.contains(o2)) return (appendFirst) ? -1 : 1;
		 */
	        return 0;
	    }
	}

	

