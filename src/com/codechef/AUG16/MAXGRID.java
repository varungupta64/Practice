package com.codechef.AUG16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MAXGRID {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int l = Integer.parseInt(input[1]);
		int maxx, maxy;
		Point[] pointArr = new Point[n];

		for (int i = 0; i < n; i++) {
			pointArr[i] = new Point(bf.readLine().trim().split(" "));
		}

		Arrays.sort(pointArr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.getX() > o2.getX()) {
					return 1;
				}
				return 0;
			}
		});

		maxx = pointArr[n - 1].getX();

		Arrays.sort(pointArr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.getY() > o2.getY()) {
					return 1;
				}
				return 0;
			}
		});

		maxy = pointArr[n - 1].getY();

		int[][] arr = new int[maxx + 1][maxy + 1];
		int[][] dp = new int[maxx + 1][maxy + 1];

		for (int i = 0; i < n; i++) {
			arr[pointArr[i].getX()][pointArr[i].getY()] = pointArr[i].getCap();
		}

		
		
	}

}

class Point {
	int x;
	int y;
	int cap;

	public Point(String[] arr) {
		this.x = Integer.parseInt(arr[0]);
		this.y = Integer.parseInt(arr[1]);
		this.cap = Integer.parseInt(arr[2]);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

}
