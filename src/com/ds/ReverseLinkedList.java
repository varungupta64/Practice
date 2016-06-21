package com.ds;

import com.ds.LinkedListCustom.Node;

public class ReverseLinkedList {

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
		
		reverseList(list);
		
		System.out.println("List after reversing : ");
		printLinkedList(list);

	}

	private static void reverseList(LinkedListCustom list) {
		Node n = list.head;
		Node prev = null;
		Node next = null;
		while(n!=null){
			next = n.next;
			n.next = prev;
			
			prev = n;
			n = next;
		}
		list.head = prev;
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
