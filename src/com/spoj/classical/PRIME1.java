package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRIME1 {

	static int max = 1000000000;//1000000000;
	static int sqrtMax = (int) max/2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long start = System.currentTimeMillis();
		
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m;
		List<Integer> primes = new ArrayList<Integer>();
		Integer[] arr;

		initialize(primes);

		segmentedSieve(primes, sqrtMax, 2 * sqrtMax, 1);

		arr = primes.toArray(new Integer[primes.size()]);
		int size = primes.size();
		int index1, index2;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			index1 = binarySearchLower(0, size - 1, arr, n, size - 1);
			index2 = binarySearchUpper(0, size - 1, arr, m, size - 1);

			for (int p = index1; p <= index2; p++) {
				bw.write(arr[p] + "");
				bw.newLine();
			}

			bw.newLine();
		}

		long total = (System.currentTimeMillis() - start)/1000;
		System.out.println(total);
		bw.write("total : "+total);
		
		bw.flush();
		bw.close();
		bf.close();
	}

	// correct binary search
	private static int binarySearchLower(int start, int end, Integer[] arr, int ele, int size) {
		int mid = start + (end - start) / 2;
		if (arr[mid] == ele || mid == 0 || (arr[mid] > ele && arr[mid - 1] < ele)) {
			return mid;
		} else if (ele < arr[mid]) {
			end = mid;
		} else {
			start = mid + 1;
		}
		return binarySearchLower(start, end, arr, ele, size);
	}

	// correct binary search
	private static int binarySearchUpper(int start, int end, Integer[] arr, int ele, int size) {
		int mid = start + (end - start) / 2;
		if (arr[mid] == ele || mid == size || (arr[mid] < ele && arr[mid + 1] > ele)) {
			return mid;
		} else if (ele < arr[mid]) {
			end = mid;
		} else {
			start = mid + 1;
		}
		return binarySearchUpper(start, end, arr, ele, size);
	}

	private static void initialize(List<Integer> primes) {
		int j;
		boolean[] isPrime = new boolean[sqrtMax + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		// removing all even numbers
		int l = 2;
		j = 2;
		while (l * j <= sqrtMax) {
			isPrime[l * j] = false;
			j++;
		}

		// segmented sieve
		// only odd numbers remain
		for (int i = 3; i * i <= sqrtMax; i = i + 2) {
			if (isPrime[i]) {
				j = 2;
				while (i * j <= sqrtMax) {
					isPrime[i * j] = false;
					j++;
				}
			}
		}

		for (int i = 0; i <= sqrtMax; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}

	public static void segmentedSieve(List<Integer> primes, int low, int high, int count) {
		if (high > max) {
			return;
		} else {
			boolean[] isPrime = new boolean[sqrtMax + 1];
			Arrays.fill(isPrime, true);
			int j;
			for (int i = 0; i < primes.size(); i++) {
				j = (low + 1) / primes.get(i);
				while (primes.get(i) * j <= high) {
					if ((primes.get(i) * j) - low < 0) {
						j++;
						continue;
					}

					isPrime[(primes.get(i) * j) - low] = false;
					j++;
				}
			}

			for (int i = low + 1; i * i <= high; i = i + 2) {
				if (isPrime[i - low]) {
					j = 2;
					while (i * j <= high) {
						isPrime[i * j - low] = false;
						j++;
					}
				}
			}

			for (int i = low + 1; i <= high; i++) {
				if (isPrime[i - low]) {
					primes.add(i);
				}
			}

		}
		segmentedSieve(primes, (count + 1) * sqrtMax, (count + 2) * sqrtMax, count + 1);
	}
}
