package algs21;
import stdlib.*;

public class XAnimatedBubble {

    public static void sort (double[] a) {
        final int N = a.length;
        show (a, N, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < (N - i); j++) {
                if (less (a[j], a[j - 1])) {
                    exch (a, j, j - 1);
                    show (a, N - i, j);
                }
                assert isSorted (a, N - i - 1, N - 1);
            }
        }
        assert isSorted (a);
    }

    private static void show (double[] a, int i, int min) {
        StdDraw.clear ();
        //StdDraw.setYscale(-a.length + i + 1, i);
        StdDraw.setPenColor (StdDraw.LIGHT_GRAY);
        for (int k = i; k < a.length; k++)
            StdDraw.line (k, 0, k, a[k] * .6);
        StdDraw.setPenColor (StdDraw.BLACK);
        for (int k = 0; k < i; k++)
            StdDraw.line (k, 0, k, a[k] * .6);
        StdDraw.setPenColor (StdDraw.BOOK_RED);
        StdDraw.line (min, 0, min, a[min] * .6);
        StdDraw.show (100);
    }

    private static boolean less (double v, double w) {
        return v < w;
    }
    private static void exch (double[] a, int i, int j) {
        final double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static boolean isSorted (double[] a) {
        return isSorted (a, 0, a.length - 1);
    }
    private static boolean isSorted (double[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less (a[i], a[i - 1])) return false;
        return true;
    }

    public static void main (String[] args) {
        args = new String[] { "25" };
        final int N = Integer.parseInt (args[0]);
        StdDraw.setCanvasSize (160, 320);
        StdDraw.setXscale (-1, N + 1);
        StdDraw.setPenRadius (.006);
        final double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = Math.random ();
        //java.util.Arrays.sort (a);
        //java.util.Arrays.sort (a); for (int i = 0; i < (N-1)/2; i++) exch(a, i, N-i-1);
        sort (a);
    }

}
