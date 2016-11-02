package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GSS3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] ip = bf.readLine().trim().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(ip[i]);
		}

		SegmentTree tree = new SegmentTree(arr, n);

		int q = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int[] intArr = new int[3];

		for (int i = 0; i < q; i++) {
			input = bf.readLine().trim().split(" ");

			for (int j = 0; j <= 2; j++) {
				intArr[j] = Integer.parseInt(input[j]);
			}

			switch (intArr[0]) {
			case 0:
				tree.updateValue(arr, n, intArr[1]-1, intArr[2]);
				break;
			case 1:
				System.out.println(tree.getMaxSum(arr, n, intArr[1]-1, intArr[2]-1));
				break;
			}
		}
		
	}

	static class SegmentTree {
		int[] st;

		public SegmentTree(int[] arr, int n) {
			int height = (int) Math.ceil(Math.log(n) / Math.log(2));
			int maxSize = 2 * (int) Math.pow(2, height) - 1;
			st = new int[maxSize];
			constructSegmentTree(arr, 0, n - 1, 0);
		}

		private int constructSegmentTree(int[] arr, int start, int end, int current) {
			if (start == end) {
				st[current] = arr[start];
				return st[current];
			}

			int mid = getMid(start, end);
			int left = constructSegmentTree(arr, start, mid, 2 * current + 1);
			int right = constructSegmentTree(arr, mid + 1, end, 2 * current + 2);
			st[current] = max(left + right, max(left, right));
			return st[current];
		}

		private int getMaxSum(int[] arr, int n, int begin, int stop) {
			return getMaxSumUtil(arr, 0, n - 1, begin, stop, 0);
		}

		private int getMaxSumUtil(int[] arr, int start, int end, int begin, int stop, int current) {
			if (begin <= start && stop >= end) {
				return st[current];
			}

			if (begin > end || stop < start) {
				return Integer.MIN_VALUE;
			}

			int mid = getMid(start, end);
			int left = getMaxSumUtil(arr, start, mid, begin, stop, 2 * current + 1);
			int right = getMaxSumUtil(arr, mid + 1, end, begin, stop, 2 * current + 2);
			return max(add(left,right), max(left, right));
		}

		private int add(int left, int right) {
			return (left==Integer.MIN_VALUE || right==Integer.MIN_VALUE)?Integer.MIN_VALUE:left+right;
		}

		private void updateValue(int[] arr, int n, int i, int newVal) {
			if (i < 0 || i > n - 1) {
				return;
			}

			arr[i] = newVal;
			updateValueUtil(arr, 0, n - 1, i, 0);
		}

		private void updateValueUtil(int[] arr, int start, int end, int index, int current) {
			if (index < start || index > end) {
				return;
			}
			if (start == end) {
				st[current] = arr[index];
				return;
			}
			int mid = getMid(start, end);
			updateValueUtil(arr, start, mid, index, 2 * current + 1);
			updateValueUtil(arr, mid + 1, end, index, 2 * current + 2);
			st[current] = max(max(st[2 * current + 1], st[2 * current + 2]), st[2 * current + 1] + st[2 * current + 2]);
		}

		private int max(int left, int right) {
			return left > right ? left : right;
		}

		private int getMid(int start, int end) {
			return start + (end - start) / 2;
		}
	}

}
