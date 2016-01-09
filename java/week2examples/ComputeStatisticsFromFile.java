package week2examples;

/*
 * Written by John Rogers on April 8th, 2015.
 */

import java.util.ArrayList;
import java.util.Collections;

import stdlib.*;

public class ComputeStatisticsFromFile {
	
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
		
		StdOut.print("Enter a file pathname: ");
		String filename = StdIn.readString();
		StdIn.fromFile(filename);
		while (!StdIn.isEmpty()) {
			int value = StdIn.readInt();
			list.add(value);
		}
		
		double average = computeAverage(list);
		StdOut.println("The average is " + average);
		
		double median = computeMedian(list);
		StdOut.println("The median is " + median);

	}

}
