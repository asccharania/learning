//
// Digraph --- Digraph implementation using adjacency list representation
// 
// HOMEWORK in this file is to implement:
//
// 1) public Digraph complement()
// Returns a digraph that is the complement of this digraph
// The complement digraph contains an edge if and only if this digraph does not contain it
//
// 2) public boolean isTopological(int[] order)
// Checks whether the given permutation of vertices is a topological order
// This method will return true if and only if there are no edges going backwards 
//
// 3) public Stack<Integer> topologicalOrder()
// Returns a topological order if there exists one, otherwise returns null
// This method will return a topological order if and only if this digraph is a DAG 
//
// 4) public Stack<Integer> shortestPath(int s, int t)
// Returns a shortest path from s to t if there exists one, otherwise returns null
// This method will return a path if and only if t is reachable from s
//
// 5) public Stack<Integer> cycleBetween(int v, int w)
// Returns a cycle that contains both v and w if there exists one, otherwise returns null
// This method will return a cycle if and only if v and w are strongly connected
//

package hw5;

import hw4.Queue;
import java.util.LinkedList;

public class Digraph {
    private static final int INFINITY = Integer.MAX_VALUE;
	private final int V;                  // number of vertices in this digraph
	private int E;                        // number of edges in this digraph
	private LinkedList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
	private LinkedList<Edge> edges;       // list of edges in this digraph
	private boolean[] marked;             // marked[v] = is there an s->v path?
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    private int[] distTo;      // distTo[v] = length of shortest s->v path
    private int[] pre;                 // pre[v]    = preorder  number of v
    private int[] post;                // post[v]   = postorder number of v
    private Queue<Integer> preorder;   // vertices in preorder
    private Queue<Integer> postorder;  // vertices in postorder
    private int preCounter;            // counter or preorder numbering
    private int postCounter;           // counter for postorder numbering
    private Stack<Integer> order;  // topological order
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

    
	public static class Edge {
		public final int v, w; // Vertices of this directed edge v->w
		
		// Constructor for an edge (no loops)
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		// Returns true iff the given object describes this edge
		public boolean equals(Object o) {
			if (!(o instanceof Edge)) return false;
			Edge e = (Edge) o;
			return v == e.v && w == e.w;
		}
		
		// Returns a string representing this edge
		public String toString() {
			return "(" + v + "," + w + ")";
		}
	}
	
	// Constructor for an empty digraph with V vertices.
	@SuppressWarnings("unchecked")
	public Digraph(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		edges = new LinkedList<Edge>();
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}

	// Constructor for a digraph with V vertices and a list of edges.
	public Digraph(int V, LinkedList<Edge> edges) {
		this(V);
		for (Edge e : edges) addEdge(e.v, e.w);
	}

	// Constructor for a new digraph that is a deep copy of the specified digraph.
	public Digraph(Digraph G) {
		this(G.V());
		this.E = G.E();
		for (int v = 0; v < G.V(); v++) {
			// reverse so that adjacency list is in same order as original
			Stack<Integer> reverse = new Stack<Integer>();
			for (int w : G.adj[v]) {
				reverse.push(w);
			}
			for (int w : reverse) {
				adj[v].add(w);
			}
		}
	}
	
	// Returns the number of vertices in this digraph.
	public int V() {
		return V;
	}

	// Returns the number of edges in this digraph.
	public int E() {
		return E;
	}

