package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DOTAA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m, d, m1, num;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			if(input[0].equals("")){
				input = bf.readLine().trim().split(" ");
			}
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			d = Integer.parseInt(input[2]);
			m1 = 0;

			while (n-- > 0) {
				num = Integer.parseInt(bf.readLine().trim());
				m1 += num / d;
				if (num % d == 0) {
					m1--;
				}
			}
			
			if(m1>=m){
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
