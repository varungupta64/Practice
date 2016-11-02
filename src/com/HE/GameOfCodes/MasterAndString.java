package com.HE.GameOfCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MasterAndString {
	public static int totalCount = 0;
	public static MyChar[] st;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] input = bf.readLine().trim().toCharArray();
		MyChar[] arr = new MyChar[input.length];

		for (int i = 0; i < input.length; i++) {
			switch (input[i]) {
			case 'A':
				arr[i] = new MyChar(1, 0, 0);
				break;
			case 'B':
				arr[i] = new MyChar(0, 1, 0);
				break;
			case 'C':
				arr[i] = new MyChar(0, 0, 1);
				break;
			}
		}

		int n = input.length;

		initializeSt(n);
		populateSegmentTree(arr, 0, n - 1, 0);
		MyChar m;

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				m = getCount(0, n - 1, i, j, 0);
				if (m.countA == m.countB && m.countA == m.countC && m.countB == m.countC) {
					MasterAndString.totalCount++;
				}
				System.out.print("");
			}
		}

		System.out.println(totalCount);
	}

	private static void initializeSt(int n) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSizeArr = 2 * (1 << h) - 1;
		st = new MyChar[maxSizeArr];
	}

	private static MyChar populateSegmentTree(MyChar[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = arr[start];
			return st[current];
		}
		int mid = getMid(start, end);
		st[current] = new MyChar(populateSegmentTree(arr, start, mid, 2 * current + 1),
				populateSegmentTree(arr, mid + 1, end, 2 * current + 2));
		return st[current];
	}

	private static int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	private static MyChar getCount(int start, int end, int begin, int stop, int current) {
		if (begin <= start && stop >= end) {
			return st[current];
		}

		if (begin > end || stop < start) {
			return null;
		}

		int mid = getMid(start, end);
		return new MyChar(getCount(start, mid, begin, stop, 2 * current + 1),
				getCount(mid + 1, end, begin, stop, 2 * current + 2));
	}

}

class MyChar {
	int countA, countB, countC;

	public MyChar(int a, int b, int c) {
		countA = a;
		countB = b;
		countC = c;

		if (countA == countB && countA == countC && countB == countC) {
			MasterAndString.totalCount++;
		}
	}

	public MyChar(MyChar m1, MyChar m2) {
		if (m1 == null) {
			countA = m2.countA;
			countB = m2.countB;
			countC = m2.countC;
		} else if (m2 == null) {
			countA = m1.countA;
			countB = m1.countB;
			countC = m1.countC;
		} else {
			countA = m1.countA + m2.countA;
			countB = m1.countB + m2.countB;
			countC = m1.countC + m2.countC;
		}		
	}
}