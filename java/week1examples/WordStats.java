package week1examples;

import stdlib.*;

public class WordStats {

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
		int wordLengthSum = 0;
        for (String word: bookWords) {
        	wordLengthSum += word.length();
        }
        StdOut.println ("There are " + bookWords.length + " words in " + textSource + ".");
		StdOut.println("The length of the average word is " + (double)wordLengthSum/bookWords.length + ".");

    }


}
