package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PRIME1_Naive {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		List<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		primeList.add(3);
		for (int i = 0; i < t; i++) {
			String[] input = bf.readLine().trim().split(" ");
			int m = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			for (int j = 5; j <= m; j++) {
				isPrime(j, primeList);
			}
			for (int j = m; j <= n; j++) {
				if (isPrime(j, primeList)) {
					System.out.println(j);
				}
			}
			System.out.println();
		}
	}

	private static boolean isPrime(int j, List<Integer> primeList) {
		if (j == 1) {
			return false;
		}
		
		if (j == 2 || j == 3) {
			return true;
		}

		int n = (int) Math.sqrt(j);
		boolean isPrime = true;
		for (int i = 0; i <= primeList.size() - 1; i++) {
			if (j % primeList.get(i) == 0) {
				isPrime = false;
				break;
			}
			
			if(primeList.get(i)>=n){
				break;
			}
		}

		if (isPrime) {
			primeList.add(j);
		}
		return isPrime;
	}

}
