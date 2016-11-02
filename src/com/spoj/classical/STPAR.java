package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class STPAR {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = -1;
		String[] input;
		int[] arr;
		int current;
		int required;
		STPAR_Stack stack;
		boolean isPossible;

		while ((num = Integer.parseInt(bf.readLine().trim())) != 0) {
			isPossible = true;
			stack = new STPAR_Stack();
			current = 0;
			input = bf.readLine().trim().split(" ");
			arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			required = current + 1;

			for (int i = 0; i < num; i++) {
				if (required == arr[i]) {
					required = required + 1;
				} else if (stack.top != null && required == stack.top.value) {
					required = required + 1;
					stack.pop();
					i--;
				} else if (stack.top == null) {
					stack.push(arr[i]);
				} else if (stack.top.value > arr[i]) {
					stack.push(arr[i]);
				} else {
					bw.write("no");
					bw.newLine();
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				bw.write("yes");
				bw.newLine();
			}

		}

		bw.flush();
		bw.close();
		bf.close();
	}
}

class STPAR_Stack {
	STPAR_Cell top;

	public STPAR_Stack() {
		top = null;
	}

	public void push(int value) {
		STPAR_Cell cell = new STPAR_Cell(value);
		cell.next = top;
		top = cell;
	}

	public void pop() {
		if (top != null) {
			top = top.next;
		}
	}
}

class STPAR_Cell {
	int value;
	STPAR_Cell next;

	public STPAR_Cell(int value) {
		this.value = value;
		this.next = null;
	}
}
