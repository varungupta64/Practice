package com.cf.round384div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int a = Integer.parseInt(input[1]);
		int b = Integer.parseInt(input[2]);
		
		String s = bf.readLine().trim();
		if(s.charAt(a-1) == s.charAt(b-1)){
			System.out.println("0");
		}else{
			System.out.println("1");
		}
		
		bf.close();
	}
}
