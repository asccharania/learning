// Exercise 2.2.9 2.2.20 (Solution published at http://algs4.cs.princeton.edu/)
package algs22;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/22merge/tiny.txt
 *                http://algs4.cs.princeton.edu/22merge/words3.txt
 *
 *  Sorts a sequence of strings from standard input using mergesort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Merge < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Merge < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 *************************************************************************/

public class Merge {

    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
    public static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {

        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
        ops += hi-lo;

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi) {
        if (hi <= lo) return;
        final int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        final T[] aux = (T[]) new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }


    /* *********************************************************************
     *  Helper sorting functions
     ***********************************************************************/

    // is v < w ?
    private static <T extends Comparable<? super T>> boolean less(T v, T w) {
        ops++;
        return (v.compareTo(w) < 0);
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


    /* *********************************************************************
     *  Index mergesort
     ***********************************************************************/
    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
    private static <T extends Comparable<? super T>> void merge(T[] a, int[] index, int[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = index[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                    index[k] = aux[j++];
            else if (j > hi)                     index[k] = aux[i++];
            else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
            else                                 index[k] = aux[i++];
        }
    }

    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]
    public static <T extends Comparable<? super T>> int[] indexSort(T[] a) {
        final int N = a.length;
        final int[] index = new int[N];
        for (int i = 0; i < N; i++)
            index[i] = i;

        final int[] aux = new int[N];
        indexSort(a, index, aux, 0, N-1);
        return index;
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static <T extends Comparable<? super T>> void indexSort(T[] a, int[] index, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        final int mid = lo + (hi - lo) / 2;
        indexSort(a, index, aux, lo, mid);
        indexSort(a, index, aux, mid + 1, hi);
        merge(a, index, aux, lo, mid, hi);
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
        for (int i=0; i<12; i++) {
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
