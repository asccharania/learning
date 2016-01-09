package week2examples;
/*
 * Written by John Rogers on April 6th, 2015.
 */

import stdlib.*;

public class LotteryOdds {

	// Calculate factorial iteratively.
	public static long factorial(int k) {
		long product = 1;
		for (int i = 1; i <= k; i++){
			product *= i;
		}
		return product;
	}
	
	// Calculate factorial recursively.
	public static long recursiveFactorial(int k) {
		if (k == 0) {
			return 1;
		}
		else {
			return k * recursiveFactorial(k-1);
		}
	}
	
	public static void main(String[] args) {
		StdOut.print("Enter a value for k: ");
		int k = StdIn.readInt();
		StdOut.println("k! = " + factorial(k));
	}

}
