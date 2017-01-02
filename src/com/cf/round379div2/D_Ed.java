package com.cf.round379div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D_Ed {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int[] dist = new int[8];
		//int[] dist = new int[9];
		boolean[] distBool = new boolean[8];
		//boolean[] distBool = new boolean[9];
		Arrays.fill(dist, Integer.MAX_VALUE);
		char type;
		int x1, y1;
		int dirX, dirY, dirCode, distance, disty, distx;

		for (int i = 0; i < n; i++) {
			input = bf.readLine().trim().split(" ");
			type = input[0].toCharArray()[0];
			x1 = Integer.parseInt(input[1]);
			y1 = Integer.parseInt(input[2]);

			disty = Math.abs(y - y1);
			distx = Math.abs(x - x1);

			if (x - x1 == 0 || y - y1 == 0 || disty == distx) {

				dirX = distx == 0 ? 0 : (x - x1) / distx;
				dirY = disty == 0 ? 0 : (y - y1) / disty;

				dirCode = getDirection(dirX, dirY);
				//dirCode = dirY * 3 + dirX + 4;
				distance = Integer.max(distx,disty);

				if (distance < dist[dirCode]) {
					dist[dirCode] = distance;
					distBool[dirCode] = distx == disty ? type != 'R' : type != 'B';
				}
			}
		}

		if (isCheckPossible(distBool)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static boolean isCheckPossible(boolean[] distBool) {
		for (boolean b : distBool) {
			if (b)
				return b;
		}
		return false;
	}

	private static int getDirection(int distX, int distY) {
		int dirCode = -1;
		if (distX == 0) {
			if (distY == 1) {
				// up
				dirCode = 0;
			} else {
				// down
				dirCode = 1;
			}
		} else if (distY == 0) {
			if (distX == 1) {
				// right
				dirCode = 2;
			} else {
				// left
				dirCode = 3;
			}
		} else {
			if (distX == -1 && distY == 1) {
				// up left
				dirCode = 4;
			} else if (distX == 1 && distY == 1) {
				// up right
				dirCode = 5;
			} else if (distX == -1 && distY == -1) {
				// down left
				dirCode = 6;
			} else {
				// down right
				dirCode = 7;
			}
		}
		return dirCode;
	}
}
