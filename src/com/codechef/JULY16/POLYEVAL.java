package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class POLYEVAL {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BigInteger max = new BigInteger("786433");
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");

		int q = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < q; i++) {
			BigInteger x = new BigInteger(bf.readLine().trim());
			BigInteger num = new BigInteger("1");
			BigInteger result = new BigInteger("0");

			for (int j = 0; j <= n; j++) {
				result = result.add(num.multiply(new BigInteger(input[j]))).mod(max);
				num = num.multiply(x).mod(max); 
			}

			System.out.println(result.mod(max));
		}
	}

}
