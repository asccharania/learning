package week2examples;
/*
 * Written by John Rogers on April 8th, 2015.
 */

import stdlib.*;

public class LotteryOddsVersion2 {

	public static long computeOdds(int n, int k) {
		if (k == 0) {
			return 1;
		}
		else if (n == k) {
			return 1;
		}
		else {
			return computeOdds(n-1, k) + computeOdds(n-1, k-1);
		}
	}
	
	public static void main(String[] args) {
		StdOut.print("Enter a value for n: ");
		int n = StdIn.readInt();
		StdOut.print("Enter a value for k: ");
		int k = StdIn.readInt();
		StdOut.println(computeOdds(n, k));
	}

}
