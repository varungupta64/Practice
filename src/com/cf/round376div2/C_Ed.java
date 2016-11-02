package com.cf.round376div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class C_Ed {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		input = bf.readLine().trim().split(" ");

		int[] color = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			color[i] = Integer.parseInt(input[i - 1]);
		}

		Graph_C_Ed g1 = new Graph_C_Ed(n);
		for (int i = 0; i < m; i++) {
			input = bf.readLine().trim().split(" ");
			g1.addEdge(input);
		}

		System.out.println(g1.findSocks(k, color));

	}
}

class Graph_C_Ed {
	int v;
	LinkedList<Integer>[] adj;
	boolean[] visited;

	public Graph_C_Ed(int n) {
		this.v = n;
		adj = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		visited = new boolean[n + 1];
	}

	public void addEdge(String[] input) {
		addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
	}

	private void addEdge(int v1, int v2) {
		adj[v1].add(v2);
		adj[v2].add(v1);
	}

	public int findSocks(int k, int[] color) {
		int result = 0;
		int temp;

		for (int i = 1; i <= v; i++) {
			if (!visited[i]) {
				int[] count = new int[k + 1];
				temp = bfs(i, k, color, count);
				Arrays.sort(count);
				result += temp - count[k];
			}
		}

		return result;
	}

	private int bfs(int src, int k, int[] color, int[] count) {
		int result = 1;

		if (visited[src]) {
			return 0;
		}

		count[color[src]]++;
		visited[src] = true;

		for (int i = 0; i < adj[src].size(); i++) {
			result += bfs(adj[src].get(i), k, color, count);
		}

		return result;
	}

}
