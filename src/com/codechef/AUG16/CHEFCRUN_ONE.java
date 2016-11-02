package com.codechef.AUG16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CHEFCRUN_ONE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int[] arr;
		int n, start, end;
		LinkedList<Edge>[] adj;
		List<Integer> list;
		int cost;

		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			cost = 0;
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(input[j - 1]);
			}

			adj = new LinkedList[n + 1];

			for (int j = 1; j <= n; j++) {
				adj[j] = new LinkedList<Edge>();
			}

			for (int j = 0; j < n; j++) {
				adj[(j % n) + 1].add(new Edge(arr[(j % n) + 1], (j % n) + 1, ((j + 1) % n) + 1));
				adj[((j + 1) % n) + 1].add(new Edge(arr[(j % n) + 1], ((j + 1) % n) + 1, (j % n) + 1));
			}

			input = bf.readLine().trim().split(" ");
			start = Integer.parseInt(input[0]);
			end = Integer.parseInt(input[1]);

			list = new ArrayList<>();

			findMinPath(adj, start, end, n, cost, list);
			Collections.sort(list);

			bw.write("" + list.get(0));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void findMinPath(LinkedList<Edge>[] adj, int start, int end, int n, int cost, List<Integer> list) {
		if (start == end) {
			list.add(cost);
		}

		if (!adj[start].get(0).isVisited()) {
			adj[start].get(0).setVisited(true);
			findMinPath(adj, adj[start].get(0).getDest(), end, n, cost + adj[start].get(0).getWeight(), list);
			adj[start].get(0).setVisited(false);
		}

		if (!adj[start].get(1).isVisited()) {
			adj[start].get(1).setVisited(true);
			findMinPath(adj, adj[start].get(1).getDest(), end, n, adj[start].get(1).getWeight() + cost, list);
			adj[start].get(1).setVisited(false);
		}
	}
}

class Edge {
	private int weight;
	private int src;
	private int dest;
	private boolean isVisited;

	public Edge(int weight, int src, int dest) {
		this.weight = weight;
		this.src = src;
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}
