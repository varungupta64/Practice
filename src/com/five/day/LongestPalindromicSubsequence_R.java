package com.five.day;

public class LongestPalindromicSubsequence_R {

	public static void main(String[] args) {
		String input = "BBABCBCAB";
		System.out.println(lps(input.toCharArray(),0,input.length()-1));
	}

	private static int lps(char[] arr, int start, int end) {
		if(start==end){
			return 1;
		}
		if(start>end){
			return 0;
		}
		
		if(arr[start]==arr[end]){
			return 2+lps(arr,start+1,end-1);
		}else{
			return Integer.max(lps(arr,start+1,end), lps(arr,start,end-1));
		}
	}

}
