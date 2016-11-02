package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WILLITST {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bf.readLine().trim());
		
		if(n<=0){
			System.out.println("TAK");
		}else{
			
			if((n & -n)==n){
				System.out.println("TAK");
			}else{
				System.out.println("NIE");
			}
			
		}

	}

}
