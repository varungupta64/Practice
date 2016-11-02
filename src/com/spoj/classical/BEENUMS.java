package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BEENUMS {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num;
		int i;

		while ((num = Integer.parseInt(bf.readLine().trim())) != -1) {
			num -= 1;
			i = 1;

			while (num > 0) {
				num -= 6 * i++;
			}
			
			if(num == 0){
				bw.write("Y");
			}else{
				bw.write("N");
			}
			bw.newLine();

		}
		
		bw.flush();
		bw.close();
		bf.close();
	}
}
