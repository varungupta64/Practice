package com.just.demo;

public class CustomLinkedList {
	Node head;
	
	//insert a new node in front
	public void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
}
