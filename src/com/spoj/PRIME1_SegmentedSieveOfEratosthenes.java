package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PRIME1_SegmentedSieveOfEratosthenes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			String[] input = bf.readLine().trim().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			segementedSieveOfEratosthenes(start, end);

		}
	}

	private static void segementedSieveOfEratosthenes(int start, int end) {
		int sqr = (int) Math.sqrt(end);

		boolean[] arr = new boolean[sqr + 1];
		int[] primes = new int[sqr + 1];
		int count = 0;

		for (int i = 0; i <= sqr; i++) {
			arr[i] = true;
		}

		arr[0] = false;
		arr[1] = false;

		for (int i = 2; i <= sqr; i++) {
			if (arr[i] = true) {
				primes[count++] = i;
				for (int j = 2 * i; j <= sqr; j += i) {
					arr[j] = false;
				}
			}
		}

		int diff = end - start + 1;
		arr = new boolean[diff];

		for (int i = 0; i <= diff - 1; i++) {
			arr[i] = true;
		}
		
		if(start == 1){
			arr[0] = false;
		}

		for (int i = 0; i < count; i++) {
			int beg = start / primes[i] * primes[i];
			while (beg <= end) {
				if (beg >= start && beg != primes[i]) {
					arr[beg - start] = false;
				}
				beg += primes[i];
			}
		}

		// print array
		for (int i = 0; i < diff; i++) {
			if (arr[i] == true) {
				System.out.println(start + i);
			}
		}
		System.out.println();
	}

}
