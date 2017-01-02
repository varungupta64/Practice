package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BITMAP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m;
		char[][] arr;
		boolean[][] isVisited;
		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			arr = new char[n][m];
			isVisited = new boolean[n][m];
			for (int j = 0; j < n; j++) {
				arr[j] = bf.readLine().trim().toCharArray();
			}

			int[][] grid = bfsIterator(arr, 0, 0, 0, n - 1, 0, m - 1, isVisited);

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					bw.write(grid[j][k] + " ");
				}
				bw.newLine();
			}
			bw.newLine();
			bf.readLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int[][] bfsIterator(char[][] arr, int row, int col, int startRow, int endRow, int startCol,
			int endCol, boolean[][] isVisited) {
		int[][] grid = new int[endRow + 1][endCol + 1];
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for (int j = 0; j <= endRow; j++) {
			for (int k = 0; k <= endCol; k++) {
				if (arr[j][k] == '1') {
					grid[j][k] = 0;
					queue.add(new Integer[] { j, k, 0 });
					isVisited[j][k] = true;
				} else {
					grid[j][k] = Integer.MAX_VALUE;
				}
			}
		}

		Integer[] temp;

		while (!queue.isEmpty()) {
			temp = queue.poll();

			if (temp[0]-1 >= startRow && !isVisited[temp[0] - 1][temp[1]]) {
				grid[temp[0] - 1][temp[1]] = Integer.min(grid[temp[0] - 1][temp[1]], temp[2] + 1);
				queue.add(new Integer[] { temp[0] - 1, temp[1], grid[temp[0] - 1][temp[1]] });
				isVisited[temp[0] - 1][temp[1]] = true;
			}

			if (temp[0]+1 <= endRow && !isVisited[temp[0] + 1][temp[1]]) {
				grid[temp[0] + 1][temp[1]] = Integer.min(grid[temp[0] + 1][temp[1]], temp[2] + 1);
				queue.add(new Integer[] { temp[0] + 1, temp[1], grid[temp[0] + 1][temp[1]] });
				isVisited[temp[0] + 1][temp[1]] = true;
			}

			if (temp[1]-1 >= startCol && !isVisited[temp[0]][temp[1] - 1]) {
				grid[temp[0]][temp[1]-1] = Integer.min(grid[temp[0]][temp[1]-1], temp[2] + 1);
				queue.add(new Integer[] { temp[0], temp[1]-1, grid[temp[0]][temp[1]-1] });
				isVisited[temp[0]][temp[1]-1] = true;
			}

			if (temp[1]+1 <= endCol && !isVisited[temp[0]][temp[1] + 1]) {
				grid[temp[0]][temp[1]+1] = Integer.min(grid[temp[0]][temp[1]+1], temp[2] + 1);
				queue.add(new Integer[] { temp[0], temp[1]+1, grid[temp[0]][temp[1]+1] });
				isVisited[temp[0]][temp[1]+1] = true;
			}

		}

		return grid;
	}
}
