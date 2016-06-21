package com.five.day;

public class LCS_R {

	public static void main(String[] args) {
		String one = "ABCDEFGH";
		String two = "ABABEFGH";

		System.out.println(lcs(one.toCharArray(), two.toCharArray(), one.length(), two.length()));

	}

	private static int lcs(char[] one, char[] two, int m, int n) {
		if(m==0 || n==0){
			return 0;
		}else if(one[m-1] == two[n-1]){
			return 1 + lcs(one,two,m-1,n-1);
		}else{
			return max(lcs(one,two,m-1,n),lcs(one,two,m,n-1));
		}
	}

	private static int max(int lcs1, int lcs2) {
		return lcs1>lcs2?lcs1:lcs2;
	}
}
