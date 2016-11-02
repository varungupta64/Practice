package com.cf.round371div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class C_SonyaAndQueries {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		long num;
		Long result;
		long key;

		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			num = Long.parseLong(input[1]);
			key = getKey(input[1].toCharArray());
			switch (input[0]) {
			case "+":
				result = map.get(key);
				if (result == null) {
					result = 0l;
				}
				map.put(key, result + 1);
				break;
			case "-":
				map.put(key, map.get(key) - 1);
				break;
			case "?":
				result = map.get(key);
				if (result == null) {
					result = 0l;
				}
				System.out.println(result);
				break;
			}
		}

	}

	public static long getKey(char[] value) {
		StringBuffer result = new StringBuffer();
		byte b;
		for (char c : value) {
			b = (byte) Character.getNumericValue(c);
			if (b % 2 == 0) {
				result.append("0");
			} else {
				result.append("1");
			}
		}

		return Long.parseLong(result.toString());
	}

}
