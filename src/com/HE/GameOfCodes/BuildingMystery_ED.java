package com.HE.GameOfCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BuildingMystery_ED {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			
			if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
				stack.push(i);
			} else {
				
				
			}
			
		}

	}

}
