package com.cc.CDJA2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RC01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int l, r, m;
		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(bf.readLine().trim());
		}

		int q = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < q; i++) {
			input = bf.readLine().trim().split(" ");
			l = Integer.parseInt(input[0]);
			r = Integer.parseInt(input[1]);
			m = l + (r - l) / 2;
			bw.write("" + arr[m]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}

class SegmentTree {
	int[] st;
	int n;

	public SegmentTree(int n, int[] arr) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxNodes = 2 * (int) Math.pow(2, h) - 1;
		st = new int[h];
		buildSegmentTree(arr, 1, n, 1);
	}

	private int buildSegmentTree(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = arr[start];
			return st[current];
		}

		int mid = getMid(start, end);
		//TODO
		
		return st[current];
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

}