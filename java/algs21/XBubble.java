package algs21;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Bubble.java
 *  Execution:    java Bubble < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using insertion sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Bubble < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Bubble < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 *************************************************************************/

public class XBubble {

    // use natural order and Comparable interface
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < (N - i); j++) {
                if (less (a[j], a[j - 1])) {
                    exch (a, j, j - 1);
                }
                assert isSorted (a, N - i - 1, N - 1);
            }
        }
        assert isSorted (a);
    }

    /* *********************************************************************
     *  Helper sorting functions
     ***********************************************************************/

    // is v < w ?
    private static <T extends Comparable<? super T>> boolean less(T v, T w) {
        return (v.compareTo(w) < 0);
    }

    // exchange a[i] and a[j]
    private static <T> void exch(T[] a, int i, int j) {
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

    // is the array sorted from a[lo] to a[hi]
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

    // Read strings from standard input, sort them, and print.
    public static void main(String[] args) {
        //StdIn.fromFile ("data/tiny.txt");
        StdIn.fromFile ("data/words3.txt");
        final String[] a = StdIn.readAllStrings();
        sort(a);
        show(a);
    }
}
