package com.codechef.july2016.ltime38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CLOSEFAR {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int q;
		int result = 0;
		int[] arr = new int[n + 1];
		boolean[] isVisited = new boolean[n + 1];
		List<Integer> path = new ArrayList<Integer>(n - 1);

		input = bf.readLine().trim().split(" ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input[i - 1]);
		}

		LinkedList<Integer>[] adj = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			input = bf.readLine().trim().split(" ");
			adj[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			adj[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}

		q = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < q; i++) {
			input = bf.readLine().trim().split(" ");
			switch (input[0]) {
			case "C":
				path.add(Integer.parseInt(input[1]));
				findPath(adj, arr, isVisited, path, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
				result = findmin(path, arr);
				initializePath(path, n);
				initialize(isVisited, n);
				break;
			case "F":
				path.add(Integer.parseInt(input[1]));
				findPath(adj, arr, isVisited, path, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
				result = findmax(path, arr);
				initializePath(path, n);
				initialize(isVisited, n);
				break;
			}
			System.out.println(result);
		}
	}

	private static int findmin(List<Integer> path, int[] arr) {
		int min = Integer.MAX_VALUE;
		int num;
		for (int i = 0; i < path.size() - 1; i++) {
			for (int j = i + 1; j < path.size(); j++) {
				num = arr[path.get(i)] - arr[path.get(j)];
				if (num < 0) {
					num = -1 * num;
				}
				if (min > num) {
					min = num;
				}
			}
		}
		return min;
	}

	private static int findmax(List<Integer> path, int[] arr) {
		int max = Integer.MIN_VALUE;
		int num;
		for (int i = 0; i < path.size() - 1; i++) {
			for (int j = i + 1; j < path.size(); j++) {
				num = arr[path.get(i)] - arr[path.get(j)];
				if (num < 0) {
					num = -1 * num;
				}
				if (max < num) {
					max = num;
				}
			}
		}
		return max;
	}

	private static void initializePath(List<Integer> path, int n) {
		path.removeAll(path);
	}

	private static boolean findPath(LinkedList<Integer>[] adj, int[] arr, boolean[] isVisited, List<Integer> path,
			int left, int right) {
		if (left == right) {
			return true;
		}

		isVisited[left] = true;

		for (int i = 0; i < adj[left].size(); i++) {
			if (!isVisited[adj[left].get(i)] && findPath(adj, arr, isVisited, path, adj[left].get(i), right)) {
				path.add(adj[left].get(i));
				return true;
			}
		}

		return false;
	}

	private static void initialize(boolean[] isVisited, int n) {
		for (int i = 1; i <= n; i++) {
			isVisited[i] = false;
		}
	}
}
