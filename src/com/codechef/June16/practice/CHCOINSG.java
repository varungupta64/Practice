package com.codechef.June16.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHCOINSG {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine().trim());

			if(n%6==0){
				System.out.println("Misha");
			}else{
				System.out.println("Chef");
			}
		}
	}

}
