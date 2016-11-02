package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CHFNFRN_TWO {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		GraphTwo g1;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			g1 = new GraphTwo(n);

			for (int j = 0; j < m; j++) {
				g1.addEdge(bf.readLine().trim().split(" "));
			}

			if (n <= 2) {
				bw.write("YES");
			} else if (n == 3 && m >= 1) {
				bw.write("YES");
			} else if (n >= 2 && m == 0) {
				bw.write("NO");
			} else {
				if (g1.populateTables()) {
					bw.write("YES");
				} else {
					bw.write("NO");
				}
			}

			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}
}

class GraphTwo {
	int v;
	boolean[][] adj;
	boolean[] visited;
	List<Integer>[] table;

	public GraphTwo(int v) {
		this.v = v;
		adj = new boolean[v + 1][v + 1];
		visited = new boolean[v + 1];
		table = new List[2];
		for (int i = 0; i <= 1; i++) {
			table[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		adj[src][dest] = true;
		adj[dest][src] = true;
	}

	public void addEdge(String[] arr) {
		addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
	}

	public boolean populateTables() {
		int count = 0;
		boolean isConnected = true;

		for (int i = 1; i <= v; i++) {
			if (!visited[i]) {
				if (count > 1) {
					isConnected = false;
					break;
				}
				table[count].add(i);
				bfsUtil(i, count);
				count++;
			}
		}

		if (!isConnected) {
			return false;
		} else {
			return examineTableZero();
		}
	}

	private boolean examineTableZero() {
		int count = 0;
		int index = 1;
		int size = table[count].size();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					continue;
				}
				if (!adj[table[count].get(i)][table[count].get(j)]) {

					int[] arr = { i, j };
					boolean[] isPossible = { true, true };
					for (int k = 0; k <= 1; k++) {
						for (int l = 0; l < table[index].size(); l++) {
							if (!adj[table[count].get(arr[k])][table[index].get(l)]) {
								isPossible[k] = false;
								break;
							}
						}
					}

					if (isPossible[0] && isPossible[1]) {
						
						for (int k = 0; k <= 1; k++) {
							for (int l = 0; l < table[count].size(); l++) {
								if(l == arr[0] || l == arr[1]){
									continue;
								}
								
								if (!adj[table[count].get(arr[k])][table[count].get(l)]) {
									if(k==0){
										isPossible[1] = false;
									}else{
										isPossible[0] = false;
									}
									break;
								}
							}
						}
						
					} 
					
					if (isPossible[0]) {
						table[index].add(table[count].get(i));
						table[count].remove(i);
						i--;
					} else if (isPossible[1]) {
						table[index].add(table[count].get(j));
						table[count].remove(j);
					} else {
						return false;
					}

					size--;
				}
			}
		}

		return examineTableTwo();
	}

	private boolean examineTableTwo() {
		boolean result = true;
		int count = 1;

		for (int i = 0; i < table[count].size(); i++) {
			for (int j = 0; j < table[count].size(); j++) {
				if (i == j) {
					continue;
				}
				if (!adj[table[count].get(i)][table[count].get(j)]) {
					result = false;
					break;
				}
			}

			if (!result) {
				break;
			}
		}

		return result;
	}

	private void bfsUtil(int u, int count) {
		visited[u] = true;

		for (int i = 1; i <= adj[u].length - 1; i++) {
			if (adj[u][i] && !visited[i]) {
				visited[i] = true;
				table[count].add(i);
			}
		}
	}
}
