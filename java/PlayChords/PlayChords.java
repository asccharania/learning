package PlayChords;

// Patrick Krebs 

import java.util.ArrayList;

import stdlib.StdAudio;
import stdlib.StdOut;

	public class PlayChords { 

		public static void playChord(double duration, double... frequencies) {
			final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
			final double[] slices = new double[sliceCount+1];
				for (int i = 0; i <= sliceCount; i++) {
					for (double frequency: frequencies ) {
					slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
					}
					slices[i] /= frequencies.length;
				}
			StdAudio.play(slices);}
	
	
		
		public static void main(String[] args) {
			 // Standard North American dial tone
			playChord(1.0, 350.0, 440.0);

			// Standard North American ring back tone
			for (int i = 0; i < 5; i++) {
				playChord(2.0, 440, 480);
				playChord(4.0, 0);
			}

			// Standard North American busy tone
			for (int i = 0; i < 5; i++) {
				playChord(0.5, 480, 620);
				playChord(0.5, 0);
			}

			// Play a C major triad chord
			double[] cMajorChord = {261.63, 293.66, 329.63};
			playChord(1.0, cMajorChord);

			// Play a half diminished chord
			double[] halfDiminishedChord = {130.81, 155.56, 185.0, 233.08};
			playChord(1.0, halfDiminishedChord);

			StdAudio.close();
			System.exit(0);
		}
	}
