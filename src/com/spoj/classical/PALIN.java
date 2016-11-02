package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class PALIN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		char[] k;
		String input;
		boolean isGreater;
		int len, mid;
		boolean isAllNine;
		BigInteger one = new BigInteger("1");

		for (int i = 0; i < t; i++) {

			isGreater = false;
			isAllNine = true;
			input = bf.readLine().trim();
			k = input.toCharArray();
			len = k.length;
			mid = k.length / 2;

			if (len == 1) {
				bw.write("11");
				bw.newLine();
				continue;
			}

			if (k.length % 2 == 0) {
				mid = mid - 1;
			}

			for (int j = 0; j < len; j++) {
				if (k[j] == '9') {
					// do nothing
				} else {
					isAllNine = false;
					break;
				}
			}

			if (isAllNine) {
				BigInteger num = new BigInteger(input);
				num = num.add(one);
				k = num.toString().toCharArray();
				len = k.length;
				mid = k.length / 2;

				if (k.length % 2 == 0) {
					mid = mid - 1;
				}
			}

			for (int j = 0; j <= mid; j++) {
				if (j == mid) {

					if (isGreater) {

						if (k[j] == k[len - j - 1]) {
							// do nothing
						} else if(k[len - j - 1] > k[j]){
							k[j] = k[len - j - 1];
						}else{
							k[len - j - 1] = k[j];
						}

					} else {

						if (k[j] == '9') {
							int l = j;
							while (k[l] == '9') {
								k[l] = '0';
								k[len - l - 1] = k[l];
								l--;
							}
							k[l] = (char) (k[l] + 1);
							k[len - l - 1] = k[l];

						} else {
							
							if (k[j] > k[len - j - 1]) {
								k[len - j - 1] = k[j];
							} else {
								k[j] = (char) (k[j] + 1);
								k[len - j - 1] = k[j];
							}							
						}

					}

				} else if (k[j] == k[len - j - 1]) {
					// do nothing
				} else {

					if (k[j] > k[len - j - 1]) {
						isGreater = true;
					} else if (k[j] < k[len - j - 1]) {
						isGreater = false;
					}

					k[len - j - 1] = k[j];

				}
			}

			bw.write(k);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
