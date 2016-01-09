//
// AdjMatrixGraph --- Graph representation using an adjacency matrix
// 
// HOMEWORK in this file is to implement:
//
// 1) public AdjMatrixGraph(AdjListGraph G)
//    Clone the graph given in the adjacency list representation
//    You will need to use the adj method of G
//
// 2) public AdjMatrixGraph inducedSubgraph(boolean inducedBy[])
//    Create an induced subgraph of this graph using the vertices v with inducedBy[v] = true
//    A subgraph H of G is a graph whose vertex set S is a subset of the vertex set of G,
//    and whose edges are a subset of the edge set of G.  H is an induced subgraph of G,
//    if it has exactly the edges that appear in G over S, in which case
//    H is said to be induced by S.  S is the argument of this method.
//
// 3) public SimpleCycle threeCycle()
//    Find a three cycle if there exists one
//
// 4) public SimpleCycle oddCycle()
//    Find an odd cycle if there exists one (bipartite check)
//    WARNING : DO NOT USE Breadth First Search
//
// 5) public SimpleCycle anyCycle()
//    Find any length cycle (length of at least 3) if there exists one
//    WARNING : DO NOT USE Breadth First Search
//
// 6) public void CC()
//    Assign the connected components
//    WARNING : DO NOT USE Breadth First Search
//
// One of the methods will be bonus
//

package hw4;

import java.util.LinkedList;

public class AdjMatrixGraph extends GraphBase {
	private boolean[][] adj;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path
    private boolean isBipartite;   // is the graph bipartite?
    private boolean[] color;       // color[v] gives vertices on one side of bipartition
    private int[] edgeTo;          // edgeTo[v] = last edge on path to v
    private SimpleCycle oddCycle;  // odd-length cycle
    private SimpleCycle cycle;  // any cycle
   
	// Constructor for an empty graph with V vertices and 0 edges.
	public AdjMatrixGraph(int V) {
		super(V);
		adj = new boolean[V][V];
	}
	
	// Constructor for a graph with V vertices and a list of edges.
	public AdjMatrixGraph(int V, LinkedList<Edge> edges) {
		this(V);
		for (Edge e : edges) addEdge(e);
	}
	
	// Constructor for deep copying a graph
	public AdjMatrixGraph(AdjMatrixGraph G) {
		this(G.V);
		E = G.E;
		for (int v = 0; v < V; v++) {
			for (int w = 0; w < V; w++) {
				adj[v][w] = G.adj[v][w];
			}
		}
	}
	
	// Constructor for copying a graph using an adjacency list representation
	public AdjMatrixGraph(AdjListGraph G) {
		this(G.V);
		E = G.E;
		for (int v = 0; v < G.V; v++) {
			for (int w : G.adj(v)) {
				adj[v][w] = true; 
			}
		}
				
	}
	
	// Returns the induced subgraph restricted to those vertices v with inducedBy[v] = true
	public AdjListGraph inducedSubgraph(boolean inducedBy[]) {
		if (inducedBy.length != V)
			throw new IllegalArgumentException("inducedBy argument must be the same length as the number of vertices");
		// TODO : COMPLETE THIS METHOD
		return null;
	}
	
	// Returns a simple cycle of length three if one exists, or null otherwise
	public SimpleCycle threeCycle() {
		SimpleCycle c = new SimpleCycle(V);
		for (int v = 0; v < V; v++) {
			for (int w = 0; w < V; w++) {
				for (int u = 0; u < V; u++) {
					if (v != w && w != v && u != v) {
						if (adjRow(v)[w] && adjRow(w)[u] && adjRow(u)[v]) {
							c.addVertex(w);
							c.addVertex(u);
							c.addVertex(v);
							if (c.size() == 3) return c;
						}						
					}
				}
			}
		} 
		return null;
	}
	
