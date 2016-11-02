package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Bakery {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int src, dest, l, floor;
		long min = -1;
		long inter = Long.MAX_VALUE;

		input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		if (k > 0) {

			int[][] len = new int[n + 1][n + 1];
			boolean[] isStorage = new boolean[n + 1];
			LinkedList<Integer>[] arr = new LinkedList[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = new LinkedList<Integer>();
			}

			for (int i = 1; i <= m; i++) {
				input = bf.readLine().trim().split(" ");
				src = Integer.parseInt(input[0]);
				dest = Integer.parseInt(input[1]);
				l = Integer.parseInt(input[2]);

				arr[src].add(dest);
				arr[dest].add(src);

				if (len[src][dest] != 0 && len[src][dest] < l) {

				} else {
					len[src][dest] = l;
					len[dest][src] = l;
				}
			}

			input = bf.readLine().trim().split(" ");
			for (int i = 0; i < k; i++) {
				floor = Integer.parseInt(input[i]);
				isStorage[floor] = true;
			}

			for (int i = 0; i < k; i++) {
				floor = Integer.parseInt(input[i]);

				for (int j = 0; j < arr[floor].size(); j++) {
					if (!isStorage[arr[floor].get(j)] && len[floor][arr[floor].get(j)] < inter) {
						inter = len[floor][arr[floor].get(j)];
					}
				}
			}

			if (inter == Long.MAX_VALUE) {
				min = -1;
			} else {
				min = inter;
			}

		}

		System.out.println(min);
	}

}

class Point{
	
}