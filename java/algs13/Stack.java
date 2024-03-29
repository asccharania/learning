package algs13;
import  stdlib.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* ***********************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 *************************************************************************/

/**
 *  The <tt>Stack</tt> class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  All stack operations except iteration are constant time.
 *  <p>
 *  For additional documentation, see <a href="/algs4/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Stack<T> implements Iterable<T> {
    private int N;          // size of the stack
    private Node<T> first;     // top of stack

    // helper linked list class
    private static class Node<T> {
        public Node () { }
        public T item;
        public Node<T> next;
    }

    /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        N = 0;
        assert check();
    }

    /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the stack.
     */
    public int size() {
        return N;
    }

    /**
     * Add the item to the stack.
     */
    public void push(T item) {
        Node<T> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        N++;
        assert check();
    }

    /**
     * Delete and return the item most recently added to the stack.
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        assert check();
        return item;                   // return the saved item
    }


    /**
     * Return the item most recently added to the stack.
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item + " ");
        return s.toString();
    }


    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
        }
        else if (N == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable N
        int numberOfNodes = 0;
        for (Node<T> x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != N) return false;

        return true;
    }


    /**
     * Return an iterator to the stack that iterates through the items in LIFO order.
     */
    public Iterator<T> iterator()  { return new ListIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;
        public void remove() { throw new UnsupportedOperationException(); }
        public boolean hasNext() { return current != null; }
        //public ListIterator () { utilities.TraceGraph.draw (); } 
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * A test client.
     */
    public static void main(String[] args) {
        //utilities.Trace.graphvizShowSteps (true);
        //utilities.Trace.run ();
        StdIn.fromString ("to be or not to - be - - that - - - is");
        //StdIn.fromString ("11 12 13");
        Stack<String> stack = new Stack<>();
        utilities.GraphvizBuilder.nodesToFile (stack.first, "rankdir=\"LR\"");
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
            //utilities.Trace.draw ();
            utilities.GraphvizBuilder.nodesToFile (stack.first, "rankdir=\"LR\"");
        }
        StdOut.println(stack.size() + " left on stack:");
        for (String s : stack) {
            StdOut.print (s + " ");
        }
        StdOut.println ();        
    }
}
