package algs24;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Taxicab.java
 *  Execution:    java Taxicab N
 *
 *  Find all nontrivial integer solutions to a^3 + b^3 = c^3 + d^3 where
 *  a, b, c, and d are between 0 and N. By nontrivial, we mean
 *  a <= b, c <= d, and (a, b) != (c, d).
 *
 *  % java Taxicab 11
 *
 *  % java Taxicab 12
 *  1729: 9^3 + 10^3
 *  1729: 1^3 +  12^3
 *
 *  % java Taxicab 1000
 *  1729: 1^3 + 12^3
 *  1729: 9^3 + 10^3
 *  4104: 2^3 + 16^3
 *  4104: 9^3 + 15^3
 *  13832: 2^3 + 24^3
 *  13832: 18^3 + 20^3
 *  ...
 *  87539319: 228^3 + 423^3
 *  87539319: 167^3 + 436^3
 *  87539319: 167^3 + 436^3
 *  87539319: 255^3 + 414^3
 *  ...
 *  1477354411: 802^3 + 987^3
 *  1477354411: 883^3 + 924^3
 *
 *************************************************************************/

public class XTaxicab implements Comparable<XTaxicab> {
    private final long sum;
    private final int i;
    private final int j;

    // create a new tuple (i, j, i^3 + j^3)
    public XTaxicab(int i, int j) {
        this.sum = (long) i*i*i + (long) j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(XTaxicab that) {
        if      (this.sum < that.sum) return -1;
        else if (this.sum > that.sum) return +1;
        else                          return  0;
    }

    public String toString() {
        return sum + " = " + i + "^3 + " + j + "^3";
    }


    public static void main(String[] args) {

        final int N = Integer.parseInt(args[0]);

        // initialize priority queue
        final MinPQ<XTaxicab> pq = new MinPQ<>();
        for (int i = 1; i <= N; i++) {
            pq.insert(new XTaxicab(i, i));
        }

        // enumerate sums in ascending order, look for repeated sums
        XTaxicab prev = new XTaxicab(0, 0);   // sentinel
        while (!pq.isEmpty()) {
            final XTaxicab s = pq.delMin();

            // sum is same as previous one
            if (prev.sum == s.sum) {
                StdOut.println(prev);
                StdOut.println(s);
            }
            prev = s;

            if (s.j < N) pq.insert(new XTaxicab(s.i, s.j + 1));
        }
    }

}
