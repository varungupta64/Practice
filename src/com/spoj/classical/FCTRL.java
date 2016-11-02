package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FCTRL {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine().trim());
		int num;

		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(bf.readLine().trim());
			bw.write("" + countNumOfFive(num));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static int countNumOfFive(int num) {
		int count = 0;
		int div = 5;

		while (div <= num) {
			count += num / div;
			div *= 5;
		}

		return count;
	}

}
