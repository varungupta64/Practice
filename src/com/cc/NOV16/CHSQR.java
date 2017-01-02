package com.cc.NOV16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CHSQR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int k;
		int mid;
		int num;
		for (int i = 0; i < t; i++) {
			k = Integer.parseInt(bf.readLine().trim());
			mid = (k + 1) / 2;

			for (int l = 1; l <= k; l++) {
				for (int m = 1; m <= k; m++) {
					num = (mid + l + m - 1) % k;
					if (num == 0) {
						num = k;
					}
					bw.write(num + " ");
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
