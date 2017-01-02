package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class KTHMAX_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		int[] arr;
		Integer[] arrCopy;
		Integer[] list;
		int[] sizeList;
		int p;
		int size;
		int ele;
		int index;
		int count;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			input = bf.readLine().trim().split(" ");
			arr = new int[n];
			arrCopy = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
				arrCopy[i] = Integer.parseInt(input[i]);
			}

			Arrays.sort(arrCopy, Collections.reverseOrder());
			list = removeDuplicates(arrCopy);
			sizeList = new int[list.length];

			SegmentTree_KTHMAX_1 segTree = new SegmentTree_KTHMAX_1(arr, n);
			size = n;
			for (int i = 0; i < n; i++) {
				for (int j = 0; (j + size - 1) < n; j++) {
					ele = segTree.query(j, j + size - 1);
					index = binarySearch(arrCopy, 0, arrCopy.length - 1, ele);
					sizeList[index]++;
				}
				size--;
			}

			for (int i = 0; i < m; i++) {
				p = Integer.parseInt(bf.readLine().trim());
				count = 0;
				while ((p = p - sizeList[count]) > 0) {
					count++;
				}
				bw.write("" + arrCopy[count]);
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int binarySearch(Integer[] arrCopy, int start, int end, int ele) {
		int mid = start + (end - start) / 2;
		while (start <= end) {
			if (arrCopy[mid] == ele) {
				return mid;
			} else if (arrCopy[mid] > ele) {
				start = mid + 1;
			} else {
				end = mid;
			}
			mid = start + (end - start) / 2;
		}
		return -1;
	}

	private static Integer[] removeDuplicates(Integer[] A) {
		if (A.length < 2)
			return A;
		int j = 0;
		int i = 1;
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
		Integer[] B = Arrays.copyOf(A, j + 1);
		return B;
	}
}

class SegmentTree_KTHMAX_1 {
	int[] st;
	int n;

	public SegmentTree_KTHMAX_1(int[] arr, int n) {
		this.n = n;
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int max = 2 * (int) Math.pow(2, h) - 1;
		st = new int[max];
		constructSegTreeUtil(arr, 0, n - 1, 0);
	}

	public int query(int l, int r) {
		return queryUtil(0, n - 1, l, r, 0);
	}

	private int queryUtil(int start, int end, int l, int r, int current) {
		if (l > end || r < start) {
			return 0;
		}

		if (l <= start && r >= end) {
			return st[current];
		}

		int mid = getMid(start, end);
		return Integer.max(queryUtil(start, mid, l, r, 2 * current + 1),
				queryUtil(mid + 1, end, l, r, 2 * current + 2));
	}

	private int constructSegTreeUtil(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = arr[start];
			return st[current];
		}
		int mid = getMid(start, end);
		st[current] = Integer.max(constructSegTreeUtil(arr, start, mid, 2 * current + 1),
				constructSegTreeUtil(arr, mid + 1, end, 2 * current + 2));
		return st[current];
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

}
