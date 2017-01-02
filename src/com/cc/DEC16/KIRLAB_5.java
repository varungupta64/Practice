package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KIRLAB_5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		String[] input;
		long[] arr;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new long[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Long.parseLong(input[j]);
			}
			if (n == 1) {
				bw.write("1");
			} else {
				bw.write("" + maxRooms(n - 1, arr));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static long maxRooms(int n, long[] arr) {
		long len = 1;
		long gcd;
		long num = arr[n];
		
		for (int j = n-1; j >= 0; j--) {
			gcd = gcd(arr[j], num) > 1 ? 1 : 0;
			if(gcd == 1){
				len++;
				num = arr[j];
			}else{
				num *= arr[j]; 
			}
		}

		return len;
	}

	private static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
}
