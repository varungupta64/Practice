package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ACPC10A {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int a1, a2, a3;
		int d, num;

		while (true) {
			input = bf.readLine().trim().split(" ");
			a1 = Integer.parseInt(input[0]);
			a2 = Integer.parseInt(input[1]);
			a3 = Integer.parseInt(input[2]);

			if (a1 == 0 && a2 == 0 && a3 == 0) {
				break;
			} else {

				if (a2 - a1 == a3 - a2) {
					d = a2 - a1;
					num = a3 + d;
					
					bw.write("AP ");					
				} else {
					d = a2/a1;
					num = a3*d;
					
					bw.write("GP ");
				}
				bw.write("" + num);
				bw.newLine();

			}

		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
