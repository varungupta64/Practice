package com.cf.round370div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_MemoryandTrident {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = bf.readLine().trim().toCharArray();
		int[] count = new int[2];

		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 'L':
				count[0]--;
				break;
			case 'R':
				count[0]++;
				break;
			case 'U':
				count[1]++;
				break;
			case 'D':
				count[1]--;
				break;
			}
		}

		if ((count[0] - count[1]) % 2 == 0) {
			int result = 0;
			count[0] = Math.abs(count[0]);
			count[1] = Math.abs(count[1]);
			
			if (count[0] > count[1]) {
				result = count[1] / 2 + count[1] % 2 + ((count[0] - count[1] % 2) / 2);
			} else {
				result = count[0] / 2 + count[0] % 2 + ((count[1] - count[0] % 2) / 2);
			}
			System.out.println(result);

		} else {
			System.out.println("-1");
		}

		bf.close();

	}
}
