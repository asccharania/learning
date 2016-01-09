package Music;

// Patrick Krebs 

import stdlib.StdAudio;


public class EqualTemperedFrequency implements Comparable<EqualTemperedFrequency> {
	private double frequency = 0; 
	
	 public EqualTemperedFrequency(Double f) {
		 frequency = f;
	    }
	 
	 public EqualTemperedFrequency next() {
		 double f = frequency *  Math.pow(2.0,(1.0/12.0));
		 return new EqualTemperedFrequency(f);
	    }
	 
	 public void play(double duration){
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	 }
	 
	 public String toString() {
		 return Double.toString(frequency);
	 }
	 
	 public int compareTo (EqualTemperedFrequency that) {
		  if (this.frequency  < that.frequency)  return -1;
	      if (this.frequency  > that.frequency)  return +1;
	      return 0;
	 }
	 
	 public boolean isLessThanOrEqual(EqualTemperedFrequency that) {
		 if (that == this) return true;
	     if (that == null) return false;
	     if (that.getClass() != this.getClass()) return false;
	     final EqualTemperedFrequency t = (EqualTemperedFrequency) that;
	     return (this.frequency == that.frequency);
	 }
	 
}
