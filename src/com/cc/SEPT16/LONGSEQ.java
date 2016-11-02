package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LONGSEQ {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		char[] arr;
		int zero;
		int one;
		
		for (int i = 0; i < t; i++) {
			zero = 0;
			one = 0;
			arr = bf.readLine().trim().toCharArray();
			for (char c : arr) {
				switch (c) {
				case '0':
					zero++;
					break;

				case '1':
					one++;
					break;

				}				
			}
			
			if(zero == 1 || one == 1){
				bw.write("Yes");
			}else{
				bw.write("No");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