	// Returns a simple cycle of odd length if one exists, or null otherwise
	public SimpleCycle oddCycle() {
		 distTo = new int[V];
		 isBipartite = true;
	     color  = new boolean[V];
	     marked = new boolean[V];
	     edgeTo = new int[V];
        for (int v = 0; v < V; v++) {
        		if (!marked[v]) {
        			OddCyclebfs(this, v);
        		}
        }
        
        if (isBipartite == false){
        	return oddCycle;
        } else {
        	return null;
        }
       
	}
	
	// Returns a simple cycle of any length >= 3 if one exists, or null otherwise
	public SimpleCycle anyCycle() {
        marked = new boolean[V];
        edgeTo = new int[V];
		distTo = new int[V];
        for (int v = 0; v < V; v++)
            if (!marked[v])
            	anyCycledfs(this, -1, v);
        
        if (cycle != null){
        	return cycle;
        } else {
        	return null;
        }

	}
	
	// Assigns connected component ids to all vertices
	public void CC() {
		resetVars(); // defined in GraphBase.java

		 marked = new boolean[this.V()];
		 distTo = new int[V];
	     edgeTo = new int[V];
	      id = new int[V];
	        for (int v = 0; v < V; v++) {
	            if (!marked[v]) {
	                bfs(this, v);
	                count++;
	            }
	        }
		
	}
	
	// Returns the adjacency information for the given vertex
	public boolean[] adjRow(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	// Returns true iff this graph contains the given edge
	protected boolean containsValid(Edge e) {
		return adj[e.v][e.w];
	}
	
	// Adds an edge to this graph that is already confirmed to be valid
	protected void addValidEdge(Edge e) {
		super.addValidEdge(e);
		adj[e.v][e.w] = true;
		adj[e.w][e.v] = true;
	}
	
	// breadth-first search from a single source
	private void bfs(AdjMatrixGraph G, int s) {
		   Queue<Integer> q = new Queue<Integer>();
		   q.enqueue(s);
		   marked[s] = true;
	       id[s] = count;
		   distTo[s] = 0;
		   while (!q.isEmpty()) {
		      int v = q.dequeue();
	    		for (int w = 0; w < V; w++) {
	    			if (w != v && G.contains(v, w)){
	   		         if (!marked[w]) {
	 		            bfs(G, w);
	 		            marked[w] = true;
	 		            edgeTo[w] = v;
	 		            distTo[w] = distTo[v] + 1;
	 		            q.enqueue(w);
	 		         } 
	    			}
		         }
		} }


    
	// breadth-first search from a single source
    private void OddCyclebfs(AdjMatrixGraph G, int s) {
        distTo[s] = 0;
        marked[s] = true;
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
    		for (int w = 0; w < V; w++) {
    			if (w != v && G.contains(v, w)){
    				  // short circuit if odd-length cycle found
                    if (oddCycle != null) return;

                    // found uncolored vertex, so recur
                    if (!marked[w]) {
                        edgeTo[w] = v;
                        color[w] = !color[v];
                        distTo[w] = distTo[v] + 1;
                        marked[w] = true;
                        OddCyclebfs(G, w);
                        q.enqueue(w);
                    } 

                    // if v-w create an odd-length cycle, find it
                    else if (color[w] == color[v]) {
                        isBipartite = false;
                        oddCycle = new SimpleCycle(G.V);
                        for (int x = v; x != w; x = edgeTo[x]) {
                       	 oddCycle.addVertex(x);
                        }
                        oddCycle.addVertex(w);
                    }

    			}

              
    		}
        }
    }
    
    private void anyCycledfs(AdjMatrixGraph G, int u, int v) {
        marked[v] = true;
        for (int w = 0; w < V; w++) {
			if (w != v && G.contains(v, w)){

				// short circuit if cycle already found
				if (cycle != null) return;

				if (!marked[w]) {
					edgeTo[w] = v;
					anyCycledfs(G, v, w);
				}

				// check for cycle (but disregard reverse of edge leading to v)
				else if (w != u) {
					cycle = new SimpleCycle(G.V);
					for (int x = v; x != w; x = edgeTo[x]) {
						cycle.addVertex(x);
					}
					cycle.addVertex(w);
				}
			}
        }
    }
}