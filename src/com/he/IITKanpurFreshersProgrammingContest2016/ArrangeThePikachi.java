package com.he.IITKanpurFreshersProgrammingContest2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ArrangeThePikachi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		int[] arr;
		String[] input;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			Arrays.sort(arr);

			for (int j = 0; j < n; j++) {
				bw.write("" + arr[j] + " ");
			}
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
