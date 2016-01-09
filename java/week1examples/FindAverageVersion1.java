package week1examples;

// Written by John Rogers

import stdlib.*;

public class FindAverageVersion1 {

	public static void main(String[] args) {
		int[] array = {23, 45, 12, 68, 56, 13, 1};
		int sum = 0;
		for(int i: array) {
			sum += i;
		}
		double average = 1.0*sum/array.length;
		StdOut.println("The average is " + average);
	}

}
