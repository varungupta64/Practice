package com.codechef.AprilLunchTime16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KSUM {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		long[] arr = new long[n];
		String[] input1 = bf.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(input1[i]);
		}

		long[][] interArr = new long[n][n];

		List<Long> list = new ArrayList<Long>((n * (n + 1)) / 2);

		for (int i = 0; i < n; i++) {
			interArr[0][i] = arr[i];
			list.add(arr[i]);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				interArr[i][j] = interArr[i - 1][j] + interArr[0][i+j];
				list.add(interArr[i][j]);
			}
		}

		Collections.sort(list, Collections.reverseOrder());
		
		for(int i=0;i<k;i++){
			System.out.print(list.get(i)+" ");
		}
	}

}
