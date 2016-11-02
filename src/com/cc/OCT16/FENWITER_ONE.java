package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class FENWITER_ONE {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n;
		char[] l1, l2, l3;
		int numOfZero;
		int numOfOne;
		BigInteger num;
		String s;
		int result;
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger numPlusOne;

		for (int i = 0; i < t; i++) {

			s = "";
			result = 0;
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[3]);
			l1 = input[0].toCharArray();
			l2 = input[1].toCharArray();
			l3 = input[2].toCharArray();
			numOfOne = 0;
			numOfZero = 0;

			s += input[0];
			for (int j = 0; j < n; j++) {
				s += input[1];
			}
			s += input[2];

			num = new BigInteger(s, 2);

			while (num.compareTo(zero) >= 0) {
				result++;
				numPlusOne = num.add(one);
				num = num.and(numPlusOne).subtract(one);
			}

			/*
			 * for (int j = l3.length - 1; j >= 0; j--) { if (l3[j] == '0') {
			 * numOfZero++; }
			 * 
			 * if (numOfZero > 0 && l3[j] == '1') { numOfOne++; } }
			 * 
			 * for (int j = l2.length - 1; j >= 0; j--) { if (l2[j] == '0') {
			 * numOfZero++; }
			 * 
			 * if (numOfZero > 0 && l2[j] == '1') { numOfOne = numOfOne + n; } }
			 * 
			 * for (int j = l1.length - 1; j >= 0; j--) { if (l1[j] == '0') {
			 * numOfZero++; }
			 * 
			 * if (numOfZero > 0 && l1[j] == '1') { numOfOne++; } }
			 * 
			 * // to include one of Tl numOfOne++;
			 */

			bw.write("" + result);
			bw.newLine();

			/*
			 * bw.write("" + numOfOne); bw.newLine();
			 */
		}

		bw.flush();
		bw.close();
		bf.close();

	}
}
