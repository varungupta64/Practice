package com.codechef.March16.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFSPL {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int d = Integer.parseInt(getInput());
		
		for(int i=0;i<d;i++){
			
			char[] arr = getInput().toCharArray();
			int n = arr.length;
			
			boolean isDoubleString = false;
			
			if(n==1 || n==0){
				System.out.println("NO");
				continue;
			}
			
			if(n%2==0){
				isDoubleString = checkIfDoubleString(arr,0,n/2,n/2,n);
			}else{
				isDoubleString = checkIfSubsequence(arr,0,n/2,n/2,n);
				if(!isDoubleString){
					isDoubleString = checkIfSubsequence(arr,n/2+1,n,0,n/2+1);
				}
			}
			
			if(isDoubleString){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

	private static boolean checkIfSubsequence(char[] arr, int start, int end, int start1, int end1) {
		if(start==end)
			return true;
		
		if(start1==end1)
			return false;
					
		if(arr[end-1]==arr[end1-1])
			return checkIfSubsequence(arr, start, end-1, start1, end1-1);
		
		return checkIfSubsequence(arr, start, end, start1, end1-1);
	}

	private static boolean checkIfDoubleString(char[] arr, int start, int end, int start1, int end1) {
		if(start>=end || start1>=end1){
			return true;
		}
		
		if(arr[start] != arr[start1]){
			return false;
		}
		return checkIfDoubleString(arr, start+1, end, start1+1, end1);
	}

	private static String getInput() throws IOException {
		return bf.readLine().trim();
	}
}
