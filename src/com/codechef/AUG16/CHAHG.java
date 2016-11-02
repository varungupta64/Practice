package com.codechef.AUG16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CHAHG {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int inf = 2000000000;

		int n;
		String[] input;
		int[] h;
		int[] m;
		int t = Integer.parseInt(bf.readLine().trim());
		// h1 is incr
		// -2 is for infinity
		// -1 is for does not exist
		int[][] inc;
		// h1 is dec
		int[][] dec;
		boolean isImp;
		int temp;
		int[] incDec = new int[2];
		int[] decInc = new int[2];
		int min, max, count;
		boolean isIncDec,isDecInc;

		for (int i = 0; i < t; i++) {
			isImp = false;
			n = Integer.parseInt(bf.readLine().trim());
			h = new int[n];
			m = new int[n];

			for (int j = 0; j < n; j++) {
				input = bf.readLine().trim().split(" ");
				h[j] = Integer.parseInt(input[0]);
				m[j] = Integer.parseInt(input[1]);
			}

			if (n == 1) {
				bw.write("" + 0);
				bw.newLine();
				/*bw.write("0 Inf");
				bw.newLine();*/
				continue;
			}

			inc = new int[n][2];
			dec = new int[n][2];

			for (int j = 1; j < n; j++) {
				if (h[j - 1] > h[j] && m[j - 1] >= m[j]) {
					inc[j - 1][0] = 0;
					inc[j - 1][1] = inf;
					dec[j][0] = 0;
					dec[j][1] = inf;
					dec[j - 1][0] = -1;
					dec[j - 1][1] = -1;
					inc[j][0] = -1;
					inc[j][1] = -1;
				} else if (h[j - 1] < h[j] && m[j - 1] <= m[j]) {
					inc[j - 1][0] = -1;
					inc[j - 1][1] = -1;
					dec[j][0] = -1;
					dec[j][1] = -1;
					dec[j - 1][0] = 0;
					dec[j - 1][1] = inf;
					inc[j][0] = 0;
					inc[j][1] = inf;
				} else if (h[j - 1] < h[j] && m[j - 1] > m[j]) {
					temp = (h[j] - h[j - 1]) / (m[j - 1] - m[j]);
					inc[j - 1][0] = temp + 1;
					inc[j - 1][1] = inf;
					dec[j][0] = temp + 1;
					dec[j][1] = inf;
					dec[j - 1][0] = 0;
					dec[j - 1][1] = temp - 1;
					inc[j][0] = 0;
					inc[j][1] = temp - 1;
				} else if (h[j - 1] > h[j] && m[j - 1] < m[j]) {
					temp = (h[j - 1] - h[j]) / (m[j] - m[j - 1]);
					inc[j][0] = temp + 1;
					inc[j][1] = inf;
					dec[j - 1][0] = temp + 1;
					dec[j - 1][1] = inf;
					dec[j][0] = 0;
					dec[j][1] = temp - 1;
					inc[j - 1][0] = 0;
					inc[j - 1][1] = temp - 1;
				} else if (h[j - 1] == h[j] && m[j - 1] < m[j]) {
					inc[j][0] = 1;
					inc[j][1] = inf;
					dec[j - 1][0] = 1;
					dec[j - 1][1] = inf;
					dec[j][0] = -1;
					dec[j][1] = -1;
					inc[j - 1][0] = -1;
					inc[j - 1][1] = -1;
				} else if (h[j - 1] == h[j] && m[j - 1] > m[j]) {
					inc[j - 1][0] = 1;
					inc[j - 1][1] = inf;
					dec[j][0] = 1;
					dec[j][1] = inf;
					dec[j - 1][0] = -1;
					dec[j - 1][1] = -1;
					inc[j][0] = -1;
					inc[j][1] = -1;
				} else {
					isImp = true;
					break;
				}
			}

			max = inc[0][0];
			min = inc[0][1];

			// inc dec
			for (int j = 1; j < n; j++) {
				if (j % 2 == 0) {

					if (inc[j][0] > max) {
						max = inc[j][0];
					}

					if (inc[j][1] < min) {
						min = inc[j][1];
					}

				} else {

					if (dec[j][0] > max) {
						max = dec[j][0];
					}

					if (dec[j][1] < min) {
						min = dec[j][1];
					}

				}
			}

			incDec[0] = max;
			incDec[1] = min;

			max = dec[0][0];
			min = dec[0][1];

			// dec inc
			for (int j = 1; j < n; j++) {
				if (j % 2 == 0) {

					if (dec[j][0] > max) {
						max = dec[j][0];
					}

					if (dec[j][1] < min) {
						min = dec[j][1];
					}

				} else {

					if (inc[j][0] > max) {
						max = inc[j][0];
					}

					if (inc[j][1] < min) {
						min = inc[j][1];
					}

				}
			}

			decInc[0] = max;
			decInc[1] = min;
			
			if(incDec[0] == decInc[0] && incDec[1] == decInc[1]){
				if(incDec[0] == -1 || incDec[1] == -1){
					bw.write("0");
					bw.newLine();
					continue;
				}else{
					bw.write("1");
					bw.newLine();
					if(decInc[1] == inf){
						bw.write(""+decInc[0]+" Inf");
					}else{
						bw.write(""+decInc[0]+" "+decInc[1]);
					}
				}
			}else{
				
				if(decInc[0] < incDec[0]){
					count = 0;
					isDecInc = true;
					isIncDec = true;
					
					if(decInc[0] == -1 || decInc[1] == -1){	
						isDecInc = false;
					}else{
						count++;
					}
					
					if(incDec[0] == -1 || incDec[1] == -1){	
						isIncDec = false;
					}else{
						count++;
					}
					
					bw.write(""+count);
					if(isDecInc){
						bw.newLine();
						bw.write(""+decInc[0]+" "+(decInc[1]==inf?"Inf":""+decInc[1]));
					}
					if(isIncDec){
						bw.newLine();
						bw.write(""+incDec[0]+" "+(incDec[1]==inf?"Inf":""+incDec[1]));
					}
					
				}else{
					

					count = 0;
					isDecInc = true;
					isIncDec = true;
					
					if(decInc[0] == -1 || decInc[1] == -1){	
						isDecInc = false;
					}else{
						count++;
					}
					
					if(incDec[0] == -1 || incDec[1] == -1){	
						isIncDec = false;
					}else{
						count++;
					}
					
					bw.write(""+count);
					if(isIncDec){
						bw.newLine();
						bw.write(""+incDec[0]+" "+(incDec[1]==inf?"Inf":incDec[1]));
					}
					if(isDecInc){
						bw.newLine();
						bw.write(decInc[0]+" "+(decInc[1]==inf?"Inf":decInc[1]));
					}
				}
				
			}

			if (isImp) {
				bw.write("0");
			}

			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}