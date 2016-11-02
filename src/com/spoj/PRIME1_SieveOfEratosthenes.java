package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PRIME1_SieveOfEratosthenes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int[][] inpArr = new int[t][2];
		int max = 0;
		String[] test;
		for(int i=0;i<t;i++){
			test = bf.readLine().trim().split(" ");
			inpArr[i][0] = Integer.parseInt(test[0]);
			inpArr[i][1] = Integer.parseInt(test[1]);
			
			if(inpArr[i][1]>max){
				max = inpArr[i][1];
			}
		}
		
		boolean[] arr = SieveOfEratosthenes(max);
		
		for(int i=0;i<t;i++){
			printArray(arr,inpArr[i][0],inpArr[i][1]);
			
			if(i!=t-1){
				System.out.println("");
			}
		}
	}

	private static void printArray(boolean[] arr, int start, int end) {
		for(int i=start;i<=end;i++){
			if(arr[i]){
				System.out.println(i);
			}
		}
	}

	private static boolean[] SieveOfEratosthenes(int n) {
		boolean[] arr = new boolean[n+1];
		arr[0] = false;
		arr[1] = false;
		for(int i=2;i<=n;i++){
			arr[i] = true;
		}
		
		for(int i=2;i*i<=n;i++){
			if(arr[i]==true){
				for(int j=i*2;j<=n;j+=i){
					arr[j] = false;
				}
			}
		}
		
		return arr;
	}

}
