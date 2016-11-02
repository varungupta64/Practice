package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ADDREV {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n1, n2;
		int sum;
		int reverse;

		for (int i = 0; i < n; i++) {
			input = bf.readLine().trim().split(" ");
			n1 = Integer.parseInt(new StringBuffer(input[0]).reverse().toString());
			n2 = Integer.parseInt(new StringBuffer(input[1]).reverse().toString());

			sum = n1 + n2;

			reverse = Integer.parseInt(new StringBuffer(String.valueOf(sum)).reverse().toString());

			bw.write("" + reverse);
			bw.newLine();

		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
