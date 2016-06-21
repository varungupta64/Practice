package com.ds;

import com.ds.LinkedListCustom.Node;

public class SwappingNodesLinkedList {

	public static void main(String[] args) {
		LinkedListCustom list = new LinkedListCustom();
		list.head = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);

		list.head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		printLinkedList(list);
		swapElements(list, 1, 4);

		System.out.println("List after swapping is : ");
		printLinkedList(list);
	}

	private static void swapElements(LinkedListCustom list, int one, int two) {
		Node onePrev = null;
		Node twoPrev = null;
		Node oneNext = null;
		Node twoNext = null;
		Node prev = null;
		Node temp = null;

		Node n = list.head;
		while (n != null) {
			if (one == n.data) {
				oneNext = n;
				onePrev = prev;
			} else if (two == n.data) {
				twoNext = n;
				twoPrev = prev;
			}

			prev = n;
			n = n.next;
		}
		temp = twoNext.next;
		onePrev.next = twoNext;
		twoNext.next = oneNext.next;
		twoPrev.next = oneNext;
		oneNext.next = temp;
		
	}

	private static void printLinkedList(LinkedListCustom list) {
		Node n = list.head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

}
