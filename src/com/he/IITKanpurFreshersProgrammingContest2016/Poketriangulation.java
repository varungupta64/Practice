package com.he.IITKanpurFreshersProgrammingContest2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Poketriangulation {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] x = new int[3];
		int[] y = new int[3];
		String[] input;

		for (int i = 0; i < 3; i++) {
			input = bf.readLine().trim().split(" ");
			x[i] = Integer.parseInt(input[0]);
			y[i] = Integer.parseInt(input[1]);
		}

		double area = area(x[0], y[0], x[1], y[1], x[2], y[2]);
		
		if(area == 0){
			System.out.println("Invalid");
		}else{
			
			if(isInsideTriangle(x[0], y[0], x[1], y[1], x[2], y[2], 0, 0, area)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
			
		}
	}

	public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((double)(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

	public static boolean isInsideTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y, double area) {
		double a1 = area(x, y, x2, y2, x3, y3);
		double a2 = area(x1, y1, x, y, x3, y3);
		double a3 = area(x, y, x2, y2, x, y);

		if (area == a1 + a2 + a3) {
			return true;
		} else {
			return false;
		}
	}
}
