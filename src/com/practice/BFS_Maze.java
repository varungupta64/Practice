package com.practice;

import java.util.Queue;

public class BFS_Maze {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int pathLength = findPathBFS(arr, 0, 0, 0, arr.length, arr[0].length, arr.length);
		System.out.println(pathLength);
	}

	private static int findPathBFS(int[][] arr, int i, int j, int k, int length, int length2, int length3) {
		//Queue<Integer> q = new Q
		return 0;
	}

	
	
	/*private static int findPathBFS(int[][] arr, int srcI, int srcJ, int destI, int destJ, int n, int m) {
		if (srcI == destI && srcJ == destJ) {
			return 0;
		}

		arr[srcI][srcJ] = 1;
		
		int w = Integer.MAX_VALUE;
		int a = Integer.MAX_VALUE;
		int s = Integer.MAX_VALUE;
		int d = Integer.MAX_VALUE;

		// left
		if (srcJ - 1 >= 0 && arr[srcI][srcJ - 1] != 1) {
			a = 1 + findPathBFS(arr, srcI, srcJ - 1, destI, destJ, n, m);
		}

		// up
		if (srcI - 1 >= 0 && arr[srcI - 1][srcJ] != 1) {
			w = 1 + findPathBFS(arr, srcI - 1, srcJ, destI, destJ, n, m);
		}

		// right
		if (srcJ + 1 < n && arr[srcI][srcJ + 1] != 1) {
			d = 1 + findPathBFS(arr, srcI, srcJ + 1, destI, destJ, n, m);
		}

		// down
		if (srcI + 1 < m && arr[srcI + 1][srcJ] != 1) {
			s = 1 + findPathBFS(arr, srcI + 1, srcJ, destI, destJ, n, m);
		}

		
		return min(d,min(s,min(w,a)));
	}

	private static int min(int a, int b) {
		return a<b?a:b;
	}*/

}
