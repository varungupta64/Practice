package com.cc.CDJA2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class KM01 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int n, m, k, q;
		int a, b;
		int sum;
		int t = Integer.parseInt(bf.readLine().trim());
		int[] parent;
		HashMap<Integer, Integer> map;
		List<Integer> list;

		for (int i = 0; i < t; i++) {
			sum = 0;
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			k = Integer.parseInt(input[2]);
			q = Integer.parseInt(input[3]);

			parent = new int[n + 1];
			map = new HashMap<Integer, Integer>(n);

			for (int j = 0; j < m; j++) {

				input = bf.readLine().trim().split(" ");
				a = Integer.parseInt(input[0]);
				b = Integer.parseInt(input[1]);

				if (parent[a] == 0 && parent[b] == 0) {
					map.put(a, 2);
					parent[a] = a;
					parent[b] = a;
				} else if (parent[a] == 0) {
					parent[a] = parent[b];
					map.put(parent[b], map.get(parent[b]) + 1);
				} else if (parent[b] == 0) {
					parent[b] = parent[a];
					map.put(parent[a], map.get(parent[a]) + 1);
				} else {

					for (int v = 1; v <= n; v++) {
						if (parent[v] == parent[b]) {
							parent[v] = parent[a];
						}
					}
					map.put(parent[a], map.get(parent[a]) + map.get(parent[b]));
					map.remove(parent[b]);

				}

			}

			list = new ArrayList<>(map.values());
			Collections.sort(list, Collections.reverseOrder());

			for (int j = 0; j < k; j++) {
				if(k<list.size()){
					sum += list.get(j);
				}else{
					sum += 1;
				}
			}

			if (sum >= q) {
				bw.write("Satisfied");
			} else {
				bw.write("Unsatisfied");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();

	}

}
