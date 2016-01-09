package MoreStatistics;

import java.util.ArrayList;
import java.util.Collections;

import stdlib.StdIn;
import stdlib.StdOut;

// Patrick Krebs 

public class MoreStatistics {
	
	public static int computeMax(ArrayList<Integer> array) {
		int num = -1000000;
		for (int value: array) {
			if (num < value) {
				num = value; 
			} 
				
		}
		return num;
	}

	public static int computeMin(ArrayList<Integer> array) {
		int num = 1000000;
		for (int value: array) {
			if (num > value) {
				num = value; 
			} 
				
		}
		return num;
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
		
		int average = computeMax(list);
		StdOut.println("The maximum is " + average);
		
		int median = computeMin(list);
		StdOut.println("The minimum is " + median);

	}

}
