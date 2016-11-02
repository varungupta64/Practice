package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nagarro
 *
 *	Que interpretation wrong.
 */
public class WORKCHEF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(bf.readLine().trim());
		
		for(int i=0;i<q;i++){
			
			String[] input = bf.readLine().trim().split(" ");
			int l = Integer.parseInt(input[0]);
			int r = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);
			
			System.out.println(specialNumbers(l,r,k));
		}
	}

	private static int specialNumbers(int l, int r, int k) {
		int result = 0;
		
		for(int i=l;i<=r;i++){
			result+=isSpecialNum(i,k);
		}
		
		return result;
	}

	private static int isSpecialNum(int i, int k) {
		String num = String.valueOf(i);
		if(num.length()<k){
			return 0;
		}
		
		int div = Character.getNumericValue(num.charAt(k-1));
		
		if(div==0){
			return 0;
		}
		
		if(i%div==0){
			return 1;
		}
		
		return 0;
	}

}
