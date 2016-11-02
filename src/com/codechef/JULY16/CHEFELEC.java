package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFELEC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(bf.readLine().trim());
			String input = bf.readLine().trim();
			String[] arr = bf.readLine().trim().split(" ");

			int result = 0;

			int oneEle = -1;
			int twoEle = -1;

			int j = 0;
			while (input.charAt(j) == '0') {				
				j++;
			}
			result += Integer.parseInt(arr[j])-Integer.parseInt(arr[0]);
			
			oneEle = j;
			twoEle = findIndex(input, '1', j + 1, n);

			while (twoEle != -1) {
				int max = 0;

				for (int m = oneEle + 1; m <= twoEle; m++) {
					int num = Integer.parseInt(arr[m]) - Integer.parseInt(arr[m-1]);
					result += num;
					if (num > max) {
						max = num;
					}
				}

				result -= max;

				oneEle = twoEle;
				twoEle = findIndex(input, '1', oneEle+1, n);
			}

			if((oneEle+1)<n){
				result += (Integer.parseInt(arr[n-1]) - Integer.parseInt(arr[oneEle]));
			}

			System.out.println(result);
		}

	}

	private static int findIndex(String input, char i, int j, int n) {
		int result = -1;
		while (j < n) {
			if (input.charAt(j) == i) {
				result = j;
				break;
			}
			j++;
		}
		return result;
	}

}
