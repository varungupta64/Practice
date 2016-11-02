package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class CANDY3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		BigInteger sum;

		for (int i = 0; i < t; i++) {

			bf.readLine();
			sum = new BigInteger("0");
			n = Integer.parseInt(bf.readLine().trim());						
			
			for (int j = 0; j < n; j++) {
				sum = sum.add(new BigInteger(bf.readLine().trim()));
			}
			if (sum.mod(new BigInteger(Integer.toString(n))).equals(BigInteger.ZERO)) {
				bw.write("YES");
			} else {
				bw.write("NO");
			}
			bw.newLine();

		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
