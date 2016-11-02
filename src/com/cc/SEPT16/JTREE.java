package com.cc.SEPT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JTREE {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int num, cost, validity, q;

		CityGraph g = new CityGraph(n);
		for (int i = 0; i < n - 1; i++) {
			g.addEdge(bf.readLine().trim().split(" "));
		}

		for (int i = 0; i < m; i++) {
			input = bf.readLine().trim().split(" ");
			num = Integer.parseInt(input[0]);
			validity = Integer.parseInt(input[1]);
			cost = Integer.parseInt(input[2]);
			g.cities[num].addTicket(cost, validity);
		}

		q = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < q; i++) {
			num = Integer.parseInt(bf.readLine().trim());
			bw.write("" + g.traverseGraph(num));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}

class CityGraph {
	LinkedList<Integer>[] adj;
	City[] cities;

	public CityGraph(int n) {
		adj = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new LinkedList<Integer>();
		}

		cities = new City[n + 1];
		for (int i = 1; i <= n; i++) {
			cities[i] = new City();
		}
	}

	public int traverseGraph(int num) {
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < cities[num].tickets.size(); i++) {
			result = Integer.min(result,
					dfs(num, num, cities[num].tickets.get(i).cost, cities[num].tickets.get(i).validity));
		}
		return result;
	}

	private int dfs(int city, int src, int cost, int validity) {
		if (city == 1) {
			return cost;
		}

		int result = Integer.MAX_VALUE;
		int num = adj[city].get(0);

		if (validity != 0) {
			result = Integer.min(result, dfs(num, src, cost, validity - 1));
		}

		if (src != city) {
			for (int i = 0; i < cities[city].tickets.size(); i++) {
				result = Integer.min(result,
						dfs(num, src, cost + cities[city].tickets.get(i).cost, cities[city].tickets.get(i).validity));
			}
		}

		return result;
	}

	public void addEdge(String[] arr) {
		adj[Integer.parseInt(arr[0])].add(Integer.parseInt(arr[1]));
	}
}

class City {
	List<Ticket> tickets;

	public City() {
		this.tickets = new ArrayList<>();
	}

	public void addTicket(int cost, int validity) {
		tickets.add(new Ticket(cost, validity));
	}
}

class Ticket {
	int cost;
	int validity;

	public Ticket(int cost, int validity) {
		this.cost = cost;
		this.validity = validity;
	}
}