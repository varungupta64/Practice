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

public class SHAIKHGN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int inter, m, k, x;

		int n = Integer.parseInt(bf.readLine().trim());

		LinkedList<Integer>[] adj = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<Integer>();
		}

		for (int i = 1; i <= n; i++) {
			input = bf.readLine().trim().split(" ");
			for (int j = 1; j <= n; j++) {
				inter = Integer.parseInt(input[j - 1]);
				if (inter != 0) {
					adj[i].add(j);
				}
			}
		}

		m = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < m; i++) {
			input = bf.readLine().trim().split(" ");
			k = Integer.parseInt(input[0]);
			x = Integer.parseInt(input[1]);

			Queue<Integer> queue = bfs(adj, x, k);
			bw.write("" + queue.size());
			bw.newLine();
			if (queue.size() == 0) {
				bw.write("-1");
			}
			while (!queue.isEmpty()) {
				bw.write(queue.poll() + " ");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static Queue<Integer> bfs(LinkedList<Integer>[] adj, int x, int k) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		int ele, initSize;
		List<Integer> list = new ArrayList<>();

		while (!queue.isEmpty() && k > 0) {
			initSize = queue.size();
			for (int j = 0; j < initSize; j++) {
				list.add(queue.poll());
			}
			for (int j = 0; j < initSize; j++) {
				ele = list.get(j);
				for (int i = 0; i < adj[ele].size(); i++) {
					if (!queue.contains(adj[ele].get(i))) {
						queue.add(adj[ele].get(i));
					}
				}
			}
			list.removeAll(list);
			k--;
		}

		return queue;
	}

}
