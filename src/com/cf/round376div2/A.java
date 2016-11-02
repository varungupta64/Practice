package com.cf.round376div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = bf.readLine().trim().toCharArray();
		char pos = 'a';
		long rotations = 0;

		for (char c : arr) {
			rotations += Integer.min(Math.abs((int)(c - pos)), Math.abs(26 - Math.abs((int)(c - pos))));
			pos = c;
		}

		System.out.println(rotations);
	}
}
