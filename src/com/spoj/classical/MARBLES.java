package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class MARBLES {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		long n, k;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			n = Long.parseLong(input[0]);
			k = Long.parseLong(input[1]);

			bw.write("" + combination(n, k));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static BigInteger combination(long n, long k) {
		return prod(n - 1, n - k +1, k - 1);
	}

	private static BigInteger prod(long end, long start, long dend) {
		BigInteger prod = new BigInteger("1");
		for (long i = start; i <= end; i++) {
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		for (long i = 1; i <= dend; i++) {
			prod = prod.divide(BigInteger.valueOf(i));
		}
		return prod;
	}
}
