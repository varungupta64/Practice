package com.he.AugustClash16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class JosephAndTree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int v1, v2, w;

		int n = Integer.parseInt(bf.readLine().trim());

		Node[] arr = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new Node();
		}

		for (int i = 0; i < n - 1; i++) {
			input = bf.readLine().trim().split(" ");
			v1 = Integer.parseInt(input[0]);
			v2 = Integer.parseInt(input[1]);
			w = Integer.parseInt(input[2]);

			if (v1 < v2) {
				arr[v1].addChild(v2, w);
			} else {
				arr[v2].addChild(v1, w);
			}
		}

		int q = Integer.parseInt(bf.readLine().trim());
		Query[] queryArr = new Query[q];

		for (int i = 0; i < q; i++) {
			queryArr[i] = new Query(bf.readLine().trim().split(" "), i);
		}

		Arrays.sort(queryArr, new Comparator<Query>() {

			@Override
			public int compare(Query o1, Query o2) {
				if (o1.getV() > o2.getV()) {
					return 1;
				} else if (o1.getV() < o2.getV()) {
					return -1;
				}
				return 0;
			}
		});

		solveQuery(queryArr[0], arr);
		getKthEle(queryArr[0]);

		for (int i = 1; i < q; i++) {
			if (queryArr[i - 1].getV() == queryArr[i].getV()) {
				queryArr[i].setArr(queryArr[i - 1].getArr());
			} else {
				solveQuery(queryArr[i], arr);
			}
			getKthEle(queryArr[i]);
		}

		Arrays.sort(queryArr, new Comparator<Query>() {

			@Override
			public int compare(Query o1, Query o2) {
				if (o1.getIndex() > o2.getIndex()) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		for (int i = 0; i < q; i++) {
			bw.write("" + queryArr[i].getAns());
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void getKthEle(Query query) {
		int k = query.getK();
		Integer[] arr = query.getArr();
		if (k > arr.length) {
			query.setAns(-1);
		} else {
			query.setAns(arr[k - 1]);
		}
	}

	private static void solveQuery(Query query, Node[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		solveQueryUtil(query.getV(), 0, arr, list);

		Integer[] listToArr = new Integer[list.size()];
		listToArr = list.toArray(listToArr);
		Arrays.sort(listToArr);
		query.setArr(listToArr);
	}

	private static void solveQueryUtil(int parent, int base, Node[] arr, List<Integer> list) {
		for (int i = 0; i < arr[parent].parentOf.size(); i++) {
			list.add(base + arr[parent].parentOf.get(i).weight);
			solveQueryUtil(arr[parent].parentOf.get(i).index, arr[parent].parentOf.get(i).weight, arr, list);
		}
	}

}

class Node {
	LinkedList<Values> parentOf;

	public Node() {
		this.parentOf = new LinkedList<Values>();
	}

	public void addChild(int vertex, int weight) {
		this.parentOf.add(new Values(vertex, weight));
	}
}

class Values {
	int index;
	int weight;

	public Values(int vertex, int weight) {
		this.index = vertex;
		this.weight = weight;
	}
}

class Query {
	private int v;
	private int k;
	private int ans;
	private int index;
	private Integer[] arr;
	private boolean isSolved;

	public Query(String[] arr, int index) {
		this.v = Integer.parseInt(arr[0]);
		this.k = Integer.parseInt(arr[1]);
		this.index = index;
	}

	public int getV() {
		return v;
	}

	public int getK() {
		return k;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public int getIndex() {
		return index;
	}

	public Integer[] getArr() {
		return arr;
	}

	public void setArr(Integer[] arr) {
		this.arr = arr;
	}

	public boolean isSolved() {
		return isSolved;
	}

	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

}