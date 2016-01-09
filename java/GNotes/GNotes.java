package GNotes;

import stdlib.StdAudio;

//Patrick Krebs 

public class GNotes {

	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

	public static void main(String[] args) {
		playTone(392.0, 1.5);
		playTone(784.0, 1.5);
		playTone(1568.0, 1.5);
	    StdAudio.close();
        System.exit(0);
	}
}
