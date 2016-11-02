package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PythagoreanTriples {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(bf.readLine().trim());
		boolean numPresent = false;
		BigInteger a,b,temp;

		while (!numPresent) {

			for (long i = 1; i <= 1e18; i++) {
				b = BigInteger.valueOf(i);
				
				temp = n.pow(2).add(b.pow(2)); 
				temp.shiftRight(1);
				
				System.out.println(temp);
			}
		}

		if (numPresent) {

		} else {
			System.out.println(-1);
		}
	}

}
