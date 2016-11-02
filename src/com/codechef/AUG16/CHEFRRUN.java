package com.codechef.AUG16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CHEFRRUN {

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
			for (int j = 1; j <= n; j++) {
				count += bfs(j, adj, isVisited, isMagicNumber, n);
			}
			bw.write("" + count);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int bfs(int src, LinkedList<Integer>[] adj, boolean[] isVisited, boolean[] isMagicNumber, int n) {
		if (isMagicNumber[src] == true) {
			return 1;
		}

		List<Integer> list = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		isVisited = new boolean[n + 1];
		for (int i = 0; i < adj[src].size(); i++) {
			queue.add(adj[src].get(i));
		}
		int ele;
		boolean isMagicNum = false;
		while (!queue.isEmpty()) {
			ele = queue.poll();
			list.add(ele);
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
			for(int i=0;i<list.size();i++){
				isMagicNumber[list.get(i)] = true;
			}
			return 1;
		}

		return 0;
	}

}
