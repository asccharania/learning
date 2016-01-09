//
// LINKED LIST DICTIONARY
// 
// This class uses a linked list to organize the entries in a dictionary.
//
// HOMEWORK in this file is to implement:
//
// 1) public Entry getClosestEntry(String w)
// 2) public void delete(String w) throws Exception
// 3) public void insert(Entry e)
// 4) public int size()
//

package hw1;

public class LinkedList implements BasicDict {
    public Node first;

    // Helper Node class for defining a linked list 
    public static class Node {
		public Entry entry;
		public Node next;
		
		// Default constructor
		public Node(Entry entry, Node next) {
			this.entry = entry;
			this.next = next;
		}

		// Recursively computes a formatted string for partial dictionary
		public String toString () {
			return entry.toString() + "\n" + (next == null ? "" : next.toString ());
		}
	}

	// Empty dictionary constructor
	public LinkedList () {
	}
	
	// This method returns the closest word entry in the dictionary
	// in alphabetical order
	public Entry getClosestEntry(String w) {
		if (first.entry.word.equals(w)) {
			return first.entry;
		} else if (first.next.entry.word.equals(w)) {
			return first.next.entry;
		} else {
			return getClosestEntry(first.next.entry.word);
		}
	}

	// This method removes a whole entry from the dictionary
	public void delete(String w) throws Exception {
		if (first.entry.word.equals(w)) {
			first.entry = null;
		} else if (first.next.entry.word.equals(w)) {
			first.next.entry = null;
		} else {
			this.delete(w);
		}
		throw new Exception("Nonexistent deletion!");
	}
	
	// This method inserts a new entry into the dictionary
	public void insert(Entry e) {
		this.first = new Node(e, this.first);
	}
	
	// This method returns the total number of definitions. Note that
	// this is different than the total number of words defined. 
	public int size() {
		if (this.first.next == null) {
			return 0;
		}
		return 1 + this.size();
	}
	
	// Returns a formatted string for the whole dictionary
	public String toString () {
		return (first == null ? "" : first.toString());
	}
}