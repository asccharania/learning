package week2examples;

/*
 * Written by John Rogers on April 6th, 2015.
 */

import java.util.ArrayList;
import java.util.Collections;

import stdlib.*;

public class ComputeStatisticsVersion1 {
	
	public static double computeAverage(ArrayList<Integer> array) {
		int sum = 0;
		for (int value: array) {
			sum += value;
		}
		return (double)sum/array.size();
	}

	public static double computeMedian(ArrayList<Integer> array) {
		Collections.sort(array);
		int middle = array.size()/2;
		return array.get(middle);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int value;
		StdOut.print("Enter an integer value: ");
		value = StdIn.readInt();
		while (value != 0) {
			list.add(value);
			StdOut.print("Enter an integer value: ");
			value = StdIn.readInt();
		}
		
		double average = computeAverage(list);
		StdOut.println("The average is " + average);
		
		double median = computeMedian(list);
		StdOut.println("The median is " + median);

	}

}
