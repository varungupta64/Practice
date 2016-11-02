package com.rmq;

public class BinaryIndexedTree {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length;

		int[] bit = constructBinaryIndexedTree(arr, n);
		System.out.println(getSum(bit, 3));
		System.out.println(getSum(bit, 7));
		System.out.println(getSum(bit, 10));
	}

	private static int getSum(int[] bit, int index) {
		int sum = 0;
		
		index = index + 1;

		while (index > 0) {
			sum += bit[index];
			
			index -= index & (~index + 1);
		}
		return sum;
	}

	private static int[] constructBinaryIndexedTree(int[] arr, int n) {
		int[] bit = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			bit[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			updateBIT(bit, n, i, arr[i]);
		}

		return bit;
	}

	private static void updateBIT(int[] bit, int n, int index, int val) {
		index++;

		while (index <= n) {
			bit[index] += val;

			index += index & (~index + 1);
		}
	}

}
