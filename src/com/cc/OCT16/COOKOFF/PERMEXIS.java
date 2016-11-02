package com.cc.OCT16.COOKOFF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PERMEXIS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		String[] input;
		int[] arr;
		boolean isPossible;

		for (int i = 0; i < t; i++) {

			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];
			isPossible = true; 

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			Arrays.sort(arr);

			for (int j = 1; j < n; j++) {
				if(arr[j] - arr[j-1] > 1){
					isPossible = false;
					break;
				}
			}
			
			if(isPossible){
				bw.write("YES");
			}else{
				bw.write("NO");
			}
			bw.newLine();

		}
		
		bw.flush();
		bw.close();
		bf.close();

	}
}
