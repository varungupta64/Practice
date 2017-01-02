package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class SBANK_ed {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		TreeMap<String, Integer> count;
		Integer c;
		String s;
		while (t-- > 0) {
			n = Integer.parseInt(bf.readLine().trim());
			count = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				s = bf.readLine().trim();
				if ((c = count.get(s)) == null) {
					count.put(s, 1);
				} else {
					count.put(s, c+1);
				}
			}
			for (Map.Entry<String, Integer> map : count.entrySet()) {
				bw.write(map.getKey() + " " + map.getValue());
				bw.newLine();
			}
			bw.newLine();
			bf.readLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}