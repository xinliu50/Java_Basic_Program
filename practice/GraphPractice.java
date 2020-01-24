package practice;
import java.util.*;
public class GraphPractice {
	public static void main(String[]args) {
		Graph g = new Graph(4);
//		g.addEdge(0, 1); 
//        g.addEdge(0, 2); 
//        g.addEdge(1, 2); 
//        g.addEdge(2, 0); 
//        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        println("seach from 0:");
		g.DFS();
		print("\n");
		println("seach from 2:");
		g.DFS(2);
		print("\n");
		println("seach from 1:");
		g.DFS(1);
		print("\n");
		println("seach from 3:");
		g.DFS(3);
		print("\n");
		println("DFSAll:");
		g.DFSAll();
		
	}
	public static void print(Object o) {
		System.out.print(o);
	}
	public static void println(Object o) {
		System.out.println(o);
	}
}

class Graph{
	private int V;
	LinkedList<Integer>[] ls;
	Graph(int size){
		V = size;
		ls = (LinkedList<Integer>[])new LinkedList[size];
		for(int i = 0; i < size; i ++) {
			ls[i] = new LinkedList<Integer>();
		}
	}
	void addEdge(int v, int value) {
		ls[v].add(value);
	}
	void DFSuntil(int v, boolean []visited){
		visited[v] = true;
		System.out.print(v + ", ");
		LinkedList<Integer> tempLs = ls[v];
		for(int i = 0; i < tempLs.size(); i ++) {
			if(!visited[tempLs.get(i)])
				DFSuntil(tempLs.get(i), visited);
		}
	}
	void DFS() {
		boolean[] visited = new boolean[V];
		DFSuntil(0,visited);
	}
	void DFS(int v) {
		boolean[] visited = new boolean[V];
		DFSuntil(v,visited);
	}
	void DFSAll() 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        // starting from all vertices one by one 
        for (int i=0; i<V; ++i) 
            if (visited[i] == false) 
                DFSuntil(i, visited); 
    } 
}


