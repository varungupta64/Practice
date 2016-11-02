package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


//this is not right
public class HUBULLU {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, p;
		boolean[] arr;
		int count;
		//this is not right
		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			p = Integer.parseInt(input[1]);
			arr = new boolean[n + 1];

			if (n == 1) {
				count = 1;
			} else {
				count = eratosthenes(arr, n);
			}

			if (n % 2 == 0) {
				if (p == 0) {
					bw.write("Pagfloyd wins.");
				} else {
					bw.write("Airborne wins.");
				}
			} else {
				if (p == 0) {
					bw.write("Airborne wins.");
				} else {
					bw.write("Pagfloyd wins.");
				}
			}
			bw.newLine();
		}
		//this is not right
		
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int eratosthenes(boolean[] arr, int n) {
		int count = 0;
		int j = 0;
		for (int i = 2; i <= n; i++) {
			if (!arr[i]) {
				count++;
				arr[i] = true;
				j = 2;
				while (i * j <= n) {
					arr[i * j] = true;
					j++;
				}
			}
		}
		return count;
	}
}
