package com.cc.NOV16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class URBANDEV_Ed {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		int max = 1001;
		int[][] road = new int[max][max];
		int[] intersections = new int[n + 1];
		int count = 0;
		String[] coordinates;
		int x1, y1, x2, y2;

		for (int i = 1; i <= n; i++) {
			coordinates = bf.readLine().trim().split(" ");
			x1 = Integer.parseInt(coordinates[0]);
			y1 = Integer.parseInt(coordinates[1]);
			x2 = Integer.parseInt(coordinates[2]);
			y2 = Integer.parseInt(coordinates[3]);

			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					if (road[j][k] == 0) {
						road[j][k] = i;
					} else {
						intersections[road[j][k]]++;
						intersections[i]++;
						count++;
					}
				}
			}

		}

		System.out.println(count);
		for (int i = 1; i <= n; i++) {
			System.out.print(intersections[i] + " ");
		}

	}
}
