package ParseXML2;

import java.util.ArrayList;

import algs13.Stack;
import stdlib.*;

// Patrick Krebs 

public class ParseXML {

	public static void main(String[] args) {
		StdOut.print("Please enter the pathname: ");
		String textSource = StdIn.readLine();
	
        final In in = new In(textSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + textSource);
            System.exit (1);
        }
        
        ArrayList<XMLToken> xmlText = new ArrayList<XMLToken>();
        
        while(!(in.isEmpty())){
        	XMLToken x = new XMLToken(in.readString());
        	xmlText.add(x);
        }
        
   
        Stack<String> tagName = new Stack<String>();
        
        for (XMLToken x: xmlText){
        	if(x.isOpeningTag()){
        		StdOut.println(x);
        		tagName.push(x.tagName());
        	} 
        	else if (x.isClosingTag()){
        		StdOut.println(x);
        		if (tagName.isEmpty()){
        			StdOut.println("Closing Tag "+x+" does not have a matching opening tag.");
                    System.exit (1);
        		}
        		if (!(x.tagName().equals(tagName.pop()))){
        			StdOut.println("Closing Tag "+x+" does not have a matching opening tag.");
                    System.exit (1);
        		}
        	}
        	else {
        		StdOut.println(x);
        	}
        }
        if (!(tagName.isEmpty())){
        	StdOut.println("There are opening tags with no matching closing tag.");
        }
	}
}
