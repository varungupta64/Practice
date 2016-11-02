package com.practice;

import java.util.Arrays;

public class MinCoins {

	public static void main(String[] args) {
		int sum = 12;
		int[] coin = {1,3,5};
		
		int[] coinForSum = new int[sum+1];
		Arrays.fill(coinForSum, Integer.MAX_VALUE);
		coinForSum[0] = 0;
		
		for(int i=1;i<=sum;i++){
			for(int j=0;j<coin.length;j++){
				if((coin[j]<=i)  && ((coinForSum[i-coin[j]]+1)<coinForSum[i])){
					coinForSum[i] = coinForSum[i-coin[j]]+1;
				}
			}
		}
		
		System.out.println(coinForSum[sum]);
	}

}
