package algs13;

import stdlib.*;

public class XFixedCapacityStackOfStrings {
    private final String[] a; // holds the items
    private int N;            // number of items in stack

    public XFixedCapacityStackOfStrings (int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty () {
        return (N == 0);
    }
    public void push (String item) {
        a[N] = item;
        N++;
    }
    public String pop () {
        N--;
        String result = a[N];
        a[N] = null;
        return result;
    }

    public static void main (String[] args) {
        XFixedCapacityStackOfStrings stack = new XFixedCapacityStackOfStrings (5);
        stack.push ("duck");
        stack.push ("goose");

        while (!stack.isEmpty()) {
            StdOut.println (stack.pop ());
        }
    }
}
