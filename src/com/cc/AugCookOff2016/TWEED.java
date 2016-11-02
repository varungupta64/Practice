package com.cc.AugCookOff2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TWEED {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, num;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);

			if (input[1].equals("Dee") && n == 1) {
				num = Integer.parseInt(bf.readLine().trim());
				
				if(num%2==0){
					bw.write("Dee");					
				}else{
					bw.write("Dum");
				}
			} else {
				bf.readLine();
				bw.write("Dum");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
