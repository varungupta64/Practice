package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PERMUT2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		String[] input;
		int arr[];
		int pos[];
		boolean isAmbiguous;

		while ((n = Integer.parseInt(bf.readLine().trim())) != 0) {
			input = bf.readLine().trim().split(" ");
			arr = new int[n + 1];
			isAmbiguous = true;

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(input[i - 1]);
			}

			for (int i = 1; i <= n; i++) {
				if (i == arr[arr[i]]) {

				} else {
					isAmbiguous = false;
					break;
				}
			}

			if (isAmbiguous) {
				bw.write("ambiguous");
			} else {
				bw.write("not ambiguous");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
