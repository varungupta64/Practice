package com.codechef.JulyCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CHEFLKJ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input = new StringTokenizer(br.readLine().trim(), " ");
		int n = Integer.parseInt(input.nextToken());
		int q = Integer.parseInt(input.nextToken());

		input = new StringTokenizer(br.readLine().trim(), " ");
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input.nextToken());
		}

		String[] query;
		for (int i = 0; i < q; i++) {
			query = br.readLine().trim().split(" ");
			switch (query[0]) {
			case "1":
				arr[Integer.parseInt(query[1])] = Integer.parseInt(query[2]);
				break;
			case "2":
				sort(arr, Integer.parseInt(query[1]), Integer.parseInt(query[2]));
				break;
			}
		}

		br.close();
	}

	private static void sort(int[] arr, int l, int r) {
		int length = r + 1 - l;
		int[] newArr = new int[length];

		for (int i = 0; i < length; i++) {
			newArr[i] = arr[l + i];
		}

		Arrays.sort(newArr);
		int mid = length / 2;
		boolean isOdd = length%2==0?false:true;

		for (int i = 0; i < mid; i++) {
			if (newArr[i] == newArr[mid + i]) {
				System.out.println("Yes");
				return;
			}
		}
		
		if (isOdd) {
			if (newArr[mid] == newArr[length-1]) {
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
