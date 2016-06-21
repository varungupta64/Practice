package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n1 = Integer.parseInt(input[0]);
		int n2 = Integer.parseInt(input[1]);
		
		System.out.println(gcd(n1,n2));
	}
	
	public static int gcd(int n1,int n2){
		if(n1 == 0){
			return n2;
		}else if(n2 == 0){
			return n1;
		}else if(n1 == n2){
			return n1;
		}else if(n1 > n2){
			return gcd(n1-n2,n2);
		}else{
			return gcd(n1,n2-n1);
		}
	}
}
