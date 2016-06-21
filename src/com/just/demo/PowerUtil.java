package com.just.demo;

import java.math.BigInteger;

public class PowerUtil {
	static BigInteger ONE = new BigInteger("1");
//1000000000
	//1000000007
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		BigInteger b = new BigInteger("1000000000");
		BigInteger mod = new BigInteger("1000000007");
		int n = 1000000000;
		BigInteger result = new BigInteger("1");
		result = calculatePower(b, mod, n);
		System.out.println("Recursive result : " + result);
		System.out.println("Total time = " + (System.currentTimeMillis() - start)/1000);
	}

	public static BigInteger calculatePower(BigInteger num, BigInteger mod, int power) {
		BigInteger result = new BigInteger("1");
		if (power == 0) {
			return ONE;
		} else if (power % 2 == 0) {
			result = calculatePower(num, mod, power / 2);
			if (result.compareTo(mod) == 1) {
				result = result.mod(mod);
				result = result.multiply(result);
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
