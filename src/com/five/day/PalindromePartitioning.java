package com.five.day;

public class PalindromePartitioning {

	static int maxHere = 1;
	
	public static void main(String[] args) {
		char[] s = "ababbbabbababa".toCharArray();
		int start = 0;
		int end = s.length - 1;
		System.out.println(palindromePartitioning(s, start, end));
	}

	private static int palindromePartitioning(char[] s, int start, int end) {
		if (start == end) {
			return 0;
		}

		if(isPalindrome(s,start,end)){
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int res;
		
		for(int k=start;k<end;k++){
			res = palindromePartitioning(s, start, k)+1+palindromePartitioning(s, k+1, end);
			if(res<min){
				min = res;
			}
		}

		return min;
	}
	
	private static boolean isPalindrome(char[] s, int start, int end) {
		if(start==end){
			return true;
		}
		if(start>end){
			return true;
		}
		if(s[start] == s[end]){
			return isPalindrome(s, start+1, end-1);
		}
		return false;
	}

}
