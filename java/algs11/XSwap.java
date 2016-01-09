package algs11;
import stdlib.*;

public class XSwap {
    public static void main (String[] args) {
        {
            final int x = 42;
            final int y = 27;
            StdOut.printf ("before x=%d y=%d\n" , x, y);
            swap1 (x, y);
            StdOut.printf ("after  x=%d y=%d\n\n" , x, y);
        }
        {
            final Integer x = new Integer (42);
            final Integer y = new Integer (27);
            StdOut.printf ("before x=%d y=%d\n" , x, y);
            swap2 (x, y);
            StdOut.printf ("after  x=%d y=%d\n\n" , x, y);
        }
        {
            final int[] a = new int[2];
            a[0] = 42;
            a[1] = 27;
            StdOut.printf ("before x=%d y=%d\n" , a[0], a[1]);
            swap3 (a, 0, 1);
            StdOut.printf ("after  x=%d y=%d\n\n" , a[0], a[1]);
        }
        {
            final Integer[] a = new Integer[2];
            a[0] = new Integer (42);
            a[1] = new Integer (27);
            StdOut.printf ("before x=%d y=%d\n" , a[0], a[1]);
            swap4 (a, 0, 1);
            StdOut.printf ("after  x=%d y=%d\n\n" , a[0], a[1]);
        }
    }
    static void swap1 (int a, int b) {
        final int t = a;
        a = b;
        b = t;
    }
    static void swap2 (Integer a, Integer b) {
        final Integer t = a;
        a = b;
        b = t;
    }
    static void swap3 (int[] a, int i, int j) {
        final int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    static void swap4 (Object[] a, int i, int j) {
        final Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
