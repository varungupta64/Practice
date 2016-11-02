package com.he.IITKanpurFreshersProgrammingContest2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PokeSticks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader bf = new BufferedReader(new FileReader("/home/nagarro/Desktop/testCase.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		String num;
		int[] arr;
		String[] input;	
		int a;
		int[] l = new int[2];
		int index;

		for (int i = 0; i < t; i++) {
			num = bf.readLine();
			
			if(null == num || "".equals(num)){
				break;
			}
			
			n = Integer.parseInt(num.trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			Arrays.sort(arr);
			l[0] = 0;
			l[1] = 0;
			index = 0;
			for (int j = n - 1; j > 0 && index <= 1; j--) {
				if (arr[j] == arr[j - 1]) {
					l[index++] = arr[j - 1];
					j--;
				}
			}

			a = l[0] * l[1];

			if (a == 0) {
				a = -1;
			}

			bw.write("" + a);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
