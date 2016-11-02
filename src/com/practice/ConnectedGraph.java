package com.practice;

import java.util.Iterator;
import java.util.LinkedList;

public class ConnectedGraph {

	public static void main(String[] args) {
		// Create graphs given in the above diagrams
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        if (g1.isStronglyConnected())
            System.out.println("Yes");
        else
            System.out.println("No");
 
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        if (g2.isStronglyConnected())
            System.out.println("Yes");
        else
            System.out.println("No");
	}

	// Directed Graph
	static class Graph {
		// vertices
		int v;
		LinkedList<Integer>[] adj;

		Graph(int v) {
			this.v = v;
			this.adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int u, int v) {
			adj[u].add(v);
		}

		boolean isStronglyConnected() {
			boolean[] isVisited = new boolean[v];
			DFSUtil(0, isVisited);

			for (int i = 0; i < v; i++) {
				if (isVisited[i] == false) {
					return false;
				}
			}
			
			Graph g = getTranspose();

			for(int i=0;i<v;i++){
				isVisited[i] = false;
			}
			
			g.DFSUtil(0, isVisited);
			
			for (int i = 0; i < v; i++) {
				if (isVisited[i] == false) {
					return false;
				}
			}
			
			return true;
		}

		private Graph getTranspose() {
			Graph g = new Graph(v);
			for(int i=0;i<v;i++){
				Iterator<Integer> it = adj[i].iterator();
				while(it.hasNext()){
					g.adj[it.next()].add(i);
				}
			}
			return g;
		}

		private void DFSUtil(int i, boolean[] isVisited) {
			isVisited[i] = true;
			Iterator<Integer> it = adj[i].iterator();
			int n;
			
			while (it.hasNext()) {
				n = it.next();
				if (!isVisited[n]) {
					DFSUtil(n, isVisited);
				}
			}
		}

	}
}
