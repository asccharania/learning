// Exercise 2.3.22 (Solution published at http://algs4.cs.princeton.edu/)
package algs23;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac QuickX.java
 *  Execution:    java QuickX N
 *
 *  Uses the Bentley-McIlroy 3-way partitioning scheme,
 *  chooses the partitioning element using Tukey's ninther,
 *  and cuts off to insertion sort.
 *
 *  Reference: Engineering a Sort Function by Jon L. Bentley
 *  and M. Douglas McIlroy. Softwae-Practice and Experience,
 *  Vol. 23 (11), 1249-1265 (November 1993).
 *
 *************************************************************************/

public class XQuickX {
    private static final int CUTOFF = 8;  // cutoff to insertion sort, must be >= 1

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        final int N = hi - lo + 1;

        // cutoff to insertion sort
        if (N <= CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        // use median-of-3 as partitioning element
        else if (N <= 40) {
            final int m = median3(a, lo, lo + N/2, hi);
            exch(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else  {
            final int eps = N/8;
            final int mid = lo + N/2;
            final int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            final int m2 = median3(a, mid - eps, mid, mid + eps);
            final int m3 = median3(a, hi - eps - eps, hi - eps, hi);
            final int ninther = median3(a, m1, m2, m3);
            exch(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        while (true) {
            final T v = a[lo];
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
            if (eq(a[i], v)) exch(a, ++p, i);
            if (eq(a[j], v)) exch(a, --q, j);
        }
        exch(a, lo, j);

        i = j + 1;
        j = j - 1;
        for (int k = lo+1; k <= p; k++) exch(a, k, j--);
        for (int k = hi  ; k >= q; k--) exch(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }


    // sort from a[lo] to a[hi] using insertion sort
    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }


    // return the index of the median element among a[i], a[j], and a[k]
    private static <T extends Comparable<? super T>> int median3(T[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                    (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    /* *********************************************************************
     *  Helper sorting functions
     ***********************************************************************/

    // is v < w ?
    private static <T extends Comparable<? super T>> boolean less(T v, T w) {
        ops++;
        return (v.compareTo(w) < 0);
    }

    // does v == w ?
    private static <T extends Comparable<? super T>> boolean eq(T v, T w) {
        ops++;
        return (v.compareTo(w) == 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        final Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /* *********************************************************************
     *  Check if array is sorted - useful for debugging
     ***********************************************************************/
    private static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    private static int ops;
    private static double time;
    private static void countops (int N) {
        final Integer[] a = new Integer[N];
        //for (int i = 0; i < a.length; i++) a[i] = (i*2)/N;
        for (int i = 0; i < a.length; i++) a[i] = StdRandom.uniform (N);
        //StdRandom.shuffle (a);
        //java.util.Arrays.sort (a);
        //java.util.Arrays.sort (a); for (int i = 0; i < (N-1)/2; i++) exch(a, i, N-i-1);

        ops = 0;
        final Stopwatch sw = new Stopwatch ();
        sort (a);
        time = sw.elapsedTime ();
        if (! isSorted (a)) throw new Error ();
        //StdOut.println (d);
    }
    public static void main(String[] args) {
        int N = 2000;
        countops (N);
        //System.exit (0);
        double prevOps = ops;
        double prevTime = time;
        for (int i=0; i<12; i++) {
            N *= 2;
            countops (N);
            StdOut.printf("%8d %10d %5.1f [%5.3f %5.3f]\n", N, ops, ops/prevOps, time, time/prevTime);
            prevOps = ops;
            prevTime = time;
        }
    }

    // test client
    public static void bookMain(String[] args) {

        // generate array of N random reals between 0 and 1
        final int N = Integer.parseInt(args[0]);
        final Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
        }

        // sort the array
        sort(a);

        // display results
        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
        StdOut.println("isSorted = " + isSorted(a));

    }

}
