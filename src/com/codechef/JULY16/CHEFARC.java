package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CHEFARC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			String[] input = bf.readLine().trim().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int k1 = Integer.parseInt(input[2]);
			int k2 = Integer.parseInt(input[3]);

			int[][] arr = new int[n][m];
			String[] inp;

			for (int j = 0; j < n; j++) {
				inp = bf.readLine().trim().split(" ");
				for (int k = 0; k < m; k++) {
					arr[j][k] = Integer.parseInt(inp[k]);
				}
			}

			int steps = findShortestPath(arr, n, m, k1, k2);

			if (steps == -3) {
				steps = 0;
			} else if (steps == 0) {
				steps = -1;
			} else if (steps == 1) {
				steps = 1;
			} else if (steps % (k1 + k2) != 0) {
				steps = (steps / (k1 + k2)) + 1;
			} else {
				steps = steps / (k1 + k2);
			}

			System.out.println(steps);

		}

	}

	private static int findShortestPath(int[][] arr, int n, int m, int k1, int k2) {

		if (n == m && m == 1) {
			return -3;
		}

		if (k1 + k2 == 0) {
			return 0;
		}

		int[][] levelMatrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				levelMatrix[i][j] = arr[i][j] == 0 ? 0 : -1;
			}
		}

		LinkedList<Cell> queue = new LinkedList<Cell>();
		Cell start = new Cell(0, 0);
		Cell end = new Cell(0, m - 1);
		queue.add(start);
		levelMatrix[start.row][start.col] = 0;

		while (!queue.isEmpty()) {

			Cell cell = queue.poll();
			if (cell == end) {
				break;
			}

			int level = levelMatrix[cell.row][cell.col];
			Cell[] nextCells = new Cell[4];
			// right
			nextCells[0] = new Cell(cell.row, cell.col + 1);
			// up
			nextCells[1] = new Cell(cell.row - 1, cell.col);
			// down
			nextCells[2] = new Cell(cell.row + 1, cell.col);
			// left
			nextCells[3] = new Cell(cell.row, cell.col - 1);

			for (Cell nextCell : nextCells) {
				if (nextCell.row < 0 || nextCell.col < 0) {
					continue;
				}
				if (nextCell.row > n - 1 || nextCell.col > m - 1) {
					continue;
				}
				if (levelMatrix[nextCell.row][nextCell.col] == -0) {
					queue.add(nextCell);
					levelMatrix[nextCell.row][nextCell.col] = level + 1;
				}
			}
		}
		return levelMatrix[0][m - 1];
	}

	private static class Cell {
		public int row;
		public int col;

		public Cell(int row, int column) {
			this.row = row;
			this.col = column;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if ((obj == null) || (obj.getClass() != this.getClass()))
				return false;
			Cell cell = (Cell) obj;
			if (row == cell.row && col == cell.col)
				return true;
			return false;
		}

		@Override
		public String toString() {
			return "(" + row + "," + col + ")";
		}
	}
}
