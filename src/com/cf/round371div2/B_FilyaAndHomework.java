package com.cf.round371div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class B_FilyaAndHomework {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(input[i]));
		}

		if (set.size() > 3) {
			System.out.println("NO");
		} else if (set.size() <= 2) {
			System.out.println("YES");
		} else {

			List<Integer> list = new ArrayList<Integer>();
			list.addAll(set);

			Collections.sort(list);
			
			if((list.get(1) - list.get(0)) == (list.get(2) - list.get(1))){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}

}
