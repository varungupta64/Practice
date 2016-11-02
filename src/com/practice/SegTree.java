package com.practice;

public class SegTree {

	public static void main(String[] args) {
		int[] arr = { 8, 7, 3, 9, 5, 1, 10 };
		int n = arr.length;

		SegmentTree st = new SegmentTree(arr, n);
		System.out.println(st.RMQ(arr, n, 0, n - 1));
		System.out.println(st.RMQ(arr, n, 0, 4));
		System.out.println(st.RMQ(arr, n, 0, 2));
		System.out.println(st.RMQ(arr, n, 2, 4));
		
		st.update(arr, n, 5, 11);
		
		System.out.println(st.RMQ(arr, n, 5, n - 1));
		System.out.println(st.RMQ(arr, n, 6, n - 1));
		System.out.println(st.RMQ(arr, n, 1, 2));
		System.out.println(st.RMQ(arr, n, 3, 6));
	}

	static class SegmentTree {
		int[] st;

		public SegmentTree(int[] arr, int n) {
			int h = (int) Math.ceil((Math.log(n) / Math.log(2)));
			int maxSize = 2 * (int) Math.pow(2, h) - 1;
			st = new int[maxSize];
			constructSegmentTree(arr, 0, n - 1, 0);
		}

		private int constructSegmentTree(int[] arr, int start, int end, int current) {
			if (start == end) {
				st[current] = arr[start];
				return st[current];
			}

			int mid = getMid(start, end);
			st[current] = min(constructSegmentTree(arr, start, mid, 2 * current + 1),
					constructSegmentTree(arr, mid + 1, end, 2 * current + 2));
			return st[current];
		}

		private int RMQ(int[] arr, int n, int start, int end) {
			return RMQUtil(arr, 0, n - 1, start, end, 0);
		}

		private int RMQUtil(int[] arr, int begin, int stop, int start, int end, int current) {
			if (start <= begin && end >= stop) {
				return st[current];
			}

			if (start > stop || end < begin) {
				return Integer.MAX_VALUE;
			}

			int mid = getMid(begin, stop);
			return min(RMQUtil(arr, begin, mid, start, end, 2 * current + 1),
					RMQUtil(arr, mid + 1, stop, start, end, 2 * current + 2));
		}

		private void update(int[] arr, int n, int index, int newVal) {
			arr[index] = newVal;
			updateUtil(arr, 0, n - 1, index, 0);
		}

		private int updateUtil(int[] arr, int start, int end, int index, int current) {
			if (index < start || index > end) {
				return Integer.MAX_VALUE;
			}

			if (start == end) {
				st[current] = arr[start];
				return st[current];
			}

			int mid = getMid(start, end);
			st[current] = min(updateUtil(arr, start, mid, index, 2 * current + 1),
					updateUtil(arr, mid + 1, end, index, 2 * current + 2));
			return st[current];
		}

		private int min(int i, int j) {
			return i < j ? i : j;
		}

		private int getMid(int start, int end) {
			return start + (end - start) / 2;
		}

	}

}
