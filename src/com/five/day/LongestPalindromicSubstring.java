package com.five.day;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		char[] a = "forgeekskeegrof".toCharArray();
		System.out.println(longestPalindromeSubstring(a, 0, a.length - 1));
	}

	private static int longestPalindromeSubstring(char[] a, int start, int len) {
		int result = 1;
		int n = len;
		boolean isPalindromeFound = false;
		
		for(int j=0;j<=len-1;j++){
			for(int k=0;k<=j;k++){
				if (isPalindrome(a, k, k + n - j)) {
					result = n - j + 1;
					isPalindromeFound = true;
					break;
				}
			}
			if(isPalindromeFound){
				break;
			}
		}
		
		return result;
	}

	private static boolean isPalindrome(char[] a, int start, int end) {
		if (start >= end) {
			return true;
		}

		if (a[start] == a[end]) {
			return isPalindrome(a, start + 1, end - 1);
		}else{
			return false;
		}
	}

}
