package com.codechef.JulyCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CHEFLKJ_ {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input = new StringTokenizer(br.readLine().trim(), " ");
		int n = Integer.parseInt(input.nextToken());
		int q = Integer.parseInt(input.nextToken());

		input = new StringTokenizer(br.readLine().trim(), " ");
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input.nextToken());
		}

		SegmentTree tree = new SegmentTree(arr, n);

		String[] query;
		for (int i = 0; i < q; i++) {
			query = br.readLine().trim().split(" ");
			switch (query[0]) {
			case "1":
				int index = Integer.parseInt(query[1]);
				int oldval = arr[index];
				tree.update(arr, 1, n, index, Integer.parseInt(query[2]), 1, oldval);
				break;
			case "2":
				Info info = tree.get(arr, 1, n, Integer.parseInt(query[1]), Integer.parseInt(query[2]), 1);
				if (info.getDominant() > 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
				break;
			}
		}

		br.close();
	}

	static class SegmentTree {
		Info st[];

		public SegmentTree(int[] arr, int n) {
			int height = (int) Math.ceil((Math.log(n) / Math.log(2)));
			int maxSize = 2 * (int) Math.pow(2, height) - 1;
			st = new Info[maxSize];
			createSegmentTree(arr, 1, n, 1);
		}

		public void update(int[] arr, int start, int end, int index, int newval, int current, int oldval) {
			if (start == end) {
				arr[index] = newval;
				st[current].occurrences.remove(oldval);
				st[current].occurrences.put(newval, 1);
				st[current].dominant = newval;
				return;
			}

			if (index < start || index > end) {
				return;
			}

			if (start <= index && index <= end) {
				int length = end + 1 - start;
				int req = length / 2 + 1;
				
				if(st[current].dominant == oldval && st[current].occurrences.get(oldval) == req){
						st[current].dominant = -1;
				}else if(st[current].getOccurrences().containsKey(newval) && st[current].getOccurrences().get(newval) == req -1){
					st[current].dominant = newval;
				}
				
				if (st[current].occurrences.get(oldval) > 1) {
					st[current].occurrences.put(oldval, st[current].occurrences.get(oldval) - 1);
				} else {
					st[current].occurrences.remove(oldval);
				}

				if (null != st[current].occurrences.get(newval)) {
					st[current].occurrences.put(newval, st[current].occurrences.get(newval) + 1);
				} else {
					st[current].occurrences.put(newval, 1);
				}
			}

			int mid = getMid(start, end);
			update(arr, start, mid, index, newval, 2 * current, oldval);
			update(arr, mid + 1, end, index, newval, 2 * current + 1, oldval);
		}

		public Info get(int[] arr, int start, int end, int left, int right, int current) {
			if (left > end || right < start) {
				return null;
			}

			if (left <= start && right >= end) {
				return st[current];
			}

			int mid = getMid(start, end);
			Info one = get(arr, start, mid, left, right, 2 * current);
			Info two = get(arr, mid + 1, end, left, right, 2 * current + 1);

			if (null != one && null != two) {
				return merge(one, two, start < left ? left : start, end > right ? right : end);
			} else if (null != one) {
				return one;
			} else {
				return two;
			}

		}

		private Info createSegmentTree(int[] arr, int start, int end, int current) {
			if (start == end) {
				st[current] = new Info();
				st[current].setDominant(arr[start]);
				st[current].occurrences = new HashMap<>();
				st[current].occurrences.put(arr[start], 1);
				return st[current];
			}

			int mid = getMid(start, end);
			st[current] = merge(createSegmentTree(arr, start, mid, 2 * current),
					createSegmentTree(arr, mid + 1, end, 2 * current + 1), start, end);
			return st[current];
		}

		private Info merge(Info tree1, Info tree2, int start, int end) {
			Info info = new Info();
			Map<Integer, Integer> map1 = tree1.getOccurrences();
			Map<Integer, Integer> map2 = tree2.getOccurrences();
			Map<Integer, Integer> map3 = new HashMap<Integer, Integer>();
			map3.putAll(map1);

			info.setDominant(-1);
			info.setOccurrences(map3);

			int length = end + 1 - start;
			int count = -1;
			int req = (length / 2) + 1;

			for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
				if (null != map3.get(e.getKey())) {
					count = map3.get(e.getKey()) + e.getValue();
					map3.put(e.getKey(), count);
				} else {
					count = e.getValue();
					map3.put(e.getKey(), count);
				}

				if (count >= req) {
					info.setDominant(e.getKey());
				}
			}

			return info;
		}

		private int getMid(int start, int end) {
			return start + ((end - start) / 2);
		}
	}

	static class Info {
		private int dominant;
		private Map<Integer, Integer> occurrences;

		public Info() {

		}

		public Info(int dominant, Map<Integer, Integer> occurrences) {
			this.dominant = dominant;
			this.occurrences = occurrences;
		}

		public int getDominant() {
			return dominant;
		}

		public void setDominant(int dominant) {
			this.dominant = dominant;
		}

		public Map<Integer, Integer> getOccurrences() {
			return occurrences;
		}

		public void setOccurrences(Map<Integer, Integer> occurrences) {
			this.occurrences = occurrences;
		}

	}
}
