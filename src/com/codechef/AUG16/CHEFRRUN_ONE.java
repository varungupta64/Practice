package com.codechef.AUG16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class CHEFRRUN_ONE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		String[] input;
		int[] arr;
		LinkedList<Integer>[] adj;
		int count;
		boolean[] isVisited = null;
		boolean[] isMagicNumber;

		for (int i = 0; i < t; i++) {
			count = 0;
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n + 1];
			adj = new LinkedList[n + 1];
			isVisited = new boolean[n + 1];
			isMagicNumber = new boolean[n + 1];

			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(input[j - 1]);
			}
			for (int j = 1; j <= n; j++) {
				adj[j] = new LinkedList<Integer>();
			}
			for (int j = 1; j <= n; j++) {
				adj[j].add((j + arr[j] + 1) % n == 0 ? n : (j + arr[j] + 1) % n);
			}

			bw.write("" + dfs(adj, isVisited, isMagicNumber, n, count));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int dfs(LinkedList<Integer>[] adj, boolean[] isVisited, boolean[] isMagicNumber, int n, int count) {
		for (int i = 1; i <= n; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				if (!dfsUtil(i, i, adj, isVisited, isMagicNumber, n)) {
					isVisited[i] = false;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (isMagicNumber[i]) {
				count++;
			}
		}
		return count;
	}

	private static boolean dfsUtil(int origin, int src, LinkedList<Integer>[] adj, boolean[] isVisited,
			boolean[] isMagicNumber, int n) {
		int ele;
		for (int i = 0; i < adj[src].size(); i++) {
			ele = adj[src].get(i);
			if (isVisited[ele] && origin == ele) {
				isMagicNumber[ele] = true;
				return true;
			} else if (isVisited[ele] && isMagicNumber[ele]) {
				return false;
			} else {
				if (dfsUtil(origin, ele, adj, isVisited, isMagicNumber, n)) {
					isMagicNumber[ele] = true;
					isVisited[ele] = true;
					return true;
				}
			}
		}
		return false;
	}

	private static int bfs(int src, LinkedList<Integer>[] adj, boolean[] isVisited, boolean[] isMagicNumber, int n) {
		if (isMagicNumber[src] == true) {
			return 1;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		isVisited = new boolean[n + 1];
		for (int i = 0; i < adj[src].size(); i++) {
			queue.add(adj[src].get(i));
		}
		int ele;
		boolean isMagicNum = false;
		while (!queue.isEmpty()) {
			ele = queue.poll();
			isVisited[ele] = true;
			if (ele == src) {
				isMagicNum = true;
				break;
			}
			for (int i = 0; i < adj[ele].size(); i++) {
				if (!isVisited[adj[ele].get(i)]) {
					queue.add(adj[ele].get(i));
				} else {
					isMagicNumber[adj[ele].get(i)] = true;
				}
			}
		}

		if (isMagicNum) {
			isMagicNumber[src] = true;
			return 1;
		}

		return 0;
	}

}
