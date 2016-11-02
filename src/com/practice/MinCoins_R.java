package com.practice;

public class MinCoins_R {

	public static void main(String[] args) {
		int sum = 12;
		int[] coin = {1,3,5};
		
		System.out.println(minCoins(sum,coin));
	}

	private static int minCoins(int sum, int[] coin) {
		if(sum == 0){
			return 0;
		}
		
		if(sum<0){
			return 10000;
		}
		
		int x = 1+minCoins(sum - coin[0],coin);
		int y = 1+minCoins(sum - coin[1],coin);
		int z = 1+minCoins(sum - coin[2],coin);
		
		return min(z,min(x,y));
	}

	private static int min(int x, int y) {
		return x<y?x:y;
	}

}
