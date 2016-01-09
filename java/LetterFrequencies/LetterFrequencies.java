package LetterFrequencies;

import stdlib.*;

// Patrick Krebs 

public class LetterFrequencies {

	public static void main(String[] args) {
		StdOut.print("Please enter the pathname or URL of the book file: ");
		String textSource = StdIn.readLine();
	
        final In in = new In(textSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + textSource);
            System.exit (1);
        }
        
        final String bookText = in.readAll();
        String[] bookWords = bookText.split("\\s+");
        int[] l = new int[26];
        for (String i: bookWords){
        	 for (char ch : i.toCharArray()){
                	l[((int)ch - 97 )] += 1; 
        	    }
        }
        StdOut.println("Letter frequencies in " + textSource);
        for (int u = 0; u < 26; u++){
        	StdOut.printf("%c\t%,10d%n", (char)(u + 97),l[u]);
        }
       };
}
