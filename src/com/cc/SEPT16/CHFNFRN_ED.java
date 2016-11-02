package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CHFNFRN_ED {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m;
		Graph_CHFNFRN_ED g;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			g = new Graph_CHFNFRN_ED(n);

			for (int j = 0; j < m; j++) {
				g.addEdge(bf.readLine().trim().split(" "));
			}

			g.complement();

			if (g.isBipartite()) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}

class Graph_CHFNFRN_ED {
	int[][] adj;
	int v;

	public Graph_CHFNFRN_ED(int n) {
		adj = new int[n + 1][n + 1];
		v = n;
	}

	public void addEdge(int src, int dest) {
		adj[src][dest] = 1;
		adj[dest][src] = 1;
	}

	public void addEdge(String[] arr) {
		addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
	}

	public void complement() {
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (adj[i][j] == 1 || i == j) {
					adj[i][j] = 0;
				} else {
					adj[i][j] = 1;
				}
			}
		}
	}

	public boolean isBipartite() {
		int[] color = new int[v + 1];
		int p;
		Arrays.fill(color, -1);

		Queue<Integer> q = new LinkedList<Integer>();

		for (int j = 1; j <= v; j++) {

			if (color[j] == -1) {
				color[j] = 1;
				q.add(j);

				while (!q.isEmpty()) {
					p = q.poll();

					for (int i = 1; i <= v; i++) {

						if (adj[p][i] == 1 && color[i] == -1) {
							color[i] = 1 - color[p];
							q.add(i);
						} else if (adj[p][i] == 1 && color[i] == color[p]) {
							return false;
						}

					}
				}
			}

		}

		return true;
	}
}