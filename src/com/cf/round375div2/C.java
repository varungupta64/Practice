package com.cf.round375div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[] b = new int[m + 1];
		int extraSongs = 0;
		int min = n / m;
		int changes = 0;

		input = bf.readLine().trim().split(" ");
		List<Integer> posGreaterThanM = new ArrayList<>();
		List<Integer> posGreaterThanRequired = new ArrayList<>();
		List<Integer> numValueLessThanRequired = new ArrayList<>();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
			if (arr[i] > m) {
				posGreaterThanM.add(i);
				extraSongs++;
			} else {
				b[arr[i]] = b[arr[i]] + 1;
				if (b[arr[i]] > min) {
					posGreaterThanRequired.add(i);
				}
			}
		}
		int num;
		for (int i = 1; i <= m; i++) {
			if (b[i] < min) {
				num = min - b[i];
				while (num > 0) {
					numValueLessThanRequired.add(i);
					num--;
				}
			}
		}

		int index1 = 0;
		int index2 = 0;
		int index3 = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] > m) {

				if (index3 <= numValueLessThanRequired.size() - 1) {
					arr[i] = numValueLessThanRequired.get(index3);
					b[numValueLessThanRequired.get(index3)] = b[numValueLessThanRequired.get(index3)] + 1;
				} else {
					arr[i] = 1;
					b[1] = b[1] + 1;
				}

				changes++;
				extraSongs = extraSongs - 1;
				index3++;
				index1++;

			} else {

				if (b[arr[i]] == min) {
					// do nothing
				} else if (b[arr[i]] < min) {

					if (index1 <= posGreaterThanM.size() - 1) {
						arr[posGreaterThanM.get(index1++)] = arr[i];
					} else {
						arr[posGreaterThanRequired.get(index2++)] = arr[i];
					}

					extraSongs = extraSongs - 1;
					changes += 1;
					b[arr[i]] = b[arr[i]] + 1;
					index3++;

				}
			}
		}

		bw.write(min + " " + changes);
		bw.newLine();
		for (int i = 0; i < n; i++) {
			bw.write(arr[i] + " ");
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}