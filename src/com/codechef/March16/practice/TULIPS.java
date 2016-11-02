package com.codechef.March16.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TULIPS {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = getInput(0);
		for (int i = 0; i < t; i++) {
			int n = getInput(0);
			Graph g = new Graph(n);

			for (int j = 0; j < n - 1; j++) {
				String[] input = getInput("");
				g.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			}

			String[] input1 = getInput("");
			int q = Integer.parseInt(input1[0]);
			int x = Integer.parseInt(input1[1]);

			for (int j = 0; j < q; j++) {
				String[] input = getInput("");

				int d = Integer.parseInt(input[0]);
				int u = Integer.parseInt(input[1]);
				int k = Integer.parseInt(input[2]);

				System.out.println(getCherryCollected(g, x, d, u, k));

			}
		}
	}

	private static int getCherryCollected(Graph g, int x, int d, int u, int k) {
		for (int i = 1; i < g.visited.length; i++) {
			g.visited[i] = false;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(u);
		g.visited[u] = true;
		int sum = 0;

		if (g.counter[u] - d <= 0) {
			sum += 1;
		}
		g.counter[u] = d + x;

		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int i = 0; i < g.adj[v].size(); i++) {
				Integer[] next = g.adj[v].get(i);
				if (next[1] <= k && !g.visited[next[0]]) {

					if (g.counter[next[0]] - d <= 0) {
						sum += 1;
					}
					g.counter[next[0]] = d + x;

					queue.add(next[0]);
					g.visited[next[0]] = true;
				}
			}
		}

		return sum;
	}

	private static String getInput() throws IOException {
		return bf.readLine().trim();
	}

	private static String[] getInput(String a) throws IOException {
		return bf.readLine().trim().split(" ");
	}

	private static int getInput(int a) throws IOException {
		return Integer.parseInt(bf.readLine().trim());
	}

	static class Graph {
		private int vertices;
		private LinkedList<Integer[]>[] adj;
		private int[] counter;
		private boolean[] visited;

		public Graph(int vertices) {
			this.vertices = vertices;
			adj = new LinkedList[vertices + 1];
			counter = new int[vertices + 1];
			visited = new boolean[vertices + 1];
			for (int i = 1; i <= vertices; i++) {
				adj[i] = new LinkedList<Integer[]>();
			}
		}

		public void addEdge(int src, int dest, int capacity) {
			Integer[] a = new Integer[2];
			Integer[] b = new Integer[2];

			a[0] = src;
			a[1] = capacity;

			b[0] = dest;
			b[1] = capacity;

			adj[src].add(b);
			adj[dest].add(a);
		}
	}

}
