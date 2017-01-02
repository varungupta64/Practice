package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ANARC09A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] arr;
		int n;
		int count = 0;
		while ((arr = bf.readLine().trim().toCharArray()) != null && arr[0] != '-') {
			count++;
			n = arr.length - 1;
			bw.write(count + ". " + isStable(arr, n));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int isStable(char[] arr, int n) {
		Stack<Character> stack = new Stack<>();
		int result = 0;
		char c;
		if (arr[0] != '{') {
			arr[0] = '{';
			result++;
		}
		if (arr[n] != '}') {
			arr[n] = '}';
			result++;
		}
		for (int i = 0; i <= n; i++) {
			if (arr[i] == '{') {
				stack.push('{');
			} else {
				if (!stack.isEmpty() && (c = stack.peek()) == '{') {
					stack.pop();
				} else {
					arr[i] = '{';
					result++;
					i--;
				}
			}
		}
		return result + (stack.size() / 2);
	}

}
