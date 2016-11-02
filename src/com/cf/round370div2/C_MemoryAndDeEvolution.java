package com.cf.round370div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C_MemoryAndDeEvolution {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		int[] arr = { a, a, a };

		int num = 2 * b - 1;
		int count = 0;

		if (b >= num) {
			num = b;
		}

		arr[0] = num;
		count++;
		int intermediate;

		while (!isDone(arr, b)) {
			Arrays.sort(arr);
			intermediate = arr[1] - arr[0] + 1;
			if (intermediate < b) {
				intermediate = b;
			}
			arr[2] = intermediate;
			count++;
		}

		System.out.println(count);

	}

	public static boolean isDone(int[] arr, int b) {
		if (arr[0] == b && arr[1] == b && arr[2] == b) {
			return true;
		}
		return false;
	}
}
