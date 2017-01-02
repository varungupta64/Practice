package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NHAY {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input;
		int m;
		char[] pat;
		char[] txt;
		int[] lps;

		while ((input = bf.readLine()) != null && !input.equals("")) {
			m = Integer.parseInt(input.trim());
			pat = bf.readLine().trim().toCharArray();
			lps = new int[m];
			computeLPSArray(pat, lps, m);

			int i = 0;
			int j = 0;
			char c;
			int d;
			while (true) {
				d = bf.read();
				if (d == -1 || d == 13) {
					break;
				}
				c = (char) d;
				if(pat[j] == c){
					j++;
					i++;
				}
				if(j == m){
					bw.write(""+(i-j));
					bw.newLine();
					j = lps[j-1];
				}else if(pat[j] != c){
					if (j != 0)
	                    j = lps[j-1];
	                else
	                    i = i+1;
				}
			}
			bw.newLine();
			bf.readLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void computeLPSArray(char[] pat, int[] lps, int m) {
		int i = 1;
		int len = 0;
		lps[0] = 0;

		while (i < m) {
			if (pat[i] == pat[len]) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
}
