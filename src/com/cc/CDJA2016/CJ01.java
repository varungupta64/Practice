package com.cc.CDJA2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class CJ01 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int n, q;
		long ele;
		HashMap<Long, Integer> map;
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			q = Integer.parseInt(input[1]);
			map = new HashMap<Long, Integer>(n + q);

			input = bf.readLine().trim().split(" ");

			for (int j = 0; j < n; j++) {
				ele = Long.parseLong(input[j]);
				map.put(ele, 1);
			}

			input = bf.readLine().trim().split(" ");

			for (int j = 0; j < q; j++) {
				ele = Long.parseLong(input[j]);
				if (map.containsKey(ele)) {
					bw.write("YES");
				} else {
					map.put(ele, 1);
					bw.write("NO");
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
