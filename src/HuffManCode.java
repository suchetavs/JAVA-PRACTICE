
public class HuffManCode {

	
	
	class Node{
	public  int frequency; // the frequency of this tree
	public  char data;
	public  Node left, right;
	}
	
	
	boolean isleaf(Node node) {
		if(node.left==null && node.right==null)
			return true;
		return false;
	}
	
	void decode(String s, Node root) {
		String ans="";
        Node node=root;
        char[] code=s.toCharArray();
        for(char c:code) {
        	if(c=='0')
        		node=node.left;
        	else
        		node=node.right;
        	if(isleaf(node))
        		{
        		ans+=node.data;
        		node=root;
        		}
        	
        	        	
        	
        }
        System.out.println(ans);
	}
       
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
