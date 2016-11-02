package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PT07Z {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());

		Tree_PT07Z tree = new Tree_PT07Z(n);

		for (int i = 1; i <= n - 1; i++) {
			tree.addEdge(bf.readLine().trim().split(" "));
		}

		System.out.println(tree.findMaxLength());
	}
}

class Tree_PT07Z {
	private int n;
	private LinkedList<Integer>[] adj;

	public Tree_PT07Z(int n) {
		this.n = n;
		adj = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(String[] input) {
		addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
	}

	private void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public int findMaxLength() {
		if (n == 0) {
			return 0;
		}
		int farthestNode = bfs(1, true);
		return bfs(farthestNode, false);
	}

	public int bfs(int src, boolean isCallForFarthestNode) {
		int length = 0;
		boolean[] isVisited = new boolean[n + 1];

		Queue<Info_PT07Z> queue = new LinkedList<Info_PT07Z>();
		queue.add(new Info_PT07Z(src, 0));

		Info_PT07Z info = null;
		int farthestNode = 0;
		while (!queue.isEmpty()) {
			info = queue.poll();
			if (length < info.level) {
				length = info.level;
				farthestNode = info.node;
			}
			isVisited[info.node] = true;
			for (int i = 0; i < adj[info.node].size(); i++) {
				if (!isVisited[adj[info.node].get(i)]) {
					queue.add(new Info_PT07Z(adj[info.node].get(i), info.level + 1));
				}
			}
		}

		if (isCallForFarthestNode) {
			return farthestNode;
		}

		return length;
	}
}

class Info_PT07Z {
	int node;
	int level;

	public Info_PT07Z(int node, int level) {
		this.node = node;
		this.level = level;
	}
}