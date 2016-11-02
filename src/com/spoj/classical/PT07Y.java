package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class PT07Y {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input;

		input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		PT07Y_Graph graph = new PT07Y_Graph(n);

		for (int i = 0; i < m; i++) {
			graph.addEdge(bf.readLine().trim().split(" "));
		}

		if (graph.isConnected()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}

class PT07Y_Graph {
	int v;
	LinkedList<Integer>[] adj;

	public PT07Y_Graph(int v) {
		this.v = v;
		adj = new LinkedList[v + 1];
		for (int i = 1; i <= v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public boolean isConnected() {
		boolean[] isVisited = new boolean[v + 1];
		boolean isCyclic = false;
		boolean isConnected = true;
		Stack<Integer> stack = new Stack<Integer>();
		int ele;
		isVisited[1] = true;
		for (int i = 0; i < adj[1].size(); i++) {
			stack.push(adj[1].get(i));
		}

		while (!stack.isEmpty()) {
			ele = stack.pop();
			isVisited[ele] = true;
			for (int i = 0; i < adj[ele].size(); i++) {
				if(isVisited[adj[ele].get(i)]){
					isCyclic = true;
					break;
				}else{
					stack.push(adj[ele].get(i));
				}
			}
			if(isCyclic){
				return false;
			}
		}
		
		for(int i=1;i<=v;i++){
			if(!isVisited[i]){
				isConnected = false;
				break;
			}
		}
		return isConnected;
	}

	public void addEdge(String[] input) {
		adj[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
	}
}