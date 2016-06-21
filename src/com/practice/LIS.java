package com.practice;

public class LIS {
	public static void main(String[] args) {
		int lis = 1;
		int intermediateLis = 1;
		int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
		
		for(int i=0;i<arr.length-1;i++){
				if(arr[i+1]>arr[i]){
					intermediateLis++;
				}else{
					intermediateLis=1;
				}
				
				if(intermediateLis>lis){
					lis = intermediateLis;
				}
		}
		
		System.out.println(lis);
	}
}
