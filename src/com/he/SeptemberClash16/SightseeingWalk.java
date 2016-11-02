package com.he.SeptemberClash16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class SightseeingWalk {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m;
		int[] h;
		Graph g1;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			input = bf.readLine().trim().split(" ");
			h = new int[n + 1];

			for (int j = 0; j < n; j++) {
				h[j + 1] = Integer.parseInt(input[j]);
			}

			g1 = new Graph(n, h);

			for (int j = 0; j < m; j++) {
				g1.addEdge(bf.readLine().trim().split(" "));
			}

			bw.write(""+g1.dfs());
			bw.newLine();
		}

		
		bw.flush();
		bw.close();
		bf.close();
	}

}

class Graph {
	int v;
	Node[] adj;
	int[] h;
	boolean[] visited;
	int max;

	public Graph(int v, int[] h) {
		this.v = v;
		adj = new Node[v + 1];
		this.h = h;
		for (int i = 1; i <= v; i++) {
			adj[i] = new Node(h[i], i);
		}
		visited = new boolean[v + 1];
		max = 0;
	}

	public void addEdge(int src, int dest) {
		adj[src].list.add(dest);
	}

	public void addEdge(String[] arr) {
		addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
	}

	public void sort() {
		NodeComparator n = new NodeComparator();
		Arrays.sort(adj, n);
	}

	public int dfs() {
		for (int i = 1; i <= v; i++) {
			max = Integer.max(max, dfsUtil(adj[i], adj[i].h, 0));
		}
		return max;
	}

	private int dfsUtil(Node node, int height, int max) {
		int diff;
		for (int i = 0; i < node.list.size(); i++) {
			if (!visited[node.list.get(i)]) {
				diff = adj[node.list.get(i)].h - height;
				if (diff > max) {
					max = diff;
				}
				visited[node.list.get(i)] = true;
				if ((diff = dfsUtil(adj[node.list.get(i)], height, max)) > max) {
					max = diff;
				}
			}

		}
		return max;
	}
}

class Node {
	int h;
	LinkedList<Integer> list;
	int index;

	public Node(int h, int index) {
		this.h = h;
		list = new LinkedList<Integer>();
		this.index = index;
	}
}

class NodeComparator implements Comparator<Node> {
	@Override
	public int compare(Node o1, Node o2) {
		return Integer.valueOf(o1.h).compareTo(Integer.valueOf(o2.h));
	}
}