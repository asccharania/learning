package week1examples;

import stdlib.StdAudio;

public class SITTones {

	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

	public static void main(String[] args) {
		playTone(27.5, 1);
		
		
		playTone(950.0, 0.4);
		playTone(1400.0, 0.4);
		playTone(1800.0, 0.4);
	    StdAudio.close();
        System.exit(0);
	}

}
