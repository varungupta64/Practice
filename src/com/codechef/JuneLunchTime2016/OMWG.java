package com.codechef.JuneLunchTime2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OMWG {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			String arr[] = bf.readLine().trim().split(" ");
			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);

			int result = -1;
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if(j==0 || k==0){
						result+=1;
					}else{
						result+=2;
					}
				}
			}
			
			System.out.println(result);
		}

	}
}
