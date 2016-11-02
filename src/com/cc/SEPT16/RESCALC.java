package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RESCALC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		int[] arr = new int[6];
		String[] input;
		int initial;
		int score;
		int min;
		boolean isTie;
		int maxScore;
		int index;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			maxScore = Integer.MIN_VALUE;
			isTie = false;
			index = 1;

			for (int k = 0; k < n; k++) {
				min = Integer.MAX_VALUE;

				initialize(arr);
				input = bf.readLine().trim().split(" ");
				initial = Integer.parseInt(input[0]);
				score = initial;
				for (int j = 1; j <= initial; j++) {
					arr[Integer.parseInt(input[j]) - 1]++;
				}

				int num;

				while ((num = countDistinct(arr)) >= 4) {

					for (int l = 0; l < 6; l++) {
						if (arr[l] != 0 && arr[l] < min) {
							min = arr[l];
						}
					}

					for (int l = 0; l < 6; l++) {
						if (arr[l] != 0) {
							arr[l] -= min;
						}
					}

					switch (num) {
					case 4:
						score += min * 1;
						break;
					case 5:
						score += min * 2;
						break;
					case 6:
						score += min * 4;
						break;
					}
				}

				if (score > maxScore) {
					maxScore = score;
					index = k + 1;
					isTie = false;
				} else if (score == maxScore) {
					isTie = true;
				}

				/*
				 * if(isTie){ break; }
				 */
			}

			if (isTie) {
				bw.write("tie");
			} else {

				if (index == 1) {
					bw.write("chef");
				} else {
					bw.write("" + index);
				}

			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static int countDistinct(int[] arr) {
		int num = 6;
		for (int i = 0; i < 6; i++) {
			if (arr[i] == 0) {
				num--;
			}
		}
		return num;
	}

	private static void initialize(int[] arr) {
		for (int i = 0; i < 6; i++) {
			arr[i] = 0;
		}

	}

}
