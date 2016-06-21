package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());

		int[] fib = new int[n];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i=2;i<n;i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		System.out.println(fib[n-1]);
	}
}
