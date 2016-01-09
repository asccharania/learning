package ParseXML;

import java.util.ArrayList;

import stdlib.*;

// Patrick Krebs 

public class CountTokens {

	public static void main(String[] args) {
		StdOut.print("Please enter the pathname: ");
		String textSource = StdIn.readLine();
	
        final In in = new In(textSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + textSource);
            System.exit (1);
        }
        
        ArrayList<String> xmlText = new ArrayList<String>();
        
        while(!in.isEmpty()){
        	xmlText.add(in.readString());
        }
        
        int wordCount = 0; 
        int openCount = 0; 
        int closeCount = 0; 
        int otherCount = 0; 
        
        for (String word: xmlText){
        	XMLToken t = new XMLToken(word);
        	if (t.isWord()){wordCount += 1;
        	} else if (t.isOpeningTag()){openCount += 1;
        	} else if (t.isClosingTag()){closeCount += 1;
        	} else {otherCount += 1;}
        }
        
        StdOut.println("There are " + wordCount + " words.");
        StdOut.println("There are " + openCount + " open tags.");
        StdOut.println("There are " + closeCount + " close tags.");
        StdOut.println("There are " + otherCount + " malformed tokens.");

	}

}
