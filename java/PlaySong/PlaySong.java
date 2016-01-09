package PlaySong;

import java.util.ArrayList;

import stdlib.StdAudio;
import stdlib.StdIn;
import stdlib.StdOut;

// Patrick Krebs 

public class PlaySong {
	
	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<Double>();
		
		StdOut.print("Enter a file pathname: ");
		String filename = StdIn.readString();
		StdIn.fromFile(filename);
		while (!StdIn.isEmpty()) {
			double value = StdIn.readDouble();
			list.add(value);
		}

		for (double value: list) {
			playTone(value, .25);

		}
		
	    StdAudio.close();
        System.exit(0);

	}

}
