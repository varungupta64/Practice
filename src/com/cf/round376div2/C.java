package com.cf.round376div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		input = bf.readLine().trim().split(" ");

		int[] color = new int[n + 1];
		int[] count = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			color[i] = Integer.parseInt(input[i - 1]);
			count[color[i]]++;
		}

		int c1, c2;
		int changes = 0;

		for (int i = 0; i < m; i++) {
			input = bf.readLine().trim().split(" ");
			c1 = Integer.parseInt(input[0]);
			c2 = Integer.parseInt(input[1]);
			if (color[c1] == color[c2]) {
				// do nothing
			} else {

				changes++;

				if (count[color[c1]] >= count[color[c2]]) {
					color[c2] = color[c1];
					count[color[c1]]++;
					count[color[c2]]--;
				} else {
					color[c1] = color[c2];
					count[color[c2]]++;
					count[color[c1]]--;
				}

			}

		}
		
		System.out.println(changes);
	}
}
