package com.ds;

public class LinkedListCustom {
	Node head;	

	static class Node {
		Node next;
		int data;

		public Node(int d){
			this.data = d;
		}
		
		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}
}
