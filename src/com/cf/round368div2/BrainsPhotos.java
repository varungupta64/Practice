package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrainsPhotos {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		boolean isColored = false;
		char[] arr;

		for (int i = 0; i < n; i++) {
			input = bf.readLine().trim().split(" ");
			for (int j = 0; j < m; j++) {
				if (input[j].equals("C") || input[j].equals("M") || input[j].equals("Y")) {
					isColored = true;
					break;
				}
			}
		}

		if (isColored) {
			System.out.println("#Color");
		} else {
			System.out.println("#Black&White");
		}

	}

}
