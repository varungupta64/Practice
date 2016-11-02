package com.cf.round367div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HardProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		long max = (long)1e15;;
		String[] straight, reverse;
		String ele;
		int[] cost;
		long[] straightCost, reverseCost;
		straight = bf.readLine().trim().split(" ");
		cost = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(straight[i - 1]);
		}

		straightCost = new long[n + 1];
		reverseCost = new long[n + 1];
		straight = new String[n + 1];
		reverse = new String[n + 1];

		straight[0] = "";
		reverse[0] = "";
		straightCost[0] = 0;
		reverseCost[0] = 0;

		for (int i = 1; i <= n; i++) {
			ele = bf.readLine().trim();
			straight[i] = ele;
			reverse[i] = new StringBuilder(ele).reverse().toString();
		}

		for (int i = 1; i <= n; i++) {
			straightCost[i] = max;
			reverseCost[i] = max;

			if (straight[i].compareTo(straight[i - 1]) >= 0) {
				straightCost[i] = straightCost[i - 1];
			}

			if (straight[i].compareTo(reverse[i-1]) >= 0) {
				straightCost[i] = min(straightCost[i], reverseCost[i - 1]);
			}

			if (reverse[i].compareTo(straight[i - 1]) >= 0) {
				reverseCost[i] = straightCost[i - 1] + cost[i];
			}

			if (reverse[i].compareTo(reverse[i - 1]) >= 0) {
				reverseCost[i] = min(reverseCost[i], reverseCost[i - 1] + cost[i]);
			}
		}

		long c = min(straightCost[n], reverseCost[n]);

		if (c >= max) {
			System.out.println("-1");
		} else {
			System.out.println(c);
		}

	}

	private static long min(long l, long m) {
		return l < m ? l : m;
	}

}
