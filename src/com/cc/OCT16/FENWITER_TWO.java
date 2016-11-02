package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class FENWITER_TWO {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input;
		int n;
		char[] l1, l2, l3;
		int numOfZero;
		int numOfOne;
		BigInteger num;
		String s = "1001000010000100001001";
		int result;
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger numPlusOne;

		for (long i = 1; i <= 10; i++) {

			s += "0";
			result = 0;
			input = s;
			numOfOne = 0;
			numOfZero = 0;

			s += input;
			num = new BigInteger(s, 2);
			l3 = s.toCharArray();

			while (num.compareTo(zero) >= 0) {
				result++;
				numPlusOne = num.add(one);
				num = num.and(numPlusOne).subtract(one);
			}

			for (int j = l3.length - 1; j >= 0; j--) {
				if (l3[j] == '0') {
					numOfZero++;
				}

				if (numOfZero > 0 && l3[j] == '1') {
					numOfOne++;
				}
			}

			// to include one of Tl
			numOfOne++;

			if (result != numOfOne || s.length() >= 60) {
				bw.write("BigInteger with length "+s.length()+" : " + result);
				bw.newLine();

				bw.write("" + numOfOne);
				bw.newLine();
			}
		}

		bw.newLine();
		bw.flush();
		bw.close();
		bf.close();

	}
}
