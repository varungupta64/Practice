package com.cc.SEPT16.COOK74;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TAASEQ {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n, d;
		String[] input;
		int[] arr;
		boolean isAP;
		int remove;

		for (int i = 0; i < t; i++) {
			remove = -1;
			isAP = true;
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			d = arr[1] - arr[0];			
			
			for (int j = 2; j < n; j++) {
				if (arr[j] - arr[j - 1] != d) {

					if (remove != -1) {
						isAP = false;
						break;
					}else{
						
						if(j == 2){
							d = arr[j] - arr[j-1];
							remove = arr[0];
						}else{
							remove = arr[j];
						}
						
					}

				}
			}

			if (!isAP) {
				bw.write("-1");
			} else {

				if (remove == -1) {
					if(d>0){
						bw.write("" + arr[0]);
					}else{
						bw.write("" + arr[n-1]);
					}
				} else {
					bw.write("" + remove);
				}

			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}

}
