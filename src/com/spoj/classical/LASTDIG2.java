package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LASTDIG2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			if(Long.parseLong(input[1]) == 0){
				System.out.println("1");
			}else{
				System.out.println(((int) Math.pow(Character.getNumericValue(input[0].charAt(input[0].length() - 1)),
						(Long.parseLong(input[1]) % 4) == 0 ? 4 : Long.parseLong(input[1]) % 4)) % 10);
			}
		}
	}
}
