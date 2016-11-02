package com.cf.round375div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class D {
	static int l = 0;
	static int r = 0;
	static int top = 0;
	static int bottom = 0;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		char[][] original;

		bottom = n - 1;
		r = m - 1;

		map = new char[n][m];
		original = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = bf.readLine().trim().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				original[i][j] = map[i][j];
			}
		}

		List<Point> list = new ArrayList<Point>();

		// top row
		for (int j = 0; j < m; j++) {
			getArea(0, j, list);
		}

		// bottom row
		for (int j = 0; j < m; j++) {
			getArea(n - 1, j, list);
		}

		// left column
		for (int i = 0; i < n; i++) {
			getArea(i, 0, list);
		}

		// right column
		for (int i = 0; i < n; i++) {
			getArea(i, m - 1, list);
		}

		int area;
		List<Info> infoList = new ArrayList<>();

		int areaNum = 0;
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 2; j++) {
				list = new ArrayList<Point>();
				area = getArea(i, j, list);

				if (area != 0) {
					infoList.add(new Info(area, list));
					areaNum++;
				}
			}
		}

		Collections.sort(infoList);

		Point p;
		int index = 0;
		int result = 0;
		while (areaNum > k) {
			result += infoList.get(index).area;
			for (int l = 0; l < infoList.get(index).pointList.size(); l++) {
				p = infoList.get(index).pointList.get(l);
				original[p.i][p.j] = '*';
			}
			index++;
			areaNum--;
		}

		bw.write("" + result);
		bw.newLine();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write("" + original[i][j]);
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	public static int getArea(int i, int j, List<Point> list) {
		if (map[i][j] == '*') {
			return 0;
		}

		list.add(new Point(i, j));
		map[i][j] = '*';

		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;

		// up
		if (i != top) {
			up = getArea(i - 1, j, list);
		}

		// down
		if (i != bottom) {
			down = getArea(i + 1, j, list);
		}

		// left
		if (j != l) {
			left = getArea(i, j - 1, list);
		}

		// right
		if (j != r) {
			right = getArea(i, j + 1, list);
		}

		return 1 + up + down + left + right;
	}

}

class Point {
	int i, j;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public String toString() {
		return "(" + i + " , " + j + ")";
	}
}

class Info implements Comparable<Info> {
	int area;
	List<Point> pointList;

	public Info(int area, List<Point> pointList) {
		this.area = area;
		this.pointList = pointList;
	}

	public String toString() {
		return "area : " + area;
	}

	@Override
	public int compareTo(Info o) {
		return Integer.valueOf(this.area).compareTo(Integer.valueOf(o.area));
	}
}