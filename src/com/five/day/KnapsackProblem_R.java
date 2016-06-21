package com.five.day;

public class KnapsackProblem_R {

	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {30,20,50};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(int w, int[] wt, int[] val, int n) {
		if(w==0 || n==0){
			return 0;
		}
		
		if(wt[n-1]>w){
			return knapSack(w, wt, val, n-1);
		}
		
		 return max(val[n-1]+knapSack(w-wt[n-1], wt, val, n-1),knapSack(w, wt, val, n-1));
	}

	private static int max(int i, int j) {
		return i>j?i:j;
	}

}
