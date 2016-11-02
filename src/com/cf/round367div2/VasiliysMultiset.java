package com.cf.round367div2;

public class VasiliysMultiset {

	public static void main(String[] args) {
		Trie tr = new Trie();
		tr.insert(8);
		tr.insert(9);
		tr.insert(10);
		tr.insert(12);
		tr.delete(12);
		tr.xor(7);
		System.out.println(tr);
	}

}

class Trie {
	private TrieNode root;

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

	public Trie() {
		root = new TrieNode('0');
		root.setEnd(true);
		root.setCount(1);
	}

	public String xor(int num) {
		String s = new StringBuilder(Integer.toBinaryString(num)).toString();
		char[] binary = s.toCharArray();
		return xorUtil(binary, this.root);
	}

	public String xorUtil(char[] arr, TrieNode node) {
		String s = "";
		int eleIndex;
		int count = 0;
		while (count < arr.length) {
			eleIndex = arr[count++] - '0';
			if (eleIndex == 0) {
				if (node.getList()[1] != null) {
					eleIndex = 1;
				}
			} else {
				if (node.getList()[0] != null) {
					eleIndex = 0;
				}
			}
			
			
		}
		return null;
	}

	public void insert(int num) {
		String s = new StringBuilder(Integer.toBinaryString(num)).toString();
		char[] binary = s.toCharArray();
		root.setCount(root.getCount() + 1);
		TrieNode ele = root;
		int inter;
		for (int i = 0; i < binary.length; i++) {
			inter = binary[i] - '0';
			if (ele.getList()[inter] == null) {
				TrieNode node = new TrieNode(binary[i]);
				node.setCount(1);
				ele.getList()[inter] = node;
				ele = node;
			} else {
				ele = ele.getList()[inter];
				ele.setCount(ele.getCount() + 1);
			}
		}
		ele.setEnd(true);
	}

	public void delete(int num) {
		String s = new StringBuilder(Integer.toBinaryString(num)).toString();
		char[] binary = s.toCharArray();
		this.root.setCount(this.root.getCount() - 1);
		deleteUtil(binary, 0, binary.length, this.root);
	}

	public void deleteUtil(char[] arr, int index, int length, TrieNode node) {
		if (index >= length) {
			return;
		}

		int eleIndex = arr[index] - '0';

		if (node.getList()[eleIndex] == null) {
			return;
		}

		if (node.getList()[eleIndex].getCount() > 1) {
			node.getList()[eleIndex].setCount(node.getList()[eleIndex].getCount() - 1);
		} else {
			node.getList()[eleIndex] = null;
			return;
		}

		deleteUtil(arr, index + 1, length, node.getList()[eleIndex]);
	}
}

class TrieNode {
	private char value;
	private TrieNode[] list;
	private boolean isEnd;
	private int count;

	public TrieNode(char value) {
		this.value = value;
		list = new TrieNode[2];
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public TrieNode[] getList() {
		return list;
	}

	public void setList(TrieNode[] list) {
		this.list = list;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
