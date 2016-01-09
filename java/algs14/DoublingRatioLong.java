package algs14;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac DoublingRatioLong.java
 *  Execution:    java DoublingRatioLong
 *  Dependencies: Stopwatch.java StdOut.java
 *
 *  This version is suited for testing functions that require very large N
 *  to run long enough to measure.
 *
 *  % java DoublingRatioLong
 *      512 6.48
 *     1024 8.30
 *     2048 7.75
 *     4096 8.00
 *     8192 8.05
 *   ...
 *
 *************************************************************************/

public class DoublingRatioLong {
    static long f (long N) {
        long sum = 0;
        for (long i = 1; i < N; i++)
            sum++;
        return sum;
    }
    public static double timeTrial(long N) {
        final long T = 1; // number of tests
        double sum = 0;
        for (long t = 0; t < T; t++) {
            final Stopwatch s = new Stopwatch();
            f(N);
            sum +=  s.elapsedTime();
        }
        return sum/T;
    }

    //private static final long MIN = 8192000;
    private static final long MIN = 1000;
    private static final long MAX = Long.MAX_VALUE/2;
    //private static final long MAX = 67108864000L;
    //private static final long MAX = 8388608000L;
    //private static final long MAX = 262144000L;
    public static void main(String[] args) {
        double prev = timeTrial(MIN);
        for (long N = MIN*2; N<=MAX; N += N) {
            final double time = timeTrial(N);
            StdOut.printf("%19d %9.3f %5.1f\n", N, time, time/prev);
            prev = time;
        }
    }
}

