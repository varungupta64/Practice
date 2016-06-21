package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FibonacciModified {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");

		BigInteger a = new BigInteger(input[0]);
		BigInteger b = new BigInteger(input[1]);
		int n = Integer.parseInt(input[2]);

		BigInteger[] arr = new BigInteger[n];
		arr[0] = a;
		arr[1] = b;

		for (int i = 2; i < n; i++) {
			arr[i] = (arr[i - 1].multiply(arr[i - 1])).add(arr[i - 2]);
		}
		System.out.println(arr[n - 1]);
	}

}
