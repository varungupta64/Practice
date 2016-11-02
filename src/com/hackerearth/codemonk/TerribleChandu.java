package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TerribleChandu {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		char[] arr;

		for (int i = 0; i < t; i++) {
			arr = bf.readLine().trim().toCharArray();

			for (int j = arr.length - 1; j >= 0; j--) {
				bw.write(arr[j]);
			}
			bw.newLine();
		}
		bw.flush();
		bf.close();
		bw.close();
	}

}
