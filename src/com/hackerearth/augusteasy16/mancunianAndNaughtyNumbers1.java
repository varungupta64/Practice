package com.hackerearth.augusteasy16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mancunianAndNaughtyNumbers1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(bf.readLine().trim());
		int maxNum = 100000;

		int[] table = new int[maxNum + 1];
		table[1] = 1;
		int index;

		for (int i = 2; i <= maxNum; i++) {
			if (table[i] != 0) {
				continue;
			}
			index = i;
			while (index <= maxNum) {
				
			}
		}

		for (int i = 0; i < q; i++) {

		}
	}

}
