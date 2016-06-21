package com.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestCommonSubsequence_Recursive {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String i1 = "AGGTAB";
		String i2 = "GXTXAYB";
		
		System.out.println(lcs(i1,i2));
	}

	private static int lcs(String i1, String i2) {
		int l1 = i1.length();
		int l2 = i2.length();
		
		if(l1==0 || l2==0){
			return 0;
		}
		
		if(i1.charAt(l1-1) == i2.charAt(l2-1)){
			return 1+lcs(i1.substring(0, l1-1),i2.substring(0, l2-1));
		}else{
			return max(lcs(i1.substring(0, l1-1),i2),lcs(i1,i2.substring(0, l2-1)));
		}
	}

	private static int max(int lcs, int lcs2) {
		int max = lcs;
		if(lcs2 > lcs){
			max = lcs2;
		}
		return max;
	}
}
