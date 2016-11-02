package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class CHFNFRN_ONE {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		GraphOne g1;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			g1 = new GraphOne(n);

			for (int j = 0; j < m; j++) {
				g1.addEdge(bf.readLine().trim().split(" "));
			}

			if (n <= 2) {
				bw.write("YES");
			} else if (n == 3 && m >= 1) {
				bw.write("YES");
			} else if (n == 3 && m == 0) {
				bw.write("NO");
			} else {
				g1.removeAllBridges();
				g1.bfs();

				if (g1.isPossible()) {
					bw.write("YES");
				} else {
					bw.write("NO");
				}
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}

}

class GraphOne {
	int v;
	LinkedList<Integer>[] adj;
	int time;
	private boolean isPossible;
	int count;
	boolean[] visited;

	public GraphOne(int v) {
		this.v = v;
		adj = new LinkedList[v + 1];
		for (int i = 1; i <= v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		visited = new boolean[v + 1];
		time = 0;
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public void addEdge(String[] arr) {
		addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
	}

	private void removeEdge(int src, int dest) {
		adj[src].removeFirstOccurrence(dest);
		adj[dest].removeFirstOccurrence(src);
	}

	public void bfs() {
		for (int i = 1; i <= v; i++) {
			visited[i] = false;
		}
		
		for (int i = 1; i <= v && count <= 2; i++) {
			if (!visited[i]) {
				bfsUtil(i, ++count);
			}
		}
	}

	private void bfsUtil(int u, int c) {
		if (c > 2) {
			return;
		}

		visited[u] = true;
		for (int i = 0; i < adj[u].size(); i++) {
			visited[adj[u].get(i)] = true;
		}
	}

	public void removeAllBridges() {
		int disc[] = new int[v + 1];
		int low[] = new int[v + 1];
		int parent[] = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			if (visited[i] == false) {
				bridgeUtil(i, disc, low, parent);
			}
		}
	}

	private void bridgeUtil(int u, int[] disc, int[] low, int[] parent) {
		visited[u] = true;
		disc[u] = low[u] = ++time;
		Iterator<Integer> i = adj[u].iterator();
		while (i.hasNext()) {
			int v = i.next();
			if (!visited[v]) {
				parent[v] = u;
				bridgeUtil(v, disc, low, parent);
				low[u] = Math.min(low[u], low[v]);
				if (low[v] > disc[u]) {
					removeEdge(u, v);
				}
			} else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
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
