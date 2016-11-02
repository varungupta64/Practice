package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EDIST {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String a, b;

		for (int i = 0; i < t; i++) {

			a = bf.readLine().trim();
			b = bf.readLine().trim();

			minimumOperations(a, b, 0, 0, a.length(), b.length());

		}
	}

	private static int minimumOperations(String a, String b, int index1, int index2, int len1, int len2) {
		if(a.charAt(index1) != ){
			
		}
		return 0;
	}
}
