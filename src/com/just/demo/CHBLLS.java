package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHBLLS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1");
		System.out.println("3 1 1 2");
		System.out.println("3 3 3 4");
		int diff = Integer.parseInt(bf.readLine());
		int result = 5;
		switch (diff) {
		case 1:
			result = 2;
			break;
		case 2:
			result = 1;
		case -1:
			result = 4;
			break;
		case -2:
			result = 3;
			break;
		}
		System.out.println("2");
		System.out.println(result);
	}
}
