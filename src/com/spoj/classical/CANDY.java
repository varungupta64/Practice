package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CANDY {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int n;
		int num;
		int[] arr;
		int sum;
		int avg;
		int result;
		int count;

		while (true) {
			input = bf.readLine().trim();
			n = Integer.parseInt(input);

			if (n == -1) {
				break;
			} else {
				result = 0;
				sum = 0;
				arr = new int[n + 1];

				for (int i = 1; i <= n; i++) {

					input = bf.readLine().trim();
					num = Integer.parseInt(input);

					sum += num;
					arr[i] = num;

				}

				if (sum % n == 0) {
					avg = sum / n;
					Arrays.sort(arr);

					count = 1;
					while (count <= n && arr[count] <= avg) {
						result += avg - arr[count];
						count++;
					}
					bw.write("" + result);

				} else {
					bw.write("-1");
				}
				bw.newLine();

			}
		}

		bw.flush();
		bw.close();
		bf.close();

	}

}
