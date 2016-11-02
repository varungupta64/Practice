package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LEXOPAL {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		char[] arr;
		int len;
		int end;
		boolean isPossible;

		for (int i = 0; i < t; i++) {
			isPossible = true;
			arr = bf.readLine().trim().toCharArray();
			len = arr.length;
			end = len - 1;

			if (len % 2 == 0) {
				len = len / 2;
			} else {
				len = len / 2 + 1;
			}

			for (int j = 0; j < len; j++) {
				if (arr[j] == '.' && arr[end - j] == '.') {
					arr[j] = 'a';
					arr[end - j] = 'a';
				} else if (arr[j] == '.') {
					arr[j] = arr[end - j];
				} else if (arr[end - j] == '.') {
					arr[end - j] = arr[j];
				} else if (arr[j] != arr[end - j]) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				bw.write("" + String.valueOf(arr));
			} else {
				bw.write("-1");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
