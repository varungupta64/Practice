package com.cf.round386div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		bf.close();
	}
}