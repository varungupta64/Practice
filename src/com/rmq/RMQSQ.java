package com.rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RMQSQ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int k = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;

		int[][] sparseTable = buildSparseTable(arr, n, k);

		//print(sparseTable, n, k);

		int q = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < q; i++) {
			String[] input1 = bf.readLine().trim().split(" ");
			int l = Integer.parseInt(input1[0]);
			int r = Integer.parseInt(input1[1]);
			System.out.println(RMQ(arr, sparseTable, n, k, l, r));
		}

	}

	private static int RMQ(int[] arr, int[][] sparseTable, int n, int k, int l, int r) {
		int num = r - l + 1;
		int pow = (int) Math.floor(Math.log(num) / Math.log(2));
		int remNum = num - (1 << pow);

		if (remNum > 0) {
			return arr[min(arr[sparseTable[l][pow]], arr[sparseTable[l + remNum][pow]], sparseTable[l][pow],
					sparseTable[l + remNum][pow])];
		}
		return arr[sparseTable[l][pow]];
	}

	private static void print(int[][] sparseTable, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(sparseTable[i][j] + " ");
			}
			System.out.println("");
		}

	}

	private static int[][] buildSparseTable(int[] arr, int n, int k) {
		int[][] sparseTable = new int[n][k];

		for (int i = 0; i < n; i++) {
			Arrays.fill(sparseTable[i], -1);
		}

		for (int i = 0; i < n; i++) {
			sparseTable[i][0] = i;
		}

		int size = 0;

		for (int j = 1; j < k; j++) {
			size = 1 << (j - 1);
			for (int i = 0; i <= n - (1 << j); i++) {
				sparseTable[i][j] = min(arr[sparseTable[i][j - 1]], arr[sparseTable[i + size][j - 1]],
						sparseTable[i][j - 1], sparseTable[i + size][j - 1]);
			}
		}

		return sparseTable;
	}

	private static int min(int i, int j, int iIndex, int jIndex) {
		return i < j ? iIndex : jIndex;
	}

}
