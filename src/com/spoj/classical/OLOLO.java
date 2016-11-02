package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OLOLO {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		int num;
		num = Integer.parseInt(bf.readLine().trim());
		for(int i=1;i<n;i++){
			num ^= Integer.parseInt(bf.readLine().trim());
		}
		System.out.println(num);
	}
}
