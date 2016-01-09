// Exercise 2.5.27 (Solution published at http://algs4.cs.princeton.edu/)
package algs21;
import stdlib.*;
import java.util.Comparator;
/* ***********************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using insertion sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Insertion < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Insertion < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 *************************************************************************/

public class Insertion {

    // use natural order and Comparable interface
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    // use a custom order and Comparator interface - see Section 3.5
    public static <T> void sort(T[] a, Comparator<? super T> c) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(c, a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            assert isSorted(a, c, 0, i);
        }
        assert isSorted(a, c);
    }

    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]
    public static <T extends Comparable<? super T>> int[] indexSort(T[] a) {
        final int N = a.length;
        final int[] index = new int[N];
        for (int i = 0; i < N; i++)
            index[i] = i;

        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--)
                exch(index, j, j-1);

        return index;
    }

    /* *********************************************************************
     *  Helper sorting functions
     ***********************************************************************/

    // is v < w ?
    private static <T extends Comparable<? super T>> boolean less(T v, T w) {
        ops++;
        return (v.compareTo(w) < 0);
    }

    // is v < w ?
    private static <T> boolean less(Comparator<? super T> c, T v, T w) {
        ops++;
        return (c.compare(v, w) < 0);
    }

    // exchange a[i] and a[j]
    private static <T> void exch(T[] a, int i, int j) {
        ops++;
        final T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indexSort)
    private static void exch(int[] a, int i, int j) {
        ops++;
        final int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /* *********************************************************************
     *  Check if array is sorted - useful for debugging
     ***********************************************************************/
    private static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static <T extends Comparable<? super T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static <T> boolean isSorted(T[] a, Comparator<? super T> c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static <T> boolean isSorted(T[] a, Comparator<? super T> c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static <T> void show(T[] a) {
        for (T element : a) {
            StdOut.println(element);
        }
    }

    private static long ops;
    private static double time;
    private static void countops (int N) {
        final Integer[] a = new Integer[N];
        //for (int i = 0; i < a.length; i++) a[i] = (i*2)/N;
        for (int i = 0; i < a.length; i++) a[i] = StdRandom.uniform (N);
        //StdRandom.shuffle (a);
        //java.util.Arrays.sort (a);
        //java.util.Arrays.sort (a); for (int i = 0; i < (N-1)/2; i++) exch(a, i, N-i-1);
        //java.util.Arrays.sort (a);
        java.util.Arrays.sort (a); int d=(int)Math.sqrt(Math.sqrt(N)); for (int i=0; i<N; i++) exch (a, i, Math.max (Math.min (i+StdRandom.uniform (-d, d),N-1),0));


        ops = 0;
        final Stopwatch sw = new Stopwatch ();
        sort (a);
        time = sw.elapsedTime ();
        //if (! isSorted (a)) throw new Error ();
        //StdOut.println (d);
    }
    public static void main(String[] args) {
        int N = 2000;
        countops (N);
        //System.exit (0);
        double prevOps = ops;
        double prevTime = time;
        for (int i=0; i<6; i++) {
            N *= 2;
            countops (N);
            StdOut.printf("%8d %10d %5.1f [%5.3f %5.3f]\n", N, ops, ops/prevOps, time, time/prevTime);
            prevOps = ops;
            prevTime = time;
        }
    }

    // Read strings from standard input, sort them, and print.
    public static void bookMain(String[] args) {
        //StdIn.fromString ("S O R T E X A M P L E");
        StdIn.fromFile ("data/cards.txt");

        final String[] a = StdIn.readAllStrings();
        StdRandom.shuffle (a);
        show(a);
        StdOut.println ("----------------");
        sort(a);
        show(a);
    }
}
