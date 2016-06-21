package com.five.day;

public class KnapsackProblem_M {

	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {30,20,50};
	    int  W = 50;
	    int n = val.length;
	    int[][] result = new int[n+1][n+1];
	    System.out.println(knapSack(W, wt, val, n,result));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n, int[][] result) {
		if(w==0 || n==0){
			
		}
		return 0;
	}

}
