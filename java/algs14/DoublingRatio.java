package algs14;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac DoublingRatio.java
 *  Execution:    java DoublingRatio
 *  Dependencies: ThreeSum.java Stopwatch.java StdRandom.java StdOut.java
 *
 *
 *  % java DoublingRatio
 *      512 6.48
 *     1024 8.30
 *     2048 7.75
 *     4096 8.00
 *     8192 8.05
 *   ...
 *
 *************************************************************************/

public class DoublingRatio {
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
            //XOneSum.count (a);
            //XTwoSum.count (a);
            //ThreeSum.count(a);
            //XFourSum.count(a);
            XTwoSumFast.count (a);
            //ThreeSumFast.count (a);
            sum +=  s.elapsedTime();
        }
        return sum/T;
    }

    private static final int MIN = 125;
    private static final int MAX = Integer.MAX_VALUE/2;
    //private static final int MAX = 32768000;
    //private static final int MAX = 1024000;
    //private static final int MAX = 64000;
    public static void main(String[] args) {
        double prev = timeTrial(MIN);
        for (int N = MIN*2; N<=MAX; N += N) {
            final double time = timeTrial(N);
            StdOut.printf("%10d %9.3f %5.1f\n", N, time, time/prev);
            prev = time;
        }
    }
}

