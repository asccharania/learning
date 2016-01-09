package algs14;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac DoublingTest.java
 *  Execution:    java DoublingTest
 *  Dependencies: ThreeSum.java Stopwatch.java StdRandom.java StdOut.java
 *
 *  % java DoublingTest
 *      512 6.48
 *     1024 8.30
 *     2048 7.75
 *     4096 8.00
 *     8192 8.05
 *   ...
 *
 *************************************************************************/

public class XDoublingTest {
    public static double timeTrial(int N) {
        final int MAXVAL = 1000000;
        final int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAXVAL, MAXVAL);
        }
        final int T = 1; // number of tests
        double sum = 0;
        for (int t = 0; t < T; t++) {
            final Stopwatch s = new Stopwatch();
            ThreeSum.count(a);
            sum +=  s.elapsedTime();
        }
        return sum/T;
    }


    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            final double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}

