package com.five.day;

public class EditDistance_DP {
	public static void main(String[] args) {
		String one = "sunday";
		String two = "tuesday";

		int m = one.length();
		int n = two.length();

		int[][] result = new int[m+1][n+1];
		
		System.out.println(ed(one.toCharArray(), two.toCharArray(), m, n, result));
	}

	private static int ed(char[] one, char[] two, int m, int n, int[][] result) {
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0){
					result[i][j] = j;
				}else if(j == 0){
					result[i][j] = i;
				}else if(one[i-1] == two[j-1]){
					result[i][j] = result[i-1][j-1];
				}else{
					result[i][j] = 1 + min(result[i-1][j],min(result[i-1][j-1],result[i][j-1]));
				}
				
				
			}
		}
		return result[m][n];
	}

	private static int min(int i, int j) {
		return i<j?i:j;
	}
}
