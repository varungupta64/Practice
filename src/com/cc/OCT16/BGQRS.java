package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BGQRS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m;
		int[] arr;
		SegmentTree_BGQRS segTree;
		BigInteger ans;
		int l, r, x;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			input = bf.readLine().trim().split(" ");
			arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}
			segTree = new SegmentTree_BGQRS(n, arr);

			ans = new BigInteger("0");
			for (int j = 0; j < m; j++) {
				input = bf.readLine().trim().split(" ");
				switch (Integer.parseInt(input[0])) {
				case 1:
					l = Integer.parseInt(input[1]);
					r = Integer.parseInt(input[2]);
					x = Integer.parseInt(input[3]);
					segTree.updateFirst(l - 1, r - 1, x);
					break;
				case 2:
					l = Integer.parseInt(input[1]);
					r = Integer.parseInt(input[2]);
					x = Integer.parseInt(input[3]);
					segTree.updateSecond(l - 1, r - 1, x);
					break;
				case 3:
					l = Integer.parseInt(input[1]);
					r = Integer.parseInt(input[2]);
					ans = ans.add(segTree.getProduct(l - 1, r - 1));
					break;
				}
			}

			bw.write("" + ans.toString());
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}

class SegmentTree_BGQRS {
	Number_BGQRS[] st;
	int n;

	static BigInteger zero = new BigInteger("0");
	static BigInteger one = new BigInteger("1");
	static BigInteger ten = new BigInteger("10");

	public SegmentTree_BGQRS(int n, int[] arr) {
		this.n = n;
		int x = (int) Math.ceil(Math.log(n) / Math.log(2));
		int max = 2 * (int) Math.pow(2, x) - 1;
		st = new Number_BGQRS[max];

		for (int i = 0; i < max; i++) {
			st[i] = new Number_BGQRS(0, 0);
		}

		constructSegmentTreeUtil(arr, 0, n - 1, 0);
	}

	public void updateFirst(int left, int right, int x) {
		updateFirstUtil(left, right, 0, n - 1, 0, x);
	}

	private void updateFirstUtil(int left, int right, int start, int end, int current, int x) {
		if (left > end || right < start) {
			return;
		}

		if (start == end) {
			st[current] = st[current].multiply(new Number_BGQRS(x, 0));
			return;
		}

		int mid = getMid(start, end);
		updateFirstUtil(left, right, start, mid, 2 * current + 1, x);
		updateFirstUtil(left, right, mid + 1, end, 2 * current + 2, x);

		st[current] = st[2 * current + 1].multiply(st[2 * current + 2]);

	}

	public void updateSecond(int left, int right, int y) {
		updateSecondUtil(left, right, 0, n - 1, 0, y);
	}

	private void updateSecondUtil(int left, int right, int start, int end, int current, int y) {
		if (left > end || right < start) {
			return;
		}

		if (start == end) {
			st[current] = new Number_BGQRS((start - left + 1) * y, 0);
			return;
		}

		int mid = getMid(start, end);
		updateSecondUtil(left, right, start, mid, 2 * current + 1, y);
		updateSecondUtil(left, right, mid + 1, end, 2 * current + 2, y);

		st[current] = st[2 * current + 1].multiply(st[2 * current + 2]);

	}

	public BigInteger getProduct(int left, int right) {
		return getProductUtil(left, right, 0, n - 1, 0).zeroes;
	}

	private Number_BGQRS getProductUtil(int left, int right, int start, int end, int current) {
		if (right < start || left > end) {
			return new Number_BGQRS(1, 0);
		}

		if (left <= start && right >= end) {
			return st[current];
		}

		int mid = getMid(start, end);
		return getProductUtil(left, right, start, mid, 2 * current + 1)
				.multiply(getProductUtil(left, right, mid + 1, end, 2 * current + 2));
	}

	private Number_BGQRS constructSegmentTreeUtil(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current].value = new BigInteger(String.valueOf(arr[start]));
			while (st[current].value.compareTo(zero) > 0 && st[current].value.mod(ten).equals(zero)) {
				st[current].zeroes = st[current].zeroes.add(one);
				st[current].value = st[current].value.divide(ten);
			}
			return st[current];
		}

		int mid = getMid(start, end);
		st[current] = constructSegmentTreeUtil(arr, start, mid, 2 * current + 1)
				.multiply(constructSegmentTreeUtil(arr, mid + 1, end, 2 * current + 2));
		return st[current];
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}
}

class Number_BGQRS {
	BigInteger value;
	BigInteger zeroes;

	static BigInteger zero = new BigInteger("0");
	static BigInteger one = new BigInteger("1");
	static BigInteger ten = new BigInteger("10");

	public Number_BGQRS(int value, int zeroes) {
		this.value = new BigInteger(String.valueOf(value));
		this.zeroes = new BigInteger(String.valueOf(zeroes));
	}

	public Number_BGQRS multiply(Number_BGQRS num1) {
		Number_BGQRS num = new Number_BGQRS(0, 0);
		num.value = this.value.multiply(num1.value);
		num.zeroes = this.zeroes.add(num1.zeroes);
		while (num.value.compareTo(zero) > 0 && num.value.mod(ten).equals(zero)) {
			num.zeroes = num.zeroes.add(one);
			num.value = num.value.divide(ten);
		}
		return num;
	}

	@Override
	public String toString() {
		return "[Value:" + this.value + " Zeroes:" + zeroes + "]";
	}
}