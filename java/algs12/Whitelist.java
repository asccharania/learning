package algs12;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac Whitelist.java
 *  Execution:    java Whitelist whitelist.txt < data.txt
 *  Dependencies: StaticSetOfInts.java In.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/11model/tinyW.txt
 *                http://algs4.cs.princeton.edu/11model/tinyT.txt
 *                http://algs4.cs.princeton.edu/11model/largeW.txt
 *                http://algs4.cs.princeton.edu/11model/largeT.txt
 *
 *  Whitelist filter.
 *
 *
 *  % java Whitelist tinyW.txt < tinyT.txt
 *  50
 *  99
 *  13
 *
 *  % java Whitelist largeW.txt < largeT.txt | more
 *  499569
 *  984875
 *  295754
 *  207807
 *  140925
 *  161828
 *  [367,966 total values]
 *
 *************************************************************************/

public class Whitelist {
    public static void main(String[] args) {
        args = new String[] { "data/tinyW.txt" };
        StdIn.fromFile ("data/tinyT.txt");

        final int[] w = new In(args[0]).readAllInts();
        final StaticSETofInts set = new StaticSETofInts(w);

        // Read key, print if not in whitelist.
        while (!StdIn.isEmpty()) {
            final int key = StdIn.readInt();
            if (!set.contains(key))
                StdOut.println(key);
        }
    }
}
