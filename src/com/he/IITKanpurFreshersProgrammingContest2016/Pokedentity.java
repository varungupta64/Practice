package com.he.IITKanpurFreshersProgrammingContest2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pokedentity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < n; i++) {

		}

	}

}

class LinkedList {
	Node head;

	public LinkedList() {

	}

	public void add(char val) {
		if (head == null) {
			head = new Node(val);
		} else {
			Node next = head;
			Node current = head.prev;
			while (next != null ) {
				current = next;
				next = next.next;
			}

			Node n = new Node(val);
			current.next = n;
			n.prev = current;
		}

	}
}

class Node {
	char val;
	Node next;
	Node prev;

	public Node(char val) {
		this.val = val;
	}
}
