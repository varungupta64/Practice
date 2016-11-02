package com.he.AugustClash16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GreedyChairman {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		input = bf.readLine().trim().split(" ");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		SegmentTree st = new SegmentTree(arr, n);
		int l, r, k;
		Info info;
		int req = 0;
		int prev = 0;
		int count;
		int ele;
		int num, den;
		int temp;
		boolean isPossible;
		int ans;
		int mod = (int) 1e9 + 7;

		for (int i = 0; i < m; i++) {
			num = 1;
			den = 1;
			req = 0;
			prev = 0;
			count = 0;
			isPossible = false;
			input = bf.readLine().trim().split(" ");
			l = Integer.parseInt(input[0]);
			r = Integer.parseInt(input[1]);
			k = Integer.parseInt(input[2]);

			info = st.findSegment(l-1, r-1, 0, n - 1, 0);

			while (count < info.arr.length && info.arr[count] != null) {
				prev = req;
				req = info.arr[count++].count;

				if (prev < k && req >= k) {
					isPossible = true;
					break;
				}
			}

			if (isPossible) {
				ele = req - prev;

				if (ele <= k) {
					ans = ele;
					bw.write(""+ans);
				} else {
					for (int j = 0; j < k; j++) {
						num *= ele--;
					}
					for (int j = 1; j <= k; j++) {
						den *= k;
					}
					ans = (num / den) % mod;
					bw.write("" + ans);
				}
			} else {
				bw.write("" + -1);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}

class SegmentTree {
	Info[] st;

	public SegmentTree(int[] arr, int n) {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int maxSize = 2 * (int) Math.pow(2, h) - 1;
		st = new Info[maxSize];
		buildSegmentTree(arr, 0, n - 1, 0);
	}

	private Info buildSegmentTree(int[] arr, int start, int end, int current) {
		if (start == end) {
			st[current] = new Info(arr[start], 1);
			return st[current];
		}

		int mid = getMid(start, end);
		st[current] = merge(buildSegmentTree(arr, start, mid, 2 * current + 1),
				buildSegmentTree(arr, mid + 1, end, 2 * current + 2));
		return st[current];
	}

	public Info findSegment(int left, int right, int start, int end, int current) {
		if (right < start || left > end) {
			return null;
		}

		if (left <= start && right >= end) {
			return st[current];
		}

		int mid = getMid(start, end);
		return merge(findSegment(left, right, start, mid, 2 * current + 1),
				findSegment(left, right, mid + 1, end, 2 * current + 2));
	}

	private Info merge(Info info1, Info info2) {
		Info info;
		if (null == info1) {
			return info2;
		} else if (null == info2) {
			return info1;
		} else {
			int index = 0;
			int info1Size = info1.size;
			int info2Size = info2.size;
			int size = info1.size + info2.size;
			info = new Info(size);
			int info1Index = 0;
			int info2Index = 0;

			while (info1Index < info1Size && info2Index < info2Size) {
				if (info1.arr[info1Index].compareTo(info2.arr[info2Index]) < 0) {
					info.arr[index] = info1.arr[info1Index];
					index++;
					info1Index++;
				} else if (info1.arr[info1Index].compareTo(info2.arr[info2Index]) > 0) {
					info.arr[index] = info2.arr[info2Index];
					index++;
					info2Index++;
				} else {
					info.arr[index] = info1.arr[info1Index];
					info.arr[index].count += info2.arr[info2Index].count;
					index++;
					info.size = info.size - 1;
					info1Index++;
					info2Index++;
				}
			}

			while (info1Index < info1Size) {
				info.arr[index] = info1.arr[info1Index];
				index++;
				info1Index++;
			}

			while (info2Index < info2Size) {
				info.arr[index] = info2.arr[info2Index];
				index++;
				info2Index++;
			}
		}

		return info;
	}

	private int getMid(int start, int end) {
		return start + (end - start) / 2;
	}

}

class Info {
	int size;
	Point[] arr;

	public Info() {

	}

	public Info(int size) {
		this.size = size;
		arr = new Point[size];
	}

	public Info(int value, int size) {
		this.size = size;
		arr = new Point[size];
		arr[0] = new Point(value, 1);
	}
}

class Point implements Comparable<Point> {
	int value;
	int count;

	public Point(int value, int count) {
		this.value = value;
		this.count = count;
	}

	@Override
	public int compareTo(Point p) {
		if (this.value > p.value) {
			return 1;
		} else if (this.value < p.value) {
			return -1;
		} else {
			return 0;
		}
	}
}