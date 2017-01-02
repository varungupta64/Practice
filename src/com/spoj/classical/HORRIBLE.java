package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HORRIBLE {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, c, p, q, v;
		long[] arr;
		SegmentTree_HORRIBLE segTree;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			c = Integer.parseInt(input[1]);
			arr = new long[n];
			segTree = new SegmentTree_HORRIBLE(arr, n);
			while (c-- > 0) {
				input = bf.readLine().trim().split(" ");
				switch (input[0]) {
				case "0":
					p = Integer.parseInt(input[1]);
					q = Integer.parseInt(input[2]);
					v = Integer.parseInt(input[3]);
					segTree.add(p-1, q-1, v);
					break;
				case "1":
					p = Integer.parseInt(input[1]);
					q = Integer.parseInt(input[2]);
					bw.write("" + segTree.query(p-1, q-1));
					bw.newLine();
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}

class SegmentTree_HORRIBLE {
	int n;
	long[] st;
	long[] arr;

	public SegmentTree_HORRIBLE(long[] arr, int n) {
		this.n = n;
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSize = 2*(int) Math.pow(2, h) - 1;
		st = new long[maxSize];
		this.arr = arr;
	}

	public long query(int l, int r) {
		return queryUtil(l, r, 0, n - 1, 0);
	}

	private long queryUtil(int left, int right, int start, int end, int current) {
		if (start > end || left > end || right < start) {
			return 0;
		}
		if (left <= start && right >= end) {
			return st[current];
		}
		int mid = getMid(start, end);
		long p1 = queryUtil(left, right, start, mid, 2 * current + 1);
		long p2 = queryUtil(left, right, mid + 1, end, 2 * current + 2);
		return p1 + p2;
	}

	public void add(int l, int r, int v) {
		addUtil(l, r, 0, n - 1, 0, v);
	}

	private void addUtil(int left, int right, int start, int end, int current, int val) {
		if (start > end || left > end || right < start) {
			return;
		}
		if (start == end) {
			st[current] += val;
			return;
		}
		int mid = getMid(start, end);
		addUtil(left, right, start, mid, 2 * current + 1, val);
		addUtil(left, right, mid + 1, end, 2 * current + 2, val);
		st[current] = st[2 * current + 1] + st[2 * current + 2];
	}

	private int getMid(int left, int right) {
		return left + (right - left) / 2;
	}
}