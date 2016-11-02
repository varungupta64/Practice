package com.cf.EducationalCodeforcesRound16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KingMoves {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = bf.readLine().trim().toCharArray();

		int a = arr[0] - 'a' + 1;
		int b = Character.getNumericValue(arr[1]);

		if ((a == 1 && (b == 1 || b == 8)) || (a == 8 && (b == 1 || b == 8))) {
			System.out.println(3);
		} else if (a != 1 && a != 8 && b != 1 && b != 8) {
			System.out.println(8);
		} else {
			System.out.println(5);
		}

	}

}
