package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CHEFSOC2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(bf.readLine().trim());
		for (int i = 0; i < testCaseNum; i++) {
			String[] input = bf.readLine().trim().split(" ");
			long n = Long.parseLong(input[0]);
			long m = Long.parseLong(input[1]);
			long s = Long.parseLong(input[2]);

			String[] passArr = bf.readLine().trim().split(" ");
			LinkedList<Long> list = new LinkedList<Long>();
			Map<Long, Long> resMap = new HashMap<Long, Long>((int) n);
			list.add(s);

			int counter = 0;
			while (!list.isEmpty()) {
				int size = list.size();
				int j = 0;
				int len = passArr.length;
				if (counter < len) {
					while (j < size) {
						long ele = list.poll();
						long passStrength = Long.parseLong(passArr[counter]);
						if (ele != 1 && ele - passStrength >= 1) {
							long low = ele - passStrength;
							list.add(low);
						}
						if (ele != n && ele + passStrength <= n) {
							long high = ele + passStrength;
							list.add(high);
						}
						j++;
					}
					counter++;
				} else {
					break;
				}
			}

			for (int k = 1; k <= list.size(); k++) {
				long ele = list.get(k-1);
				if (resMap.containsKey(ele)) {
					resMap.put(ele, resMap.get(ele) + 1);
				} else {
					resMap.put(ele, 1L);
				}
			}

			for (long k = 1; k <= n; k++) {
				System.out.print((null != resMap.get(k) ? resMap.get(k) : 0) + " ");
			}
			System.out.println("");
		}
	}

}
