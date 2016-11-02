package com.cf.round367div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeruTaxi {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = bf.readLine().trim().split(" ");

		double a = Double.parseDouble(input[0]);
		double b = Double.parseDouble(input[1]);
		double x, y, v, result;

		int n = Integer.parseInt(bf.readLine().trim());

		double min = Double.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			input = bf.readLine().trim().split(" ");
			x = Double.parseDouble(input[0]);
			y = Double.parseDouble(input[1]);
			v = Double.parseDouble(input[2]);

			result = Math.sqrt(Math.pow(x - a, 2) + Math.pow(y - b, 2))/v;

			if (result < min) {
				min = result;
			}
		}

		System.out.println(min);

	}

}
