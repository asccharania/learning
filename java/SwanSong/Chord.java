package SwanSong;

// Patrick Krebs

import java.lang.reflect.Array;

import stdlib.StdAudio;

public class Chord {
	private Double duration;
	double[] frequencies = new double[10];
	
	public Chord(double d, double... f){
		duration = d;
		for (int x = 0; x < f.length; x++) {
			frequencies[x] = f[x];
		}
	}
	
	public void play() {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
			for (int i = 0; i <= sliceCount; i++) {
				for (int x = 0; x < Array.getLength(frequencies); x++) {
				double frequency = Array.getDouble(frequencies, x);
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
				}
				slices[i] /= Array.getLength(frequencies);
			}
		StdAudio.play(slices);
		}
	
	public double duration() {
		return duration;
	}
	
	public double[] frequencies(){
		double[] b = new double[Array.getLength(frequencies)];
		System.arraycopy(frequencies, 0, b, 0, Array.getLength(frequencies));
		return b;
	}
	
	public String toString() {
		String s = new String(duration + " " + frequencies);
		return s;
	}
	
	public boolean equals(Chord that){
		if (this.frequencies == that.frequencies ){
			return true;
		} else {
			return false;
		}
	}
}
