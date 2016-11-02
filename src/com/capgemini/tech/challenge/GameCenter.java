package com.capgemini.tech.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class GameCenter {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine().trim());

		int[][] arr = new int[n][n];

		String input = bf.readLine().trim();
		input = input.substring(1, input.length() - 1);

		String[] ip = input.split(",");
		String[] ele;

		for (int i = 0; i < n; i++) {
			ele = ip[i].split("#");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(ele[j]);
			}
		}

		int maxAmongMin = 0;
		int maxAmongMax = 0;
		int min;
		int max;

		List<Point> list = new ArrayList<Point>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				min = Integer.MAX_VALUE;
				max = 0;

				// ele itself
				if (arr[i][j] > max) {
					max = arr[i][j];
				}

				if (arr[i][j] < min) {
					min = arr[i][j];
				}

				// up
				if (i != 0) {

					if (arr[i - 1][j] > max) {
						max = arr[i - 1][j];
					}

					if (arr[i - 1][j] < min) {
						min = arr[i - 1][j];
					}

				}

				// down
				if (i != n - 1) {

					if (arr[i + 1][j] > max) {
						max = arr[i + 1][j];
					}

					if (arr[i + 1][j] < min) {
						min = arr[i + 1][j];
					}

				}

				// left
				if (j != 0) {

					if (arr[i][j - 1] > max) {
						max = arr[i][j - 1];
					}

					if (arr[i][j - 1] < min) {
						min = arr[i][j - 1];
					}

				}

				// right
				if (j != n - 1) {

					if (arr[i][j + 1] > max) {
						max = arr[i][j + 1];
					}

					if (arr[i][j + 1] < min) {
						min = arr[i][j + 1];
					}

				}

				// left up
				if (i != 0 && j != 0) {

					if (arr[i - 1][j - 1] > max) {
						max = arr[i - 1][j - 1];
					}

					if (arr[i - 1][j - 1] < min) {
						min = arr[i - 1][j - 1];
					}

				}

				// right up
				if (i != 0 && j != n - 1) {

					if (arr[i - 1][j + 1] > max) {
						max = arr[i - 1][j + 1];
					}

					if (arr[i - 1][j + 1] < min) {
						min = arr[i - 1][j + 1];
					}

				}

				// left down
				if (i != n - 1 && j != 0) {

					if (arr[i + 1][j - 1] > max) {
						max = arr[i + 1][j - 1];
					}

					if (arr[i + 1][j - 1] < min) {
						min = arr[i + 1][j - 1];
					}

				}

				// right down
				if (i != n - 1 && j != n - 1) {

					if (arr[i + 1][j + 1] > max) {
						max = arr[i + 1][j + 1];
					}

					if (arr[i + 1][j + 1] < min) {
						min = arr[i + 1][j + 1];
					}

				}

				if (min < maxAmongMin) {
					// do nothing
				} else if (min > maxAmongMin) {
					maxAmongMin = min;
					maxAmongMax = max;
					list.removeAll(list);
					list.add(new Point(i, j));
				} else {

					if (max < maxAmongMax) {
						// do nothing
					} else if (max > maxAmongMax) {
						maxAmongMax = max;
						list.removeAll(list);
						list.add(new Point(i, j));
					} else {
						list.add(new Point(i, j));
					}

				}

			}
		}

		bw.write("{");

		StringBuffer output = new StringBuffer("");
		for (int i = 0; i < list.size(); i++) {
			output.append("" + (list.get(i).i + 1) + "#" + (list.get(i).j + 1) + ",");
		}
		String op = output.toString().substring(0, output.toString().length() - 1);
		bw.write(op);
		bw.write("}");

		bw.flush();
		bw.close();
		bf.close();

	}
}

class Point {
	int i, j;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}