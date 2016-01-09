package week1examples;

// John Rogers

import java.util.ArrayList;
import stdlib.*;

public class FindAverageVersion3 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int value;
		StdOut.print("Please enter a value: ");
		value = StdIn.readInt();
		while (value != 0) {
			list.add(value);
			StdOut.print("Please enter a value: ");
			value = StdIn.readInt();
		}
		
		int sum = 0;
		for(Integer i: list) {
			sum += i;
		}
		
		double average = 1.0*sum/list.size();
		
		StdOut.println("The average is " + average);

	}

}
