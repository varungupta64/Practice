package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GSS1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int l, r;
		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n];
		input = bf.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		SegmentTree_GSS1 segTree = new SegmentTree_GSS1(n, arr);
		int m = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < m; i++) {
			input = bf.readLine().trim().split(" ");
			l = Integer.parseInt(input[0]);
			r = Integer.parseInt(input[1]);
			bw.write("" + segTree.query(l - 1, r - 1));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}
}

class SegmentTree_GSS1 {
	int n;
	int[] st;

	public SegmentTree_GSS1(int n, int[] arr) {
		this.n = n;
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int max = 2 * (int) Math.pow(2, h) - 1;
		st = new int[max];
		buildSegmentTree(arr, 0, n - 1, 0);
	}

	private int buildSegmentTree(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = arr[start];
			return st[current];
		}
		int mid = getMid(start, end);
		int x = buildSegmentTree(arr, start, mid, 2 * current + 1);
		int y = buildSegmentTree(arr, mid + 1, end, 2 * current + 2);
		st[current] = Integer.max(x + y, Integer.max(x, y));
		return st[current];
	}

	public int query(int l, int r) {
		return queryUtil(0, n - 1, l, r, 0);
	}

	private int queryUtil(int start, int end, int l, int r, int current) {
		if (l > end || r < start) {
			return -10000000;
		}
		if (l <= start && r >= end) {
			return st[current];
		}
		int mid = getMid(start, end);
		int x = queryUtil(start, mid, l, r, 2 * current + 1);
		int y = queryUtil(mid + 1, end, l, r, 2 * current + 2);
		return Integer.max(x + y, Integer.max(x, y));
	}

	private int getMid(int start, int end) {
		return start + ((end - start) / 2);
	}
}