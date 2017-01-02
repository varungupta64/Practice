package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ALEXROSE {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, k;
		long[] arr;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			input = bf.readLine().trim().split(" ");
			arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(input[i]);
			}
			Arrays.sort(arr);
			List<Integer> count = count(arr, n);
			int result = 0;
			
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static List<Integer> count(long[] arr, int n) {
		List<Integer> list = new ArrayList<>(n);
		int j = 0;
		int count;
		for (int i = 0; i < n; i++) {
			j = i + 1;
			count = 1;
			while (arr[i] == arr[j]) {
				count++;
			}
			list.add(count);
			i = j - 1;
		}
		return list;
	}
}
