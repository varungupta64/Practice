package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EGYPIZZA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		int[] count = new int[3];
		String input;
		int minPizza = 0;
		while (n-- > 0) {
			input = bf.readLine().trim();
			count[getKey(input)]++;
		}
		minPizza += Integer.min(count[0], count[2]);
		count[0] -= minPizza;
		count[2] -= minPizza;
		minPizza += count[1] / 2 + count[0] / 4;
		count[0] %= 4;
		count[1] %= 2;

		count[1] += count[0] / 2;
		count[0] %= 2;

		minPizza += count[1] / 2;
		count[1] %= 2;

		minPizza += Integer.min(count[0], count[1]);
		int min = Integer.min(count[0], count[1]);
		count[0] -= min;
		count[1] -= min;
		
		for(int i=0;i<=2;i++){
			minPizza += count[i];
		}
		
		System.out.println(1+minPizza);
	}

	private static int getKey(String s) {
		int n = -1;
		switch (s) {
		case "1/4":
			n = 0;
			break;
		case "1/2":
			n = 1;
			break;
		case "3/4":
			n = 2;
			break;
		}
		return n;
	}
}
