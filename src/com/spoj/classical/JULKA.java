package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class JULKA {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = 10;
		BigInteger n, m, natalia;
		BigInteger two = new BigInteger("2");

		while (t-- > 0) {

			n = new BigInteger(bf.readLine().trim());
			m = new BigInteger(bf.readLine().trim());
			natalia = n.subtract(m).divide(two);
			n = natalia.add(m);

			bw.write(n.toString());
			bw.newLine();
			bw.write(natalia.toString());
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
