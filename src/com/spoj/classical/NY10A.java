package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NY10A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		char[] input;
		int[] count;

		for (int i = 0; i < t; i++) {

			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().toCharArray();
			count = new int[8];

			for (int j = 0; j < 40; j++) {
				if (input[j] == 'H') {
					input[j] = '1';
				} else {
					input[j] = '0';
				}
			}

			for (int j = 0; j < 38; j++) {
				count[Integer.parseInt("" + input[j] + input[j + 1] + input[j + 2] + "", 2)]++;
			}
			
			bw.write(n+" ");
			for(int j=0;j<=7;j++){
				bw.write(count[j]+" ");
			}
			bw.newLine();

		}
		
		bw.flush();
		bw.close();
		bf.close();
	}
}
