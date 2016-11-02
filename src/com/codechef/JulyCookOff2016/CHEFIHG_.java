package com.codechef.JulyCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CHEFIHG_ {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input = new StringTokenizer(bf.readLine().trim(), " ");
		int n = Integer.parseInt(input.nextToken());
		int m = Integer.parseInt(input.nextToken());

		char[][] grid = new char[n][m];
		StringBuffer answer = new StringBuffer("");
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			grid[i] = bf.readLine().trim().toCharArray();
		}

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (grid[i][j] == '.') {
					result.add(bfs(grid, i, j, n, m));
				}
			}
		}

		Collections.sort(result, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() > s2.length()) {
					return -1;
				} else if (s1.length() < s2.length()) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		for (String a : result) {
			answer.append(a);
		}

		System.out.println(answer);

		bf.close();
	}

	private static String bfs(char[][] grid, int i, int j, int n, int m) {
		Queue<Point> queue = new LinkedList<Point>();
		boolean[][] isVisited = new boolean[n][m];
		isVisited[i][j] = true;
		queue.add(new Point(i, j, ""));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.getX();
			int y = p.getY();
			String path = p.getPath();

			if (grid[x][y] == 'C') {
				return p.getPath();
			}

			// U
			if (grid[x - 1][y] != '*' && !isVisited[x - 1][y]) {
				queue.add(new Point(x - 1, y, path + "U"));
			}

			// R
			if (grid[x][y + 1] != '*' && !isVisited[x][y + 1]) {
				queue.add(new Point(x, y + 1, path + "R"));
			}

			// D
			if (grid[x + 1][y] != '*' && !isVisited[x + 1][y]) {
				queue.add(new Point(x + 1, y, path + "D"));
			}

			// L
			if (grid[x][y - 1] != '*' && !isVisited[x][y - 1]) {
				queue.add(new Point(x, y - 1, path + "L"));
			}
		}
		return "";
	}

	static class Point {
		private int x;
		private int y;
		private String path;

		public Point(int x, int y, String path) {
			this.x = x;
			this.y = y;
			this.path = path;
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

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

	}
}
