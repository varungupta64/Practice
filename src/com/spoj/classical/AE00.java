package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AE00 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		int result = n;
		int count = 2;

		while (count * count <= n) {
			result += n / count - (count - 1);
			count++;
		}

		System.out.println(result);
	}
}
