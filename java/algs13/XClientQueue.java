package algs13;
import stdlib.*;

// Using a Queue as temporary storage for input of unknown size
public class XClientQueue {
    public static int[] readInts (String name) {
        final In in = new In (name);
        final Queue<Integer> q = new Queue<> ();
        while (!in.isEmpty ())
            q.enqueue (in.readInt ());

        final int N = q.size ();
        final int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue ();
        return a;
    }
    public static void main (String[] args) {
        final int[] a = readInts ("data/tinyW.txt");
        StdOut.print (a.length);
    }
}
