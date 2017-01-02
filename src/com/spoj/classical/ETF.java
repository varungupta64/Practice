package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ETF {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int[] testCase = new int[t];
		int max = -1;
		for (int i = 0; i < t; i++) {
			testCase[i] = Integer.parseInt(bf.readLine().trim());
			if(testCase[i]>max){
				max = testCase[i];
			}
		}
		int n;
		List<Integer> primeList = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[max + 1];
		boolean[] isVisited = new boolean[max + 1];

		isPrime[0] = false;
		isPrime[1] = false;
		int j;
		int result;
		int num;
		int index;
		for (int i = 2; i <= max; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				isPrime[i] = true;
				primeList.add(i);
				j = 2;
				while (i * j <= max) {
					isVisited[i * j] = true;
					isPrime[i * j] = false;
					j++;
				}
			}
		}

		isVisited = null;

		for (int i = 0; i < t; i++) {
			n = testCase[i];
			if (n == 1) {
				bw.write("1");
			} else if (isPrime[n]) {
				bw.write("" + (n - 1));
			} else {
				result = n;
				index = 0;
				while (index < primeList.size() && (num = primeList.get(index)) <= n) {
					if (n % num == 0) {
						result = (result * (num - 1)) / num;
					}
					index++;
				}

				bw.write(result + "");

			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
