package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinStepsToOneRecursive {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number");
		try {
			int n = Integer.parseInt(bf.readLine());

			System.out.println("Solution : " + minSteps(n));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int minSteps(int n) {
		int x = n;
		int y = n;
		int z = n;

		if (n <= 1) {
			return 0;
		}

		if (n % 2 == 0) {
			x = minSteps(n/2);
		}

		if (n % 3 == 0) {
			y = minSteps(n/3);
		}
		
			z = minSteps(n-1);

		return 1 + (min(min(x, y), z));
	}

	private static int min(int n1, int n2) {
		int min = n1;
		if (n2 < n1) {
			return n2;
		}
		return n1;
	}
}
