package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class KTHMAX {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		Integer[] arr;
		int p;
		int j;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			input = bf.readLine().trim().split(" ");
			arr = new Integer[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			Arrays.sort(arr, Collections.reverseOrder());
			for (int i = 0; i < m; i++) {
				p = Integer.parseInt(bf.readLine().trim());
				j = 0;
				while ((p=(p - n - j)) > 0) {
					j++;
				}
				bw.write(""+arr[j]);
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
