package algs13;

import stdlib.*;
import java.util.Iterator;

public class XFixedCapacityStack<T> implements Iterable<T> {
    private final T[] a; // holds the items
    private int N; // number of items in stack

    @SuppressWarnings("unchecked")
    public XFixedCapacityStack (int capacity) {
        a = (T[]) new Object[capacity]; // no generic array creation
    }

    public boolean isEmpty () {
        return (N == 0);
    }
    public void push (T item) {
        a[N] = item;
        N++;
    }
    public T pop () {
        N--;
        T result = a[N];
        a[N] = null;
        return result;
    }
    public Iterator<T> iterator () {
        return new ReverseArrayIterator ();
    }

    public class ReverseArrayIterator implements Iterator<T> {
        private int i = N - 1;
        //public ReverseArrayIterator () { utilities.TraceGraph.draw ();  }
        public void remove ()     { throw new UnsupportedOperationException (); }
        public boolean hasNext () { return i >= 0; }
        public T next () {
            T result = a[i];
            i = i - 1;
            //utilities.TraceGraph.draw (); 
            return result;
            //return a[i--];
        }
    }

    public static void main (String[] args) {
        XFixedCapacityStack<Integer> s1 = new XFixedCapacityStack<> (3);
        XFixedCapacityStack<String> s2 = new XFixedCapacityStack<> (5);
        s1.push (Integer.valueOf (300));
        s1.push (Integer.valueOf (300));
        Integer x = s1.pop ();
        int i = x;

        //s2.push (42);
        s2.push ("duck");
        s2.push ("goose");

        StdOut.print ("What's on the stack: ");
        { 
            Iterator<String> it = s2.iterator ();
            while (it.hasNext ()) {
                String s = it.next ();
                StdOut.print (s + " ");
            }
        }
        for (int j : s1) {
            StdOut.print (j + " ");
        }
        StdOut.println ();
    }
}
