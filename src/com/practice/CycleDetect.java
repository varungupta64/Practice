package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
 */
public class CycleDetect {
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (isGraphCyclic(graph)) {
			System.out.println("Cyclic");
		} else {
			System.out.println("Not cyclic");
		}
	}

	private static boolean isGraphCyclic(Graph graph) {
		HashSet<Integer> whiteSet = new HashSet<>();
		HashSet<Integer> graySet = new HashSet<>();
		HashSet<Integer> blackSet = new HashSet<>();

		// adding all graph vertices to white set initially
		for (int i = 0; i < graph.getSize(); i++) {
			whiteSet.add(i);
		}
		
		//TODO

		return false;
	}
}

class Graph {
	private int size;
	private List<Vertex> vertices = new ArrayList<>();

	public Graph() {
		size = 0;
	}

	public Graph(int n) {
		size = n;
		for (int i = 0; i < size; i++) {
			vertices.add(new Vertex(i));
		}
	}

	public void addVertex() {
		vertices.add(new Vertex(size++));
	}

	public void addEdge(int src, int dest) {
		vertices.get(src).addEdge(dest);
	}

	public int getSize() {
		return size;
	}
}

class Vertex {
	private int name;
	private List<Integer> edges = new ArrayList<>();

	public Vertex(int name) {
		this.name = name;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public List<Integer> getEdges() {
		return edges;
	}

	public void setEdges(List<Integer> edges) {
		this.edges = edges;
	}

	public void addEdge(int dest) {
		if (getEdges().contains(dest)) {
			System.out.println("Edge already present");
		} else {
			getEdges().add(dest);
			System.out.println("Edge added");
		}
	}
}