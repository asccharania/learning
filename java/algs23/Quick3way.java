package algs23;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Quick3way.java
 *  Execution:    java Quick3way < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/23quicksort/tiny.txt
 *                http://algs4.cs.princeton.edu/23quicksort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using 3-way quicksort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Quick3way < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Quick3way < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 *************************************************************************/

public class Quick3way {

    // quicksort the array a[] using 3-way partitioning
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        final T v = a[lo];
        int i = lo;
        while (i <= gt) {
            final int cmp = a[i].compareTo(v);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
        assert isSorted(a, lo, hi);
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
    private static <T> void exch(T[] a, int i, int j) {
        ops++;
        final T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /* *********************************************************************
     *  Check if array is sorted - useful for debugging
     ***********************************************************************/
    private static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static <T> void show(T[] a) {
        for (T element : a) {
            StdOut.println(element);
        }
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
        for (int i=0; i<40; i++) {
            N *= 2;
            countops (N);
            StdOut.printf("%8d %10d %5.1f [%5.3f %5.3f]\n", N, ops, ops/prevOps, time, time/prevTime);
            prevOps = ops;
            prevTime = time;
        }
    }

    // Read strings from standard input, sort them, and print.
    public static void bookMain(String[] args) {
        //String[] cards = In.readStrings ("data/cards.txt");
        //StdRandom.shuffle (cards);

        //StdIn.fromFile ("data/tiny.txt");
        //StdIn.fromFile ("data/cards.txt");
        StdIn.fromFile ("data/words3.txt");

        final String[] a = StdIn.readAllStrings();
        sort(a);
        show(a);
    }
}
