package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DIVMAC {

	static final int maxNum = (int) 1e6;
	// leastPrimeDivisor
	static int[] lpd = new int[maxNum + 1];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		populateLeastPrimeDivisor();

		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		int[] arr;
		int l, r;
		SegmentTree sTree;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			arr = new int[n];

			input = bf.readLine().trim().split(" ");
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			sTree = new SegmentTree(arr, n, lpd);

			for (int j = 0; j < m; j++) {
				input = bf.readLine().trim().split(" ");
				l = Integer.parseInt(input[1]);
				r = Integer.parseInt(input[2]);
				switch (input[0]) {
				case "0":
					for (int k = l - 1; k <= r - 1; k++) {
						arr[k] = arr[k] / lpd[arr[k]];
					}
					sTree.update(arr, 0, n - 1, 0, l - 1, r - 1);
					break;
				case "1":
					bw.write(sTree.get(0, n - 1, 0, l - 1, r - 1) + " ");
					break;
				}
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void populateLeastPrimeDivisor() {
		boolean[] visited = new boolean[maxNum + 1];
		lpd[1] = 1;
		visited[1] = true;

		for (int i = 2; i <= maxNum; i++) {
			if (!visited[i]) {
				for (int j = 1; j * i <= maxNum; j++) {
					if (!visited[j * i]) {
						visited[j * i] = true;
						lpd[j * i] = i;
					}
				}
			}
		}
	}

}

class SegmentTree {
	int[] st;
	int[] lpd;

	public SegmentTree(int[] arr, int n, int[] lpd) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSizeArr = 2 * (1 << h) - 1;
		st = new int[maxSizeArr];
		this.lpd = lpd;

		populateSegmentTree(arr, 0, n - 1, 0);
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	private int populateSegmentTree(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = lpd[arr[start]];
			return st[current];
		}
		int mid = getMid(start, end);
		st[current] = max(populateSegmentTree(arr, start, mid, 2 * current + 1),
				populateSegmentTree(arr, mid + 1, end, 2 * current + 2));
		return st[current];
	}

	public int get(int start, int end, int current, int l, int r) {
		if (l <= start && r >= end) {
			return st[current];
		}

		if (start > r || end < l) {
			return 1;
		}
		int mid = getMid(start, end);
		return max(get(start, mid, 2 * current + 1, l, r), get(mid + 1, end, 2 * current + 2, l, r));
	}

	public int update(int[] arr, int start, int end, int current, int l, int r) {
		if (start > r || end < l) {
			return st[current];
		}

		if (start == end) {
			st[current] = lpd[arr[start]];
			return st[current];
		}

		int mid = getMid(start, end);
		st[current] = max(update(arr, start, mid, 2 * current + 1, l, r),
				update(arr, mid + 1, end, 2 * current + 2, l, r));
		return st[current];

	}
}