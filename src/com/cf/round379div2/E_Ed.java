package com.cf.round379div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class E_Ed {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");

		int[] colour = new int[n + 1];
		boolean[] isVisited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			colour[i] = Integer.parseInt(input[i - 1]);
		}

		Tree_E_Ed tree = new Tree_E_Ed(n);

		for (int i = 1; i <= n - 1; i++) {
			tree.addEdge(bf.readLine().trim().split(" "));
		}

		int blackComponents = 0;
		int whiteComponents = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		int ele;
		
		//bfs
		for (int i = 1; i <= n; i++) {
			if (!isVisited[i]) {
				queue.add(i);
				
				while(!queue.isEmpty()){
					ele = queue.poll();
					isVisited[ele] = true;
					for (int j = 0; j < tree.adj[ele].size(); j++) {
						if (!isVisited[tree.adj[ele].get(j)] && colour[i] == colour[tree.adj[ele].get(j)]) {
							queue.add(tree.adj[ele].get(j));
						}
					}
					
				}

				if (colour[i] == 0) {
					whiteComponents++;
				} else {
					blackComponents++;
				}
			}
		}

		System.out.println(Integer.min(whiteComponents, blackComponents));
		
	}
}

class Tree_E_Ed {
	int v;
	LinkedList<Integer>[] adj;

	public Tree_E_Ed(int v) {
		this.v = v;
		adj = new LinkedList[v + 1];

		for (int i = 1; i <= v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public void addEdge(String[] input) {
		addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
	}
}
