package com.codechef.June16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class DEVARRAY {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input1[0]);
		int q = Integer.parseInt(input1[1]);
		
		String[] a = bf.readLine().trim().split(" ");
		int[] arr = new int[n];
		for(int j=0;j<n;j++){
			arr[j] = Integer.parseInt(a[j]);
		}
		
		Arrays.sort(arr);
		
		int low = arr[0];
		int high = arr[n-1];
		
		for(int i=0;i<q;i++){
			long t = Long.parseLong(bf.readLine().trim());
			if(t>=low && t<=high){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
	
	static void print(String[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
