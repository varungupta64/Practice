package com.five.day;

public class EggDroppingPuzzle {
	public static void main(String[] args) {
		int n = 2;
		int k = 10;
		
		System.out.println(eggDrops(n,k));
	}

	private static int eggDrops(int n, int k) {
		if(k==0 || k==1){
			return k;
		}
		
		if(n==1){
			return k;
		}
		
		int min = Integer.MAX_VALUE;
		int res;
		int x;
		
		for(x=1;x<=k;x++){
			res = max(eggDrops(n-1, x-1),eggDrops(n, k-x));
			if(res<min){
				min = res;
			}
		}
		return min+1;
	}

	private static int max(int i, int j) {
		return i>j?i:j;
	}
}