	// throw an IndexOutOfBoundsException unless 0 <= v < V
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
	}

	// Adds the directed edge v->w to this digraph.
	public void addEdge(int v, int w) {
		addEdge(new Edge(v, w));
	}
	public void addEdge(Edge e) {
		validateVertex(e.v);
		validateVertex(e.w);
		adj[e.v].add(e.w);
		edges.add(e);
		E++;
	}
	
	// Returns the vertices adjacent from vertex <tt>v</tt> in this digraph.
	public LinkedList<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	// Returns a digraph that is the complement of this digraph
	// The complement digraph contains an edge if and only if this digraph does not contain it
	public Digraph complement() {
        Digraph complement = new Digraph(V);
        for (int v = 0; v < V; v++) {
        	for (int w = 0; w < V; w++) {
            	if (v != w && !this.containsEdge(v, w)) {
            		complement.addEdge(v, w);
            	}
            }
        }
        return complement;
	}
	
	// Checks whether the given permutation of vertices is a topological order
	// This method will return true if and only if there are no edges going backwards 
	public boolean isTopological(int[] order) {
		if (order.length != V)
			throw new IllegalArgumentException("order array must be the same length as the number of vertices");
		
		for (int v = 0; v < V; v++){
			for (int w = 0; w < v; w++) {
				if (adj(order[v]).contains(order[w])){
					return false;
				}
			}
		}
		
		return true;
	
	}
	
	// Returns a topological order if there exists one, otherwise returns null
	// This method will return a topological order if and only if this digraph is a DAG 
	public Stack<Integer> topologicalOrder() {
	   DirectedCycle(this);
	   if (hasCycle()) return null;
	   
	   order = new Stack<Integer>();	
	   DepthFirstOrder(this);
	  
       
       while(!postorder.isEmpty()) {
    	   order.push(postorder.dequeue());
       }
       

       return order; 
       
	}
	

	// Returns a shortest path from s to t if there exists one, otherwise returns null
	// This method will return a path if and only if t is reachable from s
	public Stack<Integer> shortestPath(int s, int t) {

		marked = new boolean[V];
        distTo = new int[V];
        edgeTo = new int[V];
        for (int v = 0; v < V; v++)
            distTo[v] = INFINITY;
        bfs(this, s);
        
      
        
        if (!hasPathTo(t)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = t; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
        
	
	}
	
    // BFS from single source
    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

	// Returns a cycle that contains both v and w if there exists one, otherwise returns null
	// This method will return a cycle if and only if v and w are strongly connected
	public Stack<Integer> cycleBetween(int v, int w) {
		Stack<Integer> cycle = new Stack<Integer>();
		Stack<Integer> path0 = dfsPath(v,w);
		Stack<Integer> path1 = dfsPath(w,v);
		
		if (path0 == null || path1 == null) return null;
		
		while(!path0.isEmpty()) {
			int x = path0.pop();
			cycle.push(x);
			
		}
		
		while (!path1.isEmpty()) {
			int y = path1.pop();
			if (y != v && y != w) {
				cycle.push(y);
			}
		}
		
		Stack<Integer> reverse = new Stack<Integer>();
		while(!cycle.isEmpty()) {
			int z = cycle.pop();
			reverse.push(z);
			
		}
		
		return reverse;
        
	}


	// Returns true iff this graph contains the given edge
	public boolean containsEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		return adj[v].contains(w);
	}
	
	// Returns true iff this graph contains all of the edges of the given path
	public boolean containsPath(Stack<Integer> p) {
		if (p.size() < 2) return true;
		int v = -1;
		for (int w : p) {
			if (v >= 0 && !containsEdge(v, w)) return false;
			v = w;
		}
		return true;
	}
	
	// Returns true iff this graph contains all of the edges of the given cycle
	public boolean containsCycle(Stack<Integer> c) {
		if (c.size() == 0) return true;
		int b = c.peek();
		int v = -1;
		for (int w : c) {
			if (v >= 0 && !containsEdge(v, w)) return false;
			v = w;
		}
		return containsEdge(v, b);
	}
	
	// Returns a path from s to t if there exists one, otherwise returns null
	// This method will return a path if and only if t is reachable from s
	public Stack<Integer> dfsPath(int s, int t) {
		marked = new boolean[V];
		return DFS(s, t);
	}
	
	private Stack<Integer> DFS(int v, int t) {
		Stack<Integer> path;
		marked[v] = true;
		for (int w : adj(v)) {
			if (!marked[w]) {
				if (w == t) {
					path = new Stack<Integer>();
					path.push(t);
					path.push(v);
					return path;
				}
				path = DFS(w, t);
				if (path != null) {
					path.push(v);
					return path;
				}
			}
		}
		return null;
	}
	
	// Returns a string that describes this digraph using
	// 1) the number of vertices and edges
	// 2) the list of edges
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices and " + E + " edges : ");
		for (Edge e : edges) {
			s.append(e.toString() + " ");
		}
		return s.toString();
	}

	  
    
    public void DepthFirstOrder(Digraph G) {
        pre    = new int[G.V()];
        post   = new int[G.V()];
        postorder = new Queue<Integer>();
        preorder  = new Queue<Integer>();
        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) PostOrderdfs(G, v);
    }
    
    private void PostOrderdfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
            	PostOrderdfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }
    public void DirectedCycle(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle == null) dfs(G, v);
    }

    // check that algorithm computes either the topological order or finds a directed cycle
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) return;

            //found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    
    
	 public boolean hasPathTo(int v) {
	        return marked[v];
	    }
	 public boolean hasCycle() {
	        return cycle != null;
	    }

	 

}