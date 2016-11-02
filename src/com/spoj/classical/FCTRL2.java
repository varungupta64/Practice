package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class FCTRL2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int num;
		int max = 100;

		BigInteger[] fact = new BigInteger[max + 1];
		fact[0] = new BigInteger("1");

		// pre-compute
		for (int i = 1; i <= max; i++) {
			fact[i] = new BigInteger("" + i);
		}

		for (int i = 1; i <= max; i++) {
			fact[i] = fact[i].multiply(fact[i - 1]);
		}

		for (int i = 0; i < t; i++) {
			num = Integer.parseInt(bf.readLine().trim());
			bw.write("" + fact[num].toString());
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
