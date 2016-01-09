//
// BINARY SEARCH TREE DICTIONARY
// 
// This class uses a binary search tree to organize the entries in a dictionary.
//
// HOMEWORK in this file is to implement:
//
// 1) public Entry getClosestEntry(String w)
// 2) public void delete(String w) throws Exception
// 3) public void insert(Entry e)
// 4) public int size()
//

package hw2;

import hw1.*;

public class BinarySearchTree implements BasicDict {
	public Node root;

	// Helper Node class for defining a linked list 
	public static class Node {
		public Entry entry;
		public Node left, right;
			
		// Default constructor
		public Node(Entry entry) {
			this.entry = entry;
			this.left = null;
			this.right = null;
		}

		// Recursively computes a formatted string for partial dictionary (subtree)
		public String toString () {
			return (left == null ? "" : left.toString() + "\n") + entry.toString() +
			       (right == null ? "" : "\n" + right.toString());
		}
	}
	
	// Empty dictionary constructor
	public BinarySearchTree () {
	}

	// This method returns the closest word entry in the dictionary
	// in alphabetical order
	public Entry getClosestEntry(String w) {
		return getClosestEntry(root, w);
		
	}
	private Entry getClosestEntry(Node n, String s){
		
		if (n == null) return null;
		String key = n.entry.word;
		
		int cmp2 = s.compareTo(key);
		
		if (n.left == null && n.right == null) {
			return n.entry;
		}
		
		if (n.left == null){
			if (cmp2 > 0) {
				return getClosestEntry(n.right, s);
			} else {
				return n.entry;
			}
			
		}
		
		if (n.right == null) {
			if (cmp2 < 0) {
				return getClosestEntry(n.left, s);
			} else {
				return n.entry;
			}
		}
		
		if (cmp2 == 0) {
			return n.entry;
		} else if (cmp2 > 0) {
			return getClosestEntry(n.right, s);
		} else {
			return getClosestEntry(n.left, s);
		} 
	}

	
	// This method removes a whole entry from the dictionary
	public void delete(String w) { 
		root = delete(root, w); 
	}
	
	private Node delete(Node x, String key) {
	   if (x == null) return null;
	   int cmp2 = key.compareTo(x.entry.word);
	   if (cmp2 < 0) x.left  = delete(x.left,  key);
	   else if (cmp2 > 0) x.right = delete(x.right, key);
	   else {
	      if (x.right == null) return x.left;
	      if (x.left  == null) return x.right;
	      
	      Node t = x;
	      x = min(t.right);
	      x.right = deleteMin(t.right);
	      x.left = t.left;

	   }
	   return x;
	}

	// This method inserts a new entry into the dictionary
	public void insert(Entry e) {
		root = insert(e, root);
		
	}
	
	private Node insert(Entry e, Node n) {
		if (n == null) {
			return new Node (e);
		}
		int cmp2 = e.word.compareTo(n.entry.word);
		if (cmp2 > 0) {
			n.right = insert(e, n.right);
		} else if (cmp2 < 0) {
			n.left = insert(e, n.left);
		} else {
			n.entry = e;
		}
		return n;
	}
	
	// This method returns the total number of definitions. Note that
	// this is different than the total number of words defined. 
	public int size() {
		return size(root);
	}
	
	private int size(Node n) {
		
		if (n == null) return 0;
		
		int count = 0;
		
		for (int x = 0; x < n.entry.defns.length; x++) {
			count += 1;
		}
		count += size(n.right);
		count += size(n.left);
		return count;
	
	}
	
	public Node min(Node n){
		if (n.left == null) {
			return n;
		} else {
			return min(n.left);
		} 
	}
	
	public void deleteMin(){  
		root = deleteMin(root);  
	}
	
	private Node deleteMin(Node x)
	{
	   if (x.left == null) return x.right;
	   x.left = deleteMin(x.left);
	   return x;
	}

	// Returns a formatted string for the whole dictionary
	public String toString () {
		return (root == null ? "" : root.toString());
	}
}