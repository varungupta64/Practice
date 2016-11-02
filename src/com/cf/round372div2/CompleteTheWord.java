package com.cf.round372div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompleteTheWord {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine().trim();
		char[] arr = input.toCharArray();
		int[] unique = new int[256];
		Arrays.fill(unique, -1);
		int wildcards = 0;
		int uniqueChar = 0;
		boolean isPossible = true;
		int j = 0;
		int k = 25;

		if (arr.length < 26) {
			isPossible = false;
			System.out.println("-1");
		} else {

			for (int i = j; i <= k; i++) {
				if (arr[i] == '?') {
					wildcards++;
				} else if (unique[arr[i]] == -1) {
					unique[arr[i]] = i;
					uniqueChar++;
				} else {
					wildcards = 0;
					uniqueChar = 0;
					j = unique[arr[i]];
					i = j;
					k = j + 26;

					if (k > arr.length) {
						isPossible = false;
						System.out.println(-1);
						break;
					} else {

						for (int l = 0; l < 256; l++) {
							unique[l] = -1;
						}

					}
				}
			}

		}

		if (isPossible) {

			for (char i = 'A'; i <= 'Z'; i++) {
				if (unique[i] == -1) {
					for (int l = j; l <= k; l++) {
						if (arr[l] == '?') {
							arr[l] = i;
							break;
						}
					}
				}
			}

			for (int l = 0; l < input.length(); l++) {
				if (arr[l] == '?') {
					arr[l] = 'A';
				}
			}

			System.out.println(String.valueOf(arr));

		}
	}

}
