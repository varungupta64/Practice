package com.five.day;

public class MinJumpsToEnd_DP {
	static int dest;

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		dest = arr.length - 1;
		System.out.println(minJumps(arr));
	}

	private static int minJumps(int[] arr) {
		int[] jump = new int[arr.length];
		jump[0] = 1;
		int min = Integer.MIN_VALUE;
		
		for(int i=1;i<arr.length;i++){
			for(int j=i;j<i+arr[i];j++){
				if(i+arr[]){
					
				}
			}
		}
		
		return 0;
	}

}
