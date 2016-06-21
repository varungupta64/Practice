package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FIBQ {
	static List<Long> fibonacciList = new ArrayList<Long>();

	public static void main(String[] args) {
		fibonacciList.add(1l);
		fibonacciList.add(1l);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] input = bf.readLine().split(" ");
			int arrSize = Integer.parseInt(input[0]);
			int queryNum = Integer.parseInt(input[1]);
			String[] givenArray = bf.readLine().split(" ");
			int[] intArray = Stream.of(givenArray).mapToInt(Integer::parseInt).toArray();

			for (int i = 0; i < queryNum; i++) {
				String[] query = bf.readLine().split(" ");

				switch (query[0]) {
				case "Q":
					computeFunc(intArray, Integer.parseInt(query[1]), Integer.parseInt(query[2]));
					break;
				case "C":
					changeFunc(intArray, Integer.parseInt(query[1]), Integer.parseInt(query[2]));
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void changeFunc(int[] intArray, int i, int j) {
		intArray[i - 1] = intArray[j - 1];
	}

	private static void computeFunc(int[] intArray, int lRange, int rRange) {
		long result = 0;
		for (int i = lRange - 1; i < rRange; i++) {
			for (int j = i; j < rRange; j++) {
				if(i == j){
					result += fibonacciAtX(intArray[i]);
				}else{
					result += fibonacciAtX(intArray[i] + intArray[j]);
				}
			}
		}
		System.out.println(result);
	}

	private static long fibonacciAtX(int i) {
		System.out.print("F["+i+"] ");
		long result = 0;
		int index = i - 1;
		int seriesList = fibonacciList.size();
		if (index <= fibonacciList.size() - 1) {
			result = fibonacciList.get(index);
		} else {
			for (int j = seriesList; j <= index; j++) {
				calculateNextInFibonacciSeries(fibonacciList.get(fibonacciList.size() - 2), fibonacciList.get(fibonacciList.size() - 1));
			}
			result = fibonacciList.get(index);
		}
		return result;
	}

	private static void calculateNextInFibonacciSeries(long a, long b) {
		fibonacciList.add(a + b);
	}
}
