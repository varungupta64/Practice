package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AIBOHP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		char[] arr;
		int end;
		int start;
		while (t-- > 0) {
			arr = bf.readLine().trim().toCharArray();
			start = 0;
			end = arr.length - 1;
			bw.write("" + isPalindrome(arr, start, end));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int isPalindrome(char[] arr, int start, int end) {
		if (start == end || start > end) {
			return 0;
		}
		int a, b, c;
		if (arr[start] == arr[end]) {
			a = isPalindrome(arr, start + 1, end - 1);
		} else {
			a = Integer.MAX_VALUE;
		}

		// element inserted at end
		b = 1 + isPalindrome(arr, start + 1, end);

		// element inserted at start
		c = 1 + isPalindrome(arr, start, end - 1);
		return Integer.min(Integer.min(a, b), c);
	}
}
