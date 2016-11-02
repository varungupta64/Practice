package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class CHFNFRN {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		Graph g1;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			g1 = new Graph(n);

			for (int j = 0; j < m; j++) {
				g1.addEdge(bf.readLine().trim().split(" "));
			}

			g1.dfs();
			if (g1.isPossible()) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}

class Graph {
	int v;
	LinkedList<Integer>[] adj;
	private boolean isPossible;
	int count;
	boolean[] visited;

	public Graph(int v) {
		this.v = v;
		this.adj = new LinkedList[v + 1];
		visited = new boolean[v + 1];
		this.count = 0;
		for (int i = 1; i <= v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public void addEdge(String[] arr) {
		addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
	}

	public void dfs() {
		for (int i = 1; i <= v && count <= 2; i++) {
			if (!visited[i]) {
				dfsUtil(i, -1, ++count);
			}
		}
	}

	private boolean dfsUtil(int u, int parent, int c) {
		if (c > 2) {
			return false;
		}

		if(visited[adj[u].get(0)] && parent != adj[u].get(0)){
			return true;
		}

		for (int i = 0; i < adj[u].size(); i++) {
			if(dfsUtil(adj[u].get(i), u, c)){
				visited[u] = true;
			}
		}

		return false;
	}

	public boolean isPossible() {
		isPossible = true;
		for (int i = 1; i <= v; i++) {
			if (!visited[i]) {
				isPossible = false;
				break;
			}
		}
		return isPossible;
	}

}