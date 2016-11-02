package com.ds;

public class SortedStack {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(4);
		s.push(2);
		s.push(1);
		s.push(3);
		s.push(5);
		s.printStack();
		
		System.out.println("After reversing list : ");
		s.reverseStack();
		s.printStack();
	}
}

class Stack{
	Node top;
	
	public Stack(){
		
	}
	
	public Stack(int data){
		top = new Node(data);
	}
	
	public void push(int data){
		if(null == top){
			top = new Node(data);
		}else{
			Node n = new Node(data);
			Node temp = top;
			n.next = temp;
			top = n;
		}
	}
	
	public void pop() throws Exception{
		if(null == top){
			throw new Exception("Undeflow");
		}else{
			top = top.next;
		}
	}
	
	public boolean isEmpty(){
		if(top==null){
			return true;
		}
		return false;
	}
	
	public void reverseStack(){
		if(top!=null){
			Node n = top;
			top = top.next;
			reverseStack();
			insertAtBottomOfStack(n);
		}
	}
	
	public void insertAtBottomOfStack(Node n) {
		if(top==null){
			top = n;
			top.next = null;
		}else{
			Node a = top;
			while(a.next!=null){
				a = a.next;
			}
			n.next = null;
			a.next = n;
		}
	}

	public void printStack(){
		if(top==null){
			System.out.println("Empty");
		}else{
			Node n = top;
			while(n!=null){
				System.out.println(n.data);
				n=n.next;
			}
		}
	}
}

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
