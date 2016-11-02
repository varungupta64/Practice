package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GIRLSNBS {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int g, b;
		double cells;
		int ans;

		while (true) {
			input = bf.readLine().trim().split(" ");
			g = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);

			if (g == -1 && b == -1) {
				break;
			}

			cells = Integer.min(g, b) + 1.0;
			ans = (int) Math.ceil(Integer.max(g, b) / cells);
			bw.write(""+ans);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
