package week1examples;

import stdlib.*;

public class FindAverageVersion2 {

	public static void main(String[] args) {
		final int arraySize = 7;
		int[] array = new int[arraySize];

		for(int i = 0; i < arraySize; i++) {
			StdOut.print("Enter an integer: ");
			array[i] = StdIn.readInt();
		}
		
		int sum = 0;
		
		for(int i: array) {
			sum += i;
		}
		double average = 1.0*sum/array.length;
		StdOut.println("The average is " + average);
	}

}
