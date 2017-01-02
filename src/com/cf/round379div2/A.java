package com.cf.round379div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		char[] arr = bf.readLine().trim().toCharArray();
		int mid;
		int a = 0;

		for (char c : arr) {
			if (c == 'A') {
				a++;
			}
		}

		if (n % 2 == 0) {
			mid = n / 2;
			if (a > mid) {
				System.out.println("Anton");
			} else if (a < mid) {
				System.out.println("Danik");
			} else {
				System.out.println("Friendship");
			}
		} else {
			mid = (n / 2) + 1;
			if (a >= mid) {
				System.out.println("Anton");
			} else {
				System.out.println("Danik");
			}
		}
	}
}
