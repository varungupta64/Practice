package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class CHEFTWOS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		char[] a, b;
		int n;
		int max = 1000000007;
		StringBuffer s;
		BigInteger num;
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		int goodStrings;
		char[] pos;
		StringBuffer temp;

		for (int i = 0; i < t; i++) {

			goodStrings = 0;

			a = bf.readLine().trim().toCharArray();
			b = bf.readLine().trim().toCharArray();

			n = a.length;
			s = new StringBuffer("");

			for (int j = 0; j < n; j++) {
				s.append("1");
			}

			num = new BigInteger(s.toString(), 2);

			while (num.compareTo(zero) >= 0) {
				temp = new StringBuffer("");

				for (int j = 0; j < (n - num.toString(2).length()); j++) {
					temp.append("0");
				}
				
				temp.append(num.toString(2));
				pos = temp.toString().toCharArray();

				goodStrings += checkIfGoodStrings(a, b, pos, 0, n - 1);
				goodStrings %= max;

				num = num.subtract(one);
			}

			bw.write("" + goodStrings);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}

	private static int checkIfGoodStrings(char[] a, char[] b, char[] pos, int start, int end) {
		if (isGoodString(a, b, pos, start, end) && isGoodString(b, a, pos, start, end)) {
			return 1;
		} else {
			return 0;
		}
	}

	private static boolean isGoodString(char[] a, char[] b, char[] pos, int start, int end) {
		boolean isGoodSrting = true;
		boolean[] aVisited = new boolean[end + 1];
		int forward;
		int backward;

		while (start <= end) {
			if (aVisited[start]) {
				isGoodSrting = false;
				break;
			} else {
				aVisited[start] = true;

				if (start == end) {
					break;
				}
			}

			if (pos[start] == '0') {

				forward = start + Character.getNumericValue(a[start]);
				backward = start - Character.getNumericValue(a[start]);

				if (backward > 0 && !aVisited[backward]) {
					start = backward;
				} else if (forward <= end && !aVisited[forward]) {
					start = forward;
				} else {
					isGoodSrting = false;
					break;
				}

			} else {

				forward = start + Character.getNumericValue(b[start]);
				backward = start - Character.getNumericValue(b[start]);

				if (backward > 0 && !aVisited[backward]) {
					start = backward;
				} else if (forward <= end && !aVisited[forward]) {
					start = forward;
				} else {
					isGoodSrting = false;
					break;
				}

			}
		}

		for (int i = 0; i <= end; i++) {
			if (!aVisited[i]) {
				isGoodSrting = false;
				break;
			}
		}

		return isGoodSrting;
	}
}
