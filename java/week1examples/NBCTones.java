package week1examples;

import stdlib.StdAudio;

public class NBCTones {
	
	public static void playTone(double frequency, double duration) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

	public static void main(String[] args) {
		playTone(196.0, 1.0);
		playTone(329.6, 1.0);
		playTone(261.6, 1.0);
	    StdAudio.close();
        System.exit(0);
	}

}

