package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SAMER08F {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num, result;

		while ((num = Integer.parseInt(bf.readLine().trim())) != 0) {

			result = (num * (num + 1) * (2 * num + 1)) / 6;
			bw.write(result + "");
			bw.newLine();

		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
