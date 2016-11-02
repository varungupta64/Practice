package com.cc.SEPT16;

public class LazySegmentTreeDemo {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		LazySegmentTree l = new LazySegmentTree(arr, arr.length);
		System.out.println(l.getSum(arr, 0, 5));
		System.out.println(l.getSum(arr, 0, 4));
		System.out.println(l.getSum(arr, 1, 5));
		System.out.println(l.getSum(arr, 1, 4));
		System.out.println(l.getSum(arr, 2, 5));

		l.update(arr, 2, 4, 1);

		System.out.println("");
		System.out.println(l.getSum(arr, 0, 5));
		System.out.println(l.getSum(arr, 0, 4));
		System.out.println(l.getSum(arr, 1, 5));
		System.out.println(l.getSum(arr, 1, 4));
		System.out.println(l.getSum(arr, 2, 5));

	}
}

class LazySegmentTree {
	int[] st;
	int[] lazy;
	int n;

	public LazySegmentTree(int[] arr, int n) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSize = 2 * (int) Math.pow(2, h) - 1;
		this.st = new int[maxSize];
		this.lazy = new int[maxSize];
		this.n = n;

		populateSegmentTree(arr, 0, n - 1, 0);
	}

	private int populateSegmentTree(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = arr[start];
			return st[current];
		}

		int mid = getMid(start, end);
		st[current] = populateSegmentTree(arr, start, mid, 2 * current + 1)
				+ populateSegmentTree(arr, mid + 1, end, 2 * current + 2);
		return st[current];
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	public int getSum(int[] arr, int l, int r) {
		return getSumUtil(arr, 0, n - 1, l, r, 0);
	}

	private int getSumUtil(int[] arr, int start, int end, int l, int r, int current) {
		if (lazy[current] != 0) {
			st[current] += (end - start + 1) * lazy[current];

			if (start != end) {
				lazy[2 * current + 1] += lazy[current];
				lazy[2 * current + 2] += lazy[current];
			}
			lazy[current] = 0;
		}

		if (l > end || r < start) {
			return 0;
		}

		if (l <= start && r >= end) {
			return st[current];
		}

		int mid = getMid(start, end);
		return getSumUtil(arr, start, mid, l, r, 2 * current + 1)
				+ getSumUtil(arr, mid + 1, end, l, r, 2 * current + 2);
	}

	public void update(int[] arr, int l, int r, int newVal) {
		updateUtil(arr, 0, n - 1, l, r, 0, newVal);
	}

	private void updateUtil(int[] arr, int start, int end, int l, int r, int current, int diff) {
		if (lazy[current] != 0) {
			st[current] += (end - start + 1) * diff;

			if (start != end) {
				lazy[2 * current + 1] += lazy[current];
				lazy[2 * current + 2] += lazy[current];
			}
			lazy[current] = 0;
		}

		if (l > end || r < start) {
			return;
		}

		if (l <= start && r >= end) {
			st[current] += (end - start + 1) * diff;
			if (start != end) {
				lazy[2 * current + 1] += diff;
				lazy[2 * current + 2] += diff;
			}
			return;
		}

		int mid = getMid(start, end);
		updateUtil(arr, start, mid, l, r, 2 * current + 1, diff);
		updateUtil(arr, mid + 1, end, l, r, 2 * current + 2, diff);
		st[current] = st[2 * current + 1] + st[2 * current + 2];
	}
}
