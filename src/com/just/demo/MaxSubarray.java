package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSubarray {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCase = Integer.parseInt(bf.readLine().trim());
			for (int i = 0; i < testCase; i++) {
				long contiguousSum = -999999999;
				long nonContiguousSum = 0;
				long intermediateSum = 0;
				int arrSize = Integer.parseInt(bf.readLine().trim());
				String[] arr = bf.readLine().trim().split(" ");

				for (int j = 0; j < arrSize; j++) {
					long num = Long.parseLong(arr[j]);
					if (num > 0) {
						if (nonContiguousSum < 0) {
							nonContiguousSum = num;
						} else {
							nonContiguousSum += num;
						}
						intermediateSum += num;
						if (intermediateSum >= contiguousSum) {
							contiguousSum = intermediateSum;
						} else {
							intermediateSum = num;
						}
					} else {
						if (j == 0) {
							nonContiguousSum = num;
						} else if (num > nonContiguousSum) {
							nonContiguousSum = num;
						}
						intermediateSum += num;
						if (intermediateSum > contiguousSum) {
							contiguousSum = intermediateSum;
						}
						if (intermediateSum < 0) {
							intermediateSum = 0;
						}
					}
				}
				System.out.println(contiguousSum+" "+nonContiguousSum);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
