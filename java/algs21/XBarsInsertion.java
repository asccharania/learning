package algs21;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac ZInsertionBars.java
 *  Execution:    java ZInsertionBars N
 *  Dependencies: StdDraw.java
 *
 *  Insertion sort N random real numbers between 0 and 1, visualizing
 *  the results by ploting bars with heights proportional to the values.
 *
 *  % java ZInsertionBars 20
 *
 *************************************************************************/


public class XBarsInsertion {
    public static void sort(double[] a) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            int j = i;
            while (j >= 1 && less(a[j], a[j-1])) {
                exch(a, j, j-1);
                j--;
            }
            show(a, i, j);
        }
    }

    private static void show(double[] a, int i, int j) {
        StdDraw.setYscale(-a.length + i + 1, i);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < j; k++)
            StdDraw.line(k, 0, k, a[k]*.6);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(j, 0, j, a[j]*.6);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = j+1; k <= i; k++)
            StdDraw.line(k, 0, k, a[k]*.6);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = i+1; k < a.length; k++)
            StdDraw.line(k, 0, k, a[k]*.6);
    }

    private static boolean less(double v, double w) {
        return v < w;
    }

    private static void exch(double[] a, int i, int j) {
        final double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        args = new String[] { "10" };

        final int N = Integer.parseInt(args[0]);
        StdDraw.setCanvasSize(N*8, N*32);
        StdDraw.setXscale(-1, N+1);
        StdDraw.setPenRadius(.006);
        final double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = Math.random();
        sort(a);
    }

}
