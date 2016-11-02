package com.codechef.JulyCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFCBA {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		int d = Integer.parseInt(input[3]);
		
		if(a*b == c*d || a*c == b*d || a*d == b*c){
			System.out.println("Possible");
		}else{
			System.out.println("Impossible");
		}
		bf.close();
	}
}
