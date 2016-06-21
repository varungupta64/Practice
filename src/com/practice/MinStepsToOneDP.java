package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinStepsToOneDP {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter input : ");
		try {
			int n = Integer.parseInt(bf.readLine());
			list.add(0, 0);
			list.add(1, 0);

			for (int i = 2; i <= n; i++) {
				list.add(i, list.get(i - 1) + 1);
				if (i % 2 == 0) {
					list.add(i,min(1 + list.get(i/2), list.get(i)));
				}
				if (i % 3 == 0) {
					list.add(i,min(1 + list.get(i / 3), list.get(i)));
				}
			}
			
			System.out.println("Solution : "+list.get(n));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int min(int n1, int n2) {
		int min = n1;
		if (n2 < n1) {
			return n2;
		}
		return n1;
	}
}
