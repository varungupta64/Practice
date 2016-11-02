package com.codechef.AprilLunchTime16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRICOIN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for(int i=0;i<t;i++){
			long n = Long.parseLong(bf.readLine().trim());
			long d = (long)Math.floor(Math.sqrt(1+4*2*n));
			long r1 = (-1 + d)/2;
			
			System.out.println(r1);
		}
		
	}

}
