package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class ONP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		char[] arr;
		Stack s;

		for (int i = 0; i < t; i++) {
			arr = bf.readLine().trim().toCharArray();
			s = new Stack();

			for (int j = 0; j < arr.length; j++) {
				s.push(arr[j]);
			}
			bw.write(s.expression.toString());
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}

class Stack {
	LinkedList<Node> stack;
	Node top;
	Node temp;
	StringBuffer expression;

	public Stack() {
		stack = new LinkedList<>();
		this.top = null;
		expression = new StringBuffer("");
	}

	public void push(Character c) {
		Node n = new Node(c);

		if (n.priority == 0) {
			expression.append(c);
			return;
		}

		if (null != top) {

			if (n.priority == 1) {

				while (top.priority != 2) {
					expression.append(top.value);
					top = top.next;
				}
				top = top.next;
				return;

			}

			if (n.priority == 2) {

				temp = top;
				n.next = temp;
				top = n;
				return;

			}

			if (top.priority > n.priority) {

				n.next = top.next;
				temp = top;
				top = n;
				expression.append(temp.value);
				return;

			} else {

				temp = top;
				n.next = temp;
				top = n;
				return;

			}

		} else {

			top = n;

		}
	}
}

class Node {
	Character value;
	Node next;
	int priority;

	public Node(Character value) {
		this.value = value;
		priority = getPriority(value);
		this.next = null;
	}

	private static int getPriority(Character c) {
		switch (c) {
		case ')':
			return 1;
		case '^':
			return 7;
		case '/':
			return 6;
		case '*':
			return 5;
		case '-':
			return 4;
		case '+':
			return 3;
		case '(':
			return 2;
		}
		return 0;
	}
}