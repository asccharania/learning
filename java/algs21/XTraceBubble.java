package algs21;
import stdlib.*;
import java.awt.Font;
/* ***********************************************************************
 *  Compilation:  javac TraceBubble.java
 *  Execution:    java  TraceBubblrinput
 *
 *  Bubble sort the sequence of strings specified on the command-line
 *  and show the detailed trace.
 *
 *  % java TraceBubble SORTEXAMPLE
 *
 *************************************************************************/

public class XTraceBubble {

    // bubble sort
    public static void sort (String[] a) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            int j;
            for (j = 1; j < (N - i); j++) {
                if (less (a[j], a[j - 1])) {
                    exch (a, j, j - 1);
                }
            }
            draw(a, i, 1, j-1);
        }
    }


    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        final String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is v < w ?
    private static boolean less(String v, String w) {
        return (v.compareTo(w) < 0);
    }

    //
    private static void draw(String[] a, int row, int ith, int jth) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-2.50, row, ith + "");
        StdDraw.text(-1.25, row, jth + "");
        for (int i = 0; i < a.length; i++) {
            if (i == jth)      StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i < jth)  StdDraw.setPenColor(StdDraw.BLACK);
            else               StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.text(i, row, a[i]);
        }
    }

    // display header
    private static void header(String[] a) {
        final int N = a.length;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(N/2, -3, "a[ ]");
        for (int i = 0; i < N; i++)
            StdDraw.text(i, -2, i + "");
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "j");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3, -1.65, N-.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++)
            StdDraw.text(i, -1, a[i]);
    }

    // display footer
    private static void footer(String[] a) {
        final int N = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++)
            StdDraw.text(i, N, a[i]);
    }



    // test client
    public static void main(String[] args) {
        // parse command-line argument as an array of 1-character strings
        //args = new String[] { "9876543210" };
        args = new String[] { "SORTEXAMPLE" };

        final String s = args[0];
        final int N = s.length();
        final String[] a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = s.substring(i, i+1);

        // set canvas size
        StdDraw.setCanvasSize(30*(N+3), 30*(N+3));
        StdDraw.setXscale(-3, N+1);
        StdDraw.setYscale(N+1, -3);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // draw the header
        header(a);

        // sort the array
        sort(a);

        // draw the footer
        footer(a);
    }

}
