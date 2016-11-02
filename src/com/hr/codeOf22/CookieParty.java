package com.hr.codeOf22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookieParty {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int result = 0;

		if (n > m) {
			result = n - m;
		}else if(m > n){
			while(m > n){
				m -= n;
			}
			result = n - m;
		}
		
		System.out.println(result);

	}

}
