package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class OFFSIDE {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int a, d;
		int[] b, c;

		while (true) {
			input = bf.readLine().trim().split(" ");
			a = Integer.parseInt(input[0]);
			d = Integer.parseInt(input[1]);

			if (a == 0 && d == 0) {
				break;
			}

			b = new int[a];
			c = new int[d];

			input = bf.readLine().trim().split(" ");
			for (int i = 0; i < a; i++) {
				b[i] = Integer.parseInt(input[i]);
			}

			input = bf.readLine().trim().split(" ");
			for (int i = 0; i < d; i++) {
				c[i] = Integer.parseInt(input[i]);
			}

			Arrays.sort(b);
			Arrays.sort(c);

			if (b[0] < c[1]) {
				bw.write("Y");
			} else {
				bw.write("N");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
