package com.codechef.AprilLunchTime16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class COLORING {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);

		int[] col = new int[n + 1];
		boolean[] isVisited = new boolean[n + 1];

		BinaryTree bt = new BinaryTree(n);

		for (int i = 0; i < q; i++) {
			int u;
			int k;
			int v;
			Set<Integer> colourSet;
			String[] input1 = bf.readLine().trim().split(" ");
			switch (input1[0]) {
			case "1":
				u = Integer.parseInt(input1[1]);
				k = Integer.parseInt(input1[2]);
				update(bt.adj, col, isVisited, u, k, 0);
				initializeIsVisited(isVisited, n);
				// printColour(col, n);
				break;
			case "2":
				u = Integer.parseInt(input1[1]);
				v = Integer.parseInt(input1[2]);
				colourSet = new HashSet<Integer>();
				if (col[u] != 0) {
					colourSet.add(col[u]);
				}
				findPath(bt.adj, col, isVisited, u, v, colourSet);
				System.out.println(colourSet.size());
				initializeIsVisited(isVisited, n);
				break;
			case "3":
				u = Integer.parseInt(input1[1]);
				colourSet = new HashSet<Integer>();
				if (col[u] != 0) {
					colourSet.add(col[u]);
				}
				findSubtree(bt.adj, col, isVisited, u, u / 2, colourSet);
				System.out.println(colourSet.size());
				initializeIsVisited(isVisited, n);
				break;
			}
		}
	}

	private static void findSubtree(LinkedList<Integer>[] adj, int[] col, boolean[] isVisited, int u, int parent,
			Set<Integer> colourSet) {
		if (col[u] != 0) {
			colourSet.add(col[u]);
		}

		isVisited[u] = true;

		for (int i = 0; i < adj[u].size(); i++) {
			if (!isVisited[adj[u].get(i)] && adj[u].get(i) != parent) {
				findSubtree(adj, col, isVisited, adj[u].get(i), adj[u].get(i)/2, colourSet);
			}
		}
	}

	private static boolean findPath(LinkedList<Integer>[] adj, int[] col, boolean[] isVisited, int u, int v,
			Set<Integer> colourSet) {
		if (u == v) {
			if (col[v] != 0) {
				colourSet.add(col[v]);
			}
			return true;
		}

		isVisited[u] = true;

		for (int i = 0; i < adj[u].size(); i++) {
			if (!isVisited[adj[u].get(i)]) {
				if (findPath(adj, col, isVisited, adj[u].get(i), v, colourSet)) {
					// System.out.println(adj[u].get(i) + " -> ");
					if (col[adj[u].get(i)] != 0) {
						colourSet.add(col[adj[u].get(i)]);
					}
					return true;
				}
			}
		}

		return false;
	}

	private static void printColour(int[] col, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " : " + col[i]);
		}
	}

	private static void initializeIsVisited(boolean[] isVisited, int n) {
		for (int i = 1; i <= n; i++) {
			isVisited[i] = false;
		}
	}

	private static void update(LinkedList<Integer>[] adj, int[] col, boolean[] isVisited, int u, int k,
			int pathlength) {
		if (pathlength > k) {
			return;
		}
		col[u] = pathlength;
		isVisited[u] = true;
		for (int i = 0; i < adj[u].size(); i++) {
			if (!isVisited[adj[u].get(i)]) {
				update(adj, col, isVisited, adj[u].get(i), k, pathlength + 1);
			}
		}
	}

	static class BinaryTree {
		int v;
		LinkedList[] adj;

		public BinaryTree(int v) {
			this.v = v;
			adj = new LinkedList[v + 1];

			for (int i = 1; i <= v; i++) {
				adj[i] = new LinkedList<Integer>();
				if (2 * i <= v) {
					adj[i].add(2 * i);
				}
				if (2 * i + 1 <= v) {
					adj[i].add(2 * i + 1);
				}
				if (i != 1) {
					adj[i].add(i / 2);
				}
			}
		}
	}
}
