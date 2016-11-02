package com.cf.round370div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C_MemoryAndDeEvolution_ED {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		int[] arr = { b, b, b };

		int num = arr[1] + arr[2] - 1;
		int count = 0;

		if (num >= a) {
			num = a;
		}

		arr[0] = num;
		count++;
		int intermediate;

		while (!isDone(arr, a)) {
			Arrays.sort(arr);
			intermediate = arr[1] + arr[2]-1;
			if (intermediate > a) {
				intermediate = a;
			}
			arr[0] = intermediate;
			count++;
		}

		System.out.println(count);

	}

	public static boolean isDone(int[] arr, int a) {
		if (arr[0] == a && arr[1] == a && arr[2] == a) {
			return true;
		}
		return false;
	}

}
