package com.cf.round384div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		long k = Long.parseLong(input[1]);

		if (k % 2 != 0) {
			System.out.println("1");
		} else {

			for (int i = n + 1; i > 0; i--) {
				if (k % Math.pow(2, i) == 0) {
					System.out.println(i+1);
					break;
				}
			}

		}

		bf.close();
	}
}
