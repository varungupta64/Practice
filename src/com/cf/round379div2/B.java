package com.cf.round379div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int k2 = Integer.parseInt(input[0]);
		int k3 = Integer.parseInt(input[1]);
		int k5 = Integer.parseInt(input[2]);
		int k6 = Integer.parseInt(input[3]);
		
		int k256 = Integer.min(k2,Integer.min(k5, k6));
		k2 = k2 - k256;
		if(k2 < 0){
			k2 = 0;
		}
		int k32 = Integer.min(k2, k3);
		
		int result = 256 * k256 + 32 * k32;
		
		System.out.println(result);
	}
}
