package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BIPIN3Clean {
	static BigInteger ONE = new BigInteger("1");

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(bf.readLine());
			for (int i = 0; i < t; i++) {
				String[] s = bf.readLine().split(" ");
				int n = Integer.parseInt(s[0]);
				BigInteger kb = new BigInteger(s[1]);
				BigInteger kbo = kb.subtract(ONE);
				BigInteger MODULO = new BigInteger("1000000007");

				BigInteger result = calculatePower(kbo, MODULO, n - 1);
				result = kb.multiply(result).mod(MODULO);
				System.out.println(result);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BigInteger calculatePower(BigInteger num, BigInteger mod, int power) {
		BigInteger result = new BigInteger("1");
		if (power == 0) {
			return ONE;
		} else if (power % 2 == 0) {
			result = calculatePower(num, mod, power / 2);
			result = result.multiply(result);
			if (result.compareTo(mod) == 1) {
				result = result.mod(mod);
			}
			return result;
		} else {
			result = num.multiply(calculatePower(num, mod, power - 1));
			if (result.compareTo(mod) == 1) {
				result = result.mod(mod);
			}
			return result;
		}
	}
}