package algs11;
import stdlib.*;
public class XDrawRandom {
    public static void main (String[] args) {
        final int N = 50;
        final double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.random ();
        for (int i = 0; i < N; i++) {
            final double x = 1.0 * i / N;
            final double y = a[i] / 2.0;
            final double rw = 0.25 / N;
            final double rh = a[i] / 2.0;
            StdDraw.filledRectangle (x, y, rw, rh);
        }
    }
}
