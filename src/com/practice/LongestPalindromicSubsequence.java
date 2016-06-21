package com.practice;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String input = "BNMBABCBABMNC";
		System.out.println("Sol : "+lps(input,0,input.length()-1));
	}

	private static int lps(String input, int l, int r) {
		if(l==r){
			return 1;
		}
		if(input.charAt(l)==input.charAt(r)){
			return 2+lps(input,l+1,r-1);
		}else{
			return max(lps(input,l+1,r),lps(input,l,r-1));
		}
	}

	private static int max(int lps1, int lps2) {
		return (lps1>lps2?lps1:lps2);
	}
}