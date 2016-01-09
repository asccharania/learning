package algs13;
import stdlib.*;
/* ***********************************************************************
 *  Compilation:  javac ZLinkedStackOfStrings.java
 *  Execution:    java ZLinkedStackOfStrings
 *
 *  A stack of strings, implemented using a linked list.
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java ZLinkedStackOfStrings < tobe.txt
 *  to be not that or be
 *
 *************************************************************************/

public class XStackOfStrings {
    private int N;          // size of the stack
    private Node first;     // top of stack

    // helper Node class
    private static class Node {
        public Node() { }
        public String item;
        public Node next;
    }

    // is the stack empty?
    public boolean isEmpty() { return first == null; }

    // number of elements on the stack
    public int size() { return N; }


    // add an element to the stack
    public void push(String item) {
        final Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // delete and return the most recently added element
    public String pop() {
        if (isEmpty()) throw new Error("Stack underflow");
        final String item = first.item;      // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }

    // test client
    public static void main(String[] args) {
        StdIn.fromString ("to be or not to - be - - that - - - is");

        final XStackOfStrings s = new XStackOfStrings();
        while (!StdIn.isEmpty()) {
            final String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (s.isEmpty())  StdOut.println("BAD INPUT");
            else                   StdOut.print(s.pop() + " ");
        }
    }


}
