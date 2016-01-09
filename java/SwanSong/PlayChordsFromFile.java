package SwanSong;

// Patrick Krebs

import algs13.Queue;
import stdlib.*;

public class PlayChordsFromFile {

	public static void main(String[] args) {
		StdOut.print("Please enter the pathname: ");
		String textSource = StdIn.readLine();
	
        final In in = new In(textSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + textSource);
            System.exit (1);
        }
        
        Queue<Chord> chords = new Queue<Chord>();
        
        while(!(in.isEmpty())){
        	Double duration = new Double(in.readLine());
      	    String[] inputValues = in.readLine().split("\\s+");
      	    double[] frequencies = new double[inputValues.length];
      	    for (int i = 0; i < frequencies.length; i++) {
      	      frequencies[i] = Double.parseDouble(inputValues[i]);
      	    }
      	    Chord c = new Chord(duration, frequencies );
      	    chords.enqueue(c);
        }
        
        while (!(chords.isEmpty())){
        	Chord c = chords.dequeue();
        	c.play();
        }
	}
}
