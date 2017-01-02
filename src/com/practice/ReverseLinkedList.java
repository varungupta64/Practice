package com.practice;

public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedList_ReverseLinkedList list = new LinkedList_ReverseLinkedList();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		list.displayList();
		list.reverse();
		list.displayList();
	}
}

class LinkedList_ReverseLinkedList {
	Node_ReverseLinkedList head;

	public void add(int data) {
		if (head == null) {
			head = new Node_ReverseLinkedList(data);
		} else {
			Node_ReverseLinkedList temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node_ReverseLinkedList(data);
		}
	}

	public void reverse() {
		if (head == null) {
			return;
		}
		Node_ReverseLinkedList curr = head;
		reverseUtil(head.next, head);
		curr.next = null;
	}

	private void reverseUtil(Node_ReverseLinkedList current, Node_ReverseLinkedList prev) {
		if (current == null) {
			return;
		} else if (current.next == null) {
			head = current;
			head.next = prev;
			return;
		} else {
			reverseUtil(current.next, current);
			current.next = prev;
			return;
		}
	}

	public void displayList() {
		Node_ReverseLinkedList temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
		System.out.println("");
	}
}

class Node_ReverseLinkedList {
	int data;
	Node_ReverseLinkedList next;

	public Node_ReverseLinkedList(int data) {
		this.data = data;
	}
}