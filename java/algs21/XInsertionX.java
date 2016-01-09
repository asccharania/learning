// Exercise 2.1.24, 2.1.25 (Solution published at http://algs4.cs.princeton.edu/)
package algs21;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac InsertionX.java
 *  Execution:    java InsertionX < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using an optimized
 *  version of insertion sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java InsertionX < tiny.txt
 *  S O R T E X A M P L E A               [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java InsertionX < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 *************************************************************************/

public class XInsertionX {

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        final int N = a.length;

        // put smallest element in position to serve as sentinel
        for (int i = N-1; i > 0; i--)
            if (less(a[i], a[i-1])) exch(a, i, i-1);

        // insertion sort with half-exchanges
        for (int i = 2; i < N; i++) {
            final T v = a[i];
            int j = i;
            while (less(v, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }

        assert isSorted(a);
    }


    /* *********************************************************************
     *  Helper sorting functions
     ***********************************************************************/

    // is v < w ?
    private static <T extends Comparable<? super T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
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

    // print array to standard output
    private static <T> void show(T[] a) {
        for (T element : a) {
            StdOut.println(element);
        }
    }

    // Read strings from standard input, sort them, and print.
    public static void main(String[] args) {
        StdIn.fromString ("S O R T E X A M P L E");
        //StdIn.fromFile ("data/tiny.txt");
        StdIn.fromFile ("data/words3.txt");
        final String[] a = StdIn.readAllStrings();
        Insertion.sort(a);
        show(a);
    }

}
