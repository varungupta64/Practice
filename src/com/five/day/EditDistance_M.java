package com.five.day;

public class EditDistance_M {
	public static void main(String[] args) {
		String one = "sunday";
		String two = "saturday";

		int m = one.length();
		int n = two.length();

		int[][] result = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				result[i][j] = -1;
			}
		}
		System.out.println(ed(one.toCharArray(), two.toCharArray(), m, n, result));
	}

	private static int ed(char[] one, char[] two, int m, int n, int[][] result) {
		if(result[m][n]<0){
			if(m==0 || n == 0){
				result[m][n] = max(m,n);
			}else if(one[m-1]==two[n-1]){
				result[m][n] = ed(one, two, m-1, n-1, result);
			}else{
				result[m][n] = 1+min(ed(one, two, m-1, n-1, result),min(ed(one, two, m, n-1, result),ed(one, two, m-1, n, result)));
			}
		}
		return result[m][n];
	}

	private static int min(int ed1, int ed2) {
		return ed1<ed2?ed1:ed2;
	}

	private static int max(int m, int n) {
		return m>n?m:n;
	}
}
