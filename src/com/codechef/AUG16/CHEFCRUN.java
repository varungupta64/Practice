package com.codechef.AUG16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CHEFCRUN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int[] arr;
		int n, start, end, beforeStart, afterEnd, between, around, min;

		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			between = 0;
			beforeStart = 0;
			afterEnd = 0;
			around = 0;
			min = 0;
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(input[j - 1]);
			}
			input = bf.readLine().trim().split(" ");
			start = Integer.parseInt(input[0]);
			end = Integer.parseInt(input[1]);

			for (int j = start; j < end; j++) {
				between += arr[j];
			}

			for (int j = 1; j < start; j++) {
				beforeStart += arr[j];
			}

			for (int j = end; j <= n; j++) {
				afterEnd += arr[j];
			}

			around = afterEnd + beforeStart;

			if (between > around) {

				min = around;

				for (int j = start; j < end - 1; j++) {
					around += 2 * arr[j];
					if (around < min) {
						min = around;
					}
				}

			} else if (between < around) {

				min = between;

				for (int j = start - 1; j >= 1; j--) {
					between += 2 * arr[j];
					if (between < min) {
						min = between;
					}
				}

				for (int j = n; j <= end; j--) {
					between += 2 * arr[j];
					if (between < min) {
						min = between;
					}
				}

			} else {

				min = around;

				for (int j = start; j < end - 1; j++) {
					around += 2 * arr[j];
					if (around < min) {
						min = around;
					}
				}

				for (int j = start - 1; j >= 1; j--) {
					between += 2 * arr[j];
					if (between < min) {
						min = between;
					}
				}

				for (int j = n; j <= end; j--) {
					between += 2 * arr[j];
					if (between < min) {
						min = between;
					}
				}

			}

			 bw.write(""+min);
			 bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
