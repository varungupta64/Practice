package com.codechef.JulyCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CHEFIHG {

	private static String[] map;
	private static int n;
	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n];
		for (int i = 0; i < n; ++i) {
			map[i] = br.readLine();
		}
		List<String> results = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i].charAt(j) == '.') {
					String res = bfs(i, j);
					debug(i, j, res);
					results.add(res);
				}
			}
		}
		Collections.sort(results, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -Integer.compare(o1.length(), o2.length());
			}
		});
		String cmd = results.stream().collect(Collectors.joining("")).toString();
		pw.println(cmd);
		pw.flush();
	}

	private static String bfs(int i, int j) {
		boolean[][] seen = new boolean[n][m];
		LinkedList<P> q = new LinkedList<P>();
		q.add(new P(i, j, ""));
		while (!q.isEmpty()) {
			P v = q.pollFirst();
			if (seen[v.x][v.y])
				continue;
			seen[v.x][v.y] = true;
			if (map[v.x].charAt(v.y) == 'C') {
				return v.path.toString();
			}
			if (map[v.x].charAt(v.y) == '*')
				continue;
			if (v.x > 0) {
				q.add(new P(v.x - 1, v.y, v.path.toString() + "U"));
			}
			if (v.x < n - 1) {
				q.add(new P(v.x + 1, v.y, v.path.toString() + "D"));
			}
			if (v.y > 0) {
				q.add(new P(v.x, v.y - 1, v.path.toString() + "L"));
			}
			if (v.x < m - 1) {
				q.add(new P(v.x, v.y + 1, v.path.toString() + "R"));
			}
		}
		return "error";
	}

	private static final class P {
		int x, y;
		StringBuilder path = new StringBuilder();

		public P(int x, int y, String cmd) {
			this.x = x;
			this.y = y;
			path.append(cmd);
		}
	}

	public static void debug(Object... args) {
		// System.out.println(Arrays.deepToString(args));
	}
}
