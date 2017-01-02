package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PIGBANK_M {
	static final int max = 100000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final String staticText = "The minimum amount of money in the piggy-bank is ";
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int e, f, n;
		int[] p;
		int[] w;
		int[][] memo;
		int result;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			e = Integer.parseInt(input[0]);
			f = Integer.parseInt(input[1]);
			n = Integer.parseInt(bf.readLine().trim());
			p = new int[n];
			w = new int[n];
			memo = new int[n][f - e + 1];
			for (int[] i : memo) {
				Arrays.fill(i, -2);
			}
			for (int i = 0; i < n; i++) {
				input = bf.readLine().trim().split(" ");
				p[i] = Integer.parseInt(input[0]);
				w[i] = Integer.parseInt(input[1]);
			}
			result = minMoney(f - e, p, w, 0, n - 1, memo);
			if (result == max) {
				bw.write("This is impossible.");
			} else {
				bw.write(staticText + result + ".");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int minMoney(int weight, int[] p, int[] w, int current, int end, int[][] memo) {
		if (memo[current][weight] != -2) {
			return memo[current][weight];
		}
		if (weight == 0) {
			memo[current][weight] = 0;
			return 0;
		}
		if(weight<0){
			memo[current][weight] = max;
			return max;
		}
		if (current < end && memo[current + 1][weight] == -2) {
			memo[current + 1][weight] = minMoney(weight - w[current], p, w, current+1, end, memo);
			if(memo[current + 1][weight] != max){
				memo[current + 1][weight] += p[current];
			}
		}
		if(memo[current][weight] == -2){
			memo[current][weight] = 
		}
	}
}