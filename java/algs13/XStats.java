package algs13;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Stats.java
 *  Execution:    java Stats < input.txt
 *  Dependencies: Bag.java StdIn.java StdOut.java
 *
 *  Reads in a sequence of real numbers from standard input and
 *  computes their mean and standard deviation.
 *
 *  % java Stats
 *  100 99 101 120 98 107 109 81 101 90
 *  Mean:    100.60
 *  Std dev: 10.51
 *
 *************************************************************************/

public class XStats {
    public static void main(String[] args) {

        // read in numbers
        final Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        final int N = numbers.size();

        // compute mean
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        final double mean = sum/N;

        // compute standard deviation
        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        final double std = Math.sqrt(sum/(N-1));

        StdOut.printf("Mean:    %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
