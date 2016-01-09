//
// LLRB --- L(eft)-L(eaning) R(ed)-B(lack) BST
// 
// This class stores a set of integer keys using a left-leaning red-black BST
//
// HOMEWORK in this file is to implement:
//
// 1) public void insert()
// 2) public boolean containsRightRedEdge()
// 3) public boolean containsConsecutiveLeftRedEdges()
// 4) public int countBlackEdgesOnLeftmostPath()
// 5) public boolean sameBlackEdgesCountOnAllPaths(int count)
//
// As BONUS, there are two additional methods to implement
//
// 1) public void merge(LLRB llrb)
// 2) public void fixLLRB()
//

package hw3;

public class LLRB {
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    
    public Node root;
	
	public class Node {
		public int key;
		public boolean color;
		public Node left, right;
		
		public Node(int key, boolean color) {
			this.key = key;
			this.color = color;
		}
	}
	
	// Constructor for LLRB
	public LLRB() {
	}
	
	// Is parent link for node x red? false if x is null
	private boolean isRed(Node x) {
		if (x == null) return false;
		return x.color == RED;
	}
	
	// Inserts a key without fixing the tree
	public void bstInsert(int key) {
		root = bstInsert(root, key);
	}
	
	// Recursive helper method for bstInsert
	private Node bstInsert(Node x, int key) {
		if (x == null) return new Node(key, RED);
		if (key < x.key) x.left  = bstInsert(x.left, key);
		else if (key > x.key) x.right = bstInsert(x.right, key);
		return x;
	}
	
	// Inserts a key fixing the red-black tree property
	public void insert(int key) {
		 root = insert(root, key);
	     root.color = BLACK;

	}
	
	 private Node insert(Node h, Integer key) { 
	        if (h == null) return new Node(key, RED);

	        int cmp = key.compareTo(h.key);
	        if      (cmp < 0) h.left  = insert(h.left,  key); 
	        else if (cmp > 0) h.right = insert(h.right, key); 
	        else              h.key   = key;

	        // fix-up any right-leaning links
	        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
	        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
	        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);

	        return h;
	    }

	
	// Checks whether the tree contains a red right edge
	public boolean containsRightRedEdge() {
		return containsRightRedEdge(root);
	}
	
	private boolean containsRightRedEdge(Node n) {
		 if (n == null) {
			 return false;
		 }
	     if (isRed(n.right)){
	    	 return true;
	     }
	     return containsRightRedEdge(n.right) || containsRightRedEdge(n.left);
	}
	
	// Checks whether the tree contains two left red edges in a row
	public boolean containsConsecutiveLeftRedEdges() {
		return containsConsecutiveLeftRedEdges(root);
	} 
	
	private boolean containsConsecutiveLeftRedEdges(Node n) {
		if (n == null) {
			return false;
		}
	    if (n != root && isRed(n) && isRed(n.left)) {
	    	return true;
	    }
	    return containsConsecutiveLeftRedEdges(n.left) || containsConsecutiveLeftRedEdges(n.right);

	}
	
	// Returns the number of black edges on the leftmost path
	public int countBlackEdgesOnLeftmostPath() {
		return countBlackEdgesOnLeftmostPath(root);
	}
	
	private int countBlackEdgesOnLeftmostPath(Node n) {
		if (n == null) {
			return 0;
		}
		
		if (isRed(n)) {
			return countBlackEdgesOnLeftmostPath(n.left);
		} else {
			return 1 + countBlackEdgesOnLeftmostPath(n.left);
		}
		
		
		
	}
	
	// Checks whether the number of black edges on any path from root to a leaf
	// is the same as the count provided
	public boolean sameBlackEdgesCountOnAllPaths(int count) {
		return sameBlackEdgesCountOnAllPaths(root, count);
	}
	
	private boolean sameBlackEdgesCountOnAllPaths(Node n, int x) {
        if (n == null) return x == 0;
        if (!isRed(n)) x--;
        return sameBlackEdgesCountOnAllPaths(n.left, x) && sameBlackEdgesCountOnAllPaths(n.right, x);
	}
	
	// Checks whether the BST is a valid left leaning red-black tree
	public boolean isValidLLRB() {
		int count = countBlackEdgesOnLeftmostPath();
		return (sameBlackEdgesCountOnAllPaths(count) && 
				!containsRightRedEdge() &&
				!containsConsecutiveLeftRedEdges());
	}
	
	// Merges another left leaning red-black tree by inserting its key into this tree
	public void merge(LLRB llrb) {
		// BONUS : complete this method
	}
    
	// Fixes the red-black tree if there is something to fix
	public void fixLLRB() {

	}

	
    // make a left-leaning link lean to the right
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;

        return x;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;

        return x;
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
    
    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        return h;
    }
    

}