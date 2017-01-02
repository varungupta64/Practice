package com.cf.round384div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		if (n == 1) {
			System.out.println("-1");
		} else {
			System.out.println(n + " " + (n + 1) + " " + (n * (n + 1)));
		}

		bf.close();
	}
}
