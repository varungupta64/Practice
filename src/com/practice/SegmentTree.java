package com.practice;

public class SegmentTree {
	int[] segmentTree;

	public SegmentTree(int[] arr, int n) {
		int x = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSize = 2 * (int) Math.pow(2, x) - 1;
		segmentTree = new int[maxSize];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		SegmentTree segmentTreeObj = new SegmentTree(arr, n);
		segmentTreeObj.buildSegmentTree(arr, 0, n - 1, 0);
		
		System.out.println("Built segment tree");
	}

	private int buildSegmentTree(int[] arr, int start, int end, int current) {
		if (start == end) {
			segmentTree[current] = arr[start];
			return arr[start];
		}

		int mid = getMid(start, end);
		segmentTree[current] = buildSegmentTree(arr, start, mid, (current*2)+1) + buildSegmentTree(arr, mid+1, end, (current*2)+2);
		return segmentTree[current];
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

}
