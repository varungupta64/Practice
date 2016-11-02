package com.cc.OCT16.COOKOFF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class UGLYF {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		char[] s1, s2;
		ArrayList<Info_UGLYF>[] isPresent = new ArrayList[26];
		int size1;
		int size2;
		int l1, l3;
		int l2, l4;
		int ugliness;
		int min;

		for (int i = 0; i < t; i++) {

			ugliness = Integer.MAX_VALUE;

			for (int j = 0; j < 26; j++) {
				isPresent[j] = new ArrayList<Info_UGLYF>();
			}

			s1 = bf.readLine().trim().toCharArray();
			s2 = bf.readLine().trim().toCharArray();

			size1 = s1.length;
			size2 = s2.length;

			for (int j = 0; j < size1; j++) {
				isPresent[s1[j] - 'A'].add(new Info_UGLYF(j, size1 - 1 - j));
			}

			for (int j = 0; j < size2; j++) {
				for (int k = 0; k < isPresent[s2[j] - 'A'].size(); k++) {
					l1 = j;
					l3 = size2 - 1 - j;
					l2 = isPresent[s2[j] - 'A'].get(k).l2;
					l4 = isPresent[s2[j] - 'A'].get(k).l4;

					min = Math.abs(l1 - l2) + Math.abs(l2 - l3) + Math.abs(l3 - l4) + Math.abs(l4 - l1);

					ugliness = Integer.min(ugliness, min);
				}
			}

			bw.write("" + ugliness);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();

	}
}

class Info_UGLYF {
	int l2;
	int l4;

	public Info_UGLYF(int l2, int l4) {
		this.l2 = l2;
		this.l4 = l4;
	}
}