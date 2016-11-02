package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class STAMPS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		long n;
		Long[] arr;
		boolean isImpossible;
		int count;

		for (int i = 1; i <= t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Long.parseLong(input[0]);

			isImpossible = true;
			count = 0;
			input = bf.readLine().trim().split(" ");
			arr = new Long[input.length];

			for (int j = 0; j < input.length; j++) {
				arr[j] = Long.parseLong(input[j]);
			}

			Arrays.sort(arr, Collections.reverseOrder());
			
			for(int j=0;j<input.length;j++){
				n -= arr[j];
				count++;
				if(n <= 0){
					isImpossible = false;
					break;
				}
			}

			
			bw.write("Scenario #"+i+":");
			bw.newLine();
			if(isImpossible){
				bw.write("impossible");
			}else{
				bw.write(""+count);
			}
			bw.newLine();
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		bf.close();
	}

}
