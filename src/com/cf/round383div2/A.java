package com.cf.round383div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		if (n == 0) {
			System.out.println("1");
		} else {
			int i = n % 4;
			switch (i) {
			case 0:
				System.out.println("6");
				break;
			case 1:
				System.out.println("8");
				break;
			case 2:
				System.out.println("4");
				break;
			case 3:
				System.out.println("2");
				break;
			}
		}
	}
}
