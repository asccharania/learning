package algs11;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Wget.java
 *  Execution:    java Wget url
 *
 *  Reads in a URL specified on the command line and saves its contents
 *  in a file with the given name.
 *
 *  % java Wget http://www.cs.princeton.edu/IntroProgramming/datafiles/codes.csv
 *
 *************************************************************************/

public class XWget {

    public static void main(String[] args) {
        args = new String[] { "http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html" };

        // read in data from URL
        final String url = args[0];
        final In in = new In(url);
        if (!in.exists ())
            System.exit (1);
        final String data = in.readAll();

        final String filename = url.substring(url.lastIndexOf('/') + 1);
        if (filename.length () <= 0) {
            StdOut.println (data);
        } else {
            // write data to a file
            final Out out = new Out(filename);
            out.println(data);
            out.close();
            StdOut.println ("Output in file \"" + filename + "\"");
        }
    }
}
