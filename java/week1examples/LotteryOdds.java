package week1examples;
import stdlib.*;

public class LotteryOdds {

	public static long factorial(int n){
		if (n == 0) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}

	public static long choose(int n, int k){
		return factorial(n)/(factorial(k)*factorial(n-k));
	}
/*
	public static int choose(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		return choose(n-1, k) + choose(n-1, k-1);
	}
*/
	public static void main(String[] args) {
		StdOut.print("Enter the number of values in the lottery: ");
		int n = Integer.parseInt(StdIn.readLine());
		StdOut.print("Enter the number of values chosen: ");
		int k = Integer.parseInt(StdIn.readLine());
		StdOut.printf("There are %,d possible combinations.", choose(n, k));
	}

}
