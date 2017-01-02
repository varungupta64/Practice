package com.cc.NOV16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CPERM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 1000;
		int modulo = 1000000007;
		long[] fact = new long[max + 1];
		fact[0] = 1;
		fact[1] = 1;

		calculateFactorial(fact);

		int t = Integer.parseInt(bf.readLine().trim());	
		int n;
		int count;
		int result;
		long num;
		int nn;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());

			if (n > 1000) {
				bw.write("" + 0);
				bw.newLine();
			} else {
				//

				result = 0;
				count = n - 2;
				num = fact[n];
				nn = n;

				while (count > 0) {
					num = ((num / nn) * count)%1000000007;
					result += num;
					count--;
					nn--;
				}

				bw.write("" + result % modulo);
				bw.newLine();

				//
			}

		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void calculateFactorial(long[] fact) {
		for (int i = 2; i <= 1000; i++) {
			fact[i] = (i * fact[i - 1]) % 1000000007;
		}
	}

}
