package algs11;
import stdlib.*;
import java.awt.Color;
/* ***********************************************************************
 *  Compilation:  javac Scale.java
 *  Execution:    java Scale filename w h
 *  Data files:   http://www.cs.princeton.edu/introcs/31datatype/mandrill.jpg
 *
 *  Scales an image to w-by-h and displays both the original
 *  and the scaled version to the screen.
 *
 *  % java Scale mandrill.jpg 200 300
 *
 *
 *************************************************************************/

public class XScale {
    public static void main(String[] args) {
        args = new String[] { "data/mandrill.jpg", "200", "300" };

        final String filename = args[0];
        final int w = Integer.parseInt(args[1]);
        final int h = Integer.parseInt(args[2]);
        final Picture source = new Picture(filename);
        final Picture target = new Picture(w, h);
        // StdOut.println("Source image: " + source.width() + "-by-" + source.height());

        for (int ti = 0; ti < w; ti++) {
            for (int tj = 0; tj < h; tj++) {
                final int si = ti * source.width()  / w;
                final int sj = tj * source.height() / h;
                final Color color = source.get(si, sj);
                target.set(ti, tj, color);
            }
        }

        source.show();
        target.show();
    }
}
