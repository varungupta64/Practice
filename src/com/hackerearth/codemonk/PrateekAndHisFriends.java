package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrateekAndHisFriends {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] arr;
		int start,n;
		long x, sum;
		boolean isPossible;
		long[] holder;

		for (int i = 0; i < t; i++) {
			sum = 0;
			isPossible = false;
			start = 0;
			arr = bf.readLine().trim().split(" ");
			n = Integer.parseInt(arr[0]);
			x = Long.parseLong(arr[1]);
			holder = new long[n];

			for (int j = 0; j < n; j++) {
				holder[j] = Long.parseLong(bf.readLine().trim());
			}
			
			for (int j = 0; j < n; j++) {
				sum += holder[j];
				if (sum == x) {
					isPossible = true;
					break;
				} else if (sum > x) {

					while (sum > x) {
						sum -= holder[start++];
					}
					
					if (sum == x) {
						isPossible = true;
						break;
					}
				}
			}

			if (isPossible) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}

}
