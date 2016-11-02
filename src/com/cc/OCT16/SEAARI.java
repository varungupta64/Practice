package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class SEAARI {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;

		input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int d = Integer.parseInt(input[2]);
		int a, r;
		int lastIndex = 0;

		Number[] arr = new Number[n];

		input = bf.readLine().trim().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = new Number(i + 1, Integer.parseInt(input[i]));
		}

		Arrays.sort(arr, new NumberValueComparator());

		for (int i = 0; i < d && i < n; i++) {
			if (!arr[i].isDeleted) {
				arr[i].isDeleted = true;
				bw.write("2 " + arr[i].index);
				bw.newLine();
			}
			lastIndex = i;
		}

		int count = 0;
		int temp = 0;
		for (int i = lastIndex + 1; i < k && i < n; i++) {
			temp = arr[i].index;
			arr[i].index = arr[n - count - 1].index;
			arr[n - count - 1].index = temp;
			bw.write("1 " + arr[i].index + " " + arr[n - count - 1].index);
			bw.newLine();
			count--;
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}

class Number {
	int index;
	int value;
	boolean isDeleted;

	public Number(int index, int value) {
		this.index = index;
		this.value = value;
		this.isDeleted = false;
	}
}

class NumberIndexComparator implements Comparator<Number> {

	@Override
	public int compare(Number n1, Number n2) {
		return Integer.valueOf(n1.index).compareTo(Integer.valueOf(n2.index));
	}

}

class NumberValueComparator implements Comparator<Number> {

	@Override
	public int compare(Number n1, Number n2) {
		return Integer.valueOf(n1.value).compareTo(Integer.valueOf(n2.value));
	}

}
