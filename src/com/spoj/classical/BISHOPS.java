package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BISHOPS {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		BigInteger n;
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger result;
		while ((input = bf.readLine()) != null && !input.equals("")) {
			n = new BigInteger(input.trim());
			if (n.compareTo(one) == 0) {
				bw.write("1");
			} else {
				result = n.add(n.subtract(two));
				bw.write(result.toString());
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
