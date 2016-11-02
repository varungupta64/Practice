package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CRDS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		long level;
		long result;

		for (int i = 0; i < t; i++) {

			level = Long.parseLong(bf.readLine().trim());
			result = (((level * (level + 1) / 2) * 3) - level) % 1000007;
			bw.write(""+result);
			bw.newLine();

		}
		
		bw.flush();
		bw.close();
		bf.close();
	}
}
