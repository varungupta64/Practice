package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EIGHTS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		/*
		 * int num; List<Integer> list = new ArrayList<>(); for (int i = 1; i <=
		 * 1000; i++) { num = i * i * i; if (String.valueOf(num).length() > 3 &&
		 * String.valueOf(num).substring(String.valueOf(num).length() -
		 * 3).equals("888")) { list.add(i); } }
		 */

		BigInteger a = new BigInteger("192");
		BigInteger d = new BigInteger("250");
		BigInteger one = new BigInteger("1");

		int t = Integer.parseInt(bf.readLine().trim());
		BigInteger k;
		BigInteger num;

		for (int i = 0; i < t; i++) {

			k = new BigInteger(bf.readLine().trim());
			num = a.add(k.subtract(one).multiply(d));
			bw.write(num.toString());
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
