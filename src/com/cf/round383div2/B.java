package com.cf.round383div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		long count = 0;
		input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int x = Integer.parseInt(input[1]);

		input = bf.readLine().trim().split(" ");
		Map<Integer, Integer> map = new HashMap<>();
		int num;
		Integer c;
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(input[i]);
			if ((c = map.get(num)) != null) {
				map.put(num, c + 1);
			} else {
				map.put(num, 1);
			}
		}

		Integer ele;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if ((ele = map.get(entry.getKey() ^ x)) != null) {
				count += (long) ele * (long) entry.getValue();
			}
		}

		System.out.println(count / 2);
	}
}
