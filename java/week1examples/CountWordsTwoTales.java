package week1examples;

import stdlib.*;

public class CountWordsTwoTales {

	public static void main(String[] args) {
    	String textSource = "data/twotales.txt";
        final In in = new In(textSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + textSource);
            System.exit (1);
        }

        final String bookText = in.readAll();
        String[] bookWords = bookText.split("\\s+");
        StdOut.println ("There are " + bookWords.length + " words in " + textSource + ".");
    }

}
