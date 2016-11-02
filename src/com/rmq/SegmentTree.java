package com.rmq;

import java.util.Arrays;

public class SegmentTree {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 7, 9, 11 };
		int n = arr.length;

		int[] segmentTree = buildSegmentTree(arr, n);
		populateSegmentTree(arr, segmentTree, 0, n - 1, 0);
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 2, 5));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 3, 5));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 0, 4));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 4, 4));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 3, 4));

		updateUtil(segmentTree, arr, 0, n - 1, 0, 4, 4);

		System.out.println("");
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 2, 5));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 3, 5));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 0, 4));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 4, 4));
		System.out.println(RMQ(segmentTree, 0, n - 1, 0, 3, 4));
	}

	private static void updateUtil(int[] segmentTree, int[] arr, int start, int end, int current, int index,
			int newVal) {
		arr[index] = newVal;
		update(segmentTree, arr, start, end, current, index, newVal);
	}

	private static int update(int[] segmentTree, int[] arr, int start, int end, int current, int index, int newVal) {
		if (index < start || index > end) {
			return Integer.MAX_VALUE;
		}

		if (start == end) {
			segmentTree[current] = newVal;
			return segmentTree[current];
		}
		int mid = getMid(start, end);
		segmentTree[current] = min(update(segmentTree, arr, start, mid, 2 * current + 1, index, newVal),
				update(segmentTree, arr, mid + 1, end, 2 * current + 2, index, newVal));
		return segmentTree[current];
	}

	private static int RMQ(int[] segmentTree, int start, int end, int current, int l, int r) {
		if (l <= start && r >= end) {
			return segmentTree[current];
		}

		if (start > r || end < l) {
			return Integer.MAX_VALUE;
		}
		int mid = getMid(start, end);
		return min(RMQ(segmentTree, start, mid, 2 * current + 1, l, r),
				RMQ(segmentTree, mid + 1, end, 2 * current + 2, l, r));
	}

	private static int populateSegmentTree(int[] arr, int[] segmentTree, int start, int end, int current) {
		if (start == end) {
			segmentTree[current] = arr[start];
			return segmentTree[current];
		}
		int mid = getMid(start, end);
		segmentTree[current] = min(populateSegmentTree(arr, segmentTree, start, mid, 2 * current + 1),
				populateSegmentTree(arr, segmentTree, mid + 1, end, 2 * current + 2));
		return segmentTree[current];
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}

	private static int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	private static int[] buildSegmentTree(int[] arr, int n) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSizeArr = 2 * (1 << h) - 1;
		int[] segmentTree = new int[maxSizeArr];

		Arrays.fill(segmentTree, Integer.MAX_VALUE);

		return segmentTree;
	}

}
