package com.codechef.JuneLunchTime2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCOLLIS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int i=0;i<t;i++){
			
			
			String arr[] = bf.readLine().trim().split(" ");
			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			
			int result = 0;
			
			for(int j=0;j<n;j++){
				
				result += Integer.parseInt(bf.readLine().trim());
				
			}
			
			String op = String.valueOf(result);
			
			int count = 0;
			
			for(int k=0;k<op.length();k++){
				
				count += calculateCollissions(Character.getNumericValue(op.charAt(k)));
				
			}
			
			System.out.println(count);
			
		}
		
	}

	private static int calculateCollissions(int num) {
		if(num>1){
			return (num*(num-1))/2;
		}
		return 0;
	}
}
