package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DIVMAC_ONE {

	static final int maxNum = (int) 1e6;
	// leastPrimeDivisor
	static int[] lpd = new int[maxNum + 1];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		populateLeastPrimeDivisor();

		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		int[] arr;
		int l, r;
		SegmentTree sTree;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			arr = new int[n];

			input = bf.readLine().trim().split(" ");
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			sTree = new SegmentTree(arr, n, lpd);

			for (int j = 0; j < m; j++) {
				input = bf.readLine().trim().split(" ");
				l = Integer.parseInt(input[1]);
				r = Integer.parseInt(input[2]);
				switch (input[0]) {
				case "0":
					for (int k = l - 1; k <= r - 1; k++) {
						arr[k] = arr[k] / lpd[arr[k]];
					}
					sTree.update(arr, 0, n - 1, 0, l - 1, r - 1);
					break;
				case "1":
					bw.write(sTree.get(0, n - 1, 0, l - 1, r - 1) + " ");
					break;
				}
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void populateLeastPrimeDivisor() {
		boolean[] visited = new boolean[maxNum + 1];
		lpd[1] = 1;
		visited[1] = true;

		for (int i = 2; i <= maxNum; i++) {
			if (!visited[i]) {
				for (int j = 1; j * i <= maxNum; j++) {
					if (!visited[j * i]) {
						visited[j * i] = true;
						lpd[j * i] = i;
					}
				}
			}
		}
	}

}

class SegmentTreeLazy {
	int[] st;
	int[] ldp;
	int[] lazy;

	public SegmentTreeLazy(int[] arr, int n, int[] lpd) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSizeArr = 2 * (1 << h) - 1;
		st = new int[maxSizeArr];
		lazy = new int[maxSizeArr];
		this.ldp = lpd;

		populateSegmentTree(arr, 0, n - 1, 0);
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	private int populateSegmentTree(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = ldp[arr[start]];
			return st[current];
		}
		int mid = getMid(start, end);
		st[current] = max(populateSegmentTree(arr, start, mid, 2 * current + 1),
				populateSegmentTree(arr, mid + 1, end, 2 * current + 2));
		return st[current];
	}

	public int get(int start, int end, int current, int l, int r) {
		if (lazy[current] != 0) {
			// Make pending updates to this node. Note that this
			// node represents sum of elements in arr[ss..se] and
			// all these elements must be increased by lazy[si]
			st[current] += (end - start + 1) * lazy[current];

			// checking if it is not leaf node because if
			// it is leaf node then we cannot go further
			if (start != end) {
				// Since we are not yet updating children os si,
				// we need to set lazy values for the children
				lazy[current * 2 + 1] += lazy[current];
				lazy[current * 2 + 2] += lazy[current];
			}

			// unset the lazy value for current node as it has
			// been updated
			lazy[current] = 0;
		}

		if (l <= start && r >= end) {
			return st[current];
		}

		if (start > r || end < l) {
			return 1;
		}
		int mid = getMid(start, end);
		return max(get(start, mid, 2 * current + 1, l, r), get(mid + 1, end, 2 * current + 2, l, r));
	}

	public int update(int[] arr, int start, int end, int current, int l, int r) {
		// function)
		if (lazy[current] != 0) {
			// Make pending updates using value stored in lazy
			// nodes
			st[current] += (end - start + 1) * lazy[current];

			// checking if it is not leaf node because if
			// it is leaf node then we cannot go further
			if (start != end) {
				// We can postpone updating children we don't
				// need their new values now.
				// Since we are not yet updating children of si,
				// we need to set lazy flags for the children
				lazy[current * 2 + 1] += lazy[current];
				lazy[current * 2 + 2] += lazy[current];
			}

			// Set the lazy value for current node as 0 as it
			// has been updated
			lazy[current] = 0;
		}

		if (start > r || end < l) {
			return st[current];
		}

		// Current segment is fully in range
        if (start >= l && end <= r)
        {
            // Add the difference to current node
            st[current] += (end - start + 1) * diff;
 
            // same logic for checking leaf node or not
            if (start != end)
            {
                // This is where we store values in lazy nodes,
                // rather than updating the segment tree itelf
                // Since we don't need these updated values now
                // we postpone updates by storing values in lazy[]
                lazy[current * 2 + 1] += diff;
                lazy[current * 2 + 2] += diff;
            }
            return st[current];
        }
		
		if (start == end) {
			st[current] = ldp[arr[start]];
			return st[current];
		}

		int mid = getMid(start, end);
		st[current] = max(update(arr, start, mid, 2 * current + 1, l, r),
				update(arr, mid + 1, end, 2 * current + 2, l, r));
		return st[current];

	}
}