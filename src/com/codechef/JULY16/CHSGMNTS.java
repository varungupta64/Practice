package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHSGMNTS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(bf.readLine().trim());
			String[] input = bf.readLine().trim().split(" ");
			int[] arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			System.out.println(totalNonIntersectingSegments(arr, n));

		}
	}

	private static int totalNonIntersectingSegments(int[] arr, int n) {
		int len = 1;
		int result = 0;
		int start = 0;

		while (n - len > 0) {
			start = 0;
			while (start < n) {
				result += nonIntersectingSegment(arr, start, len, n - 1);
				start++;
			}
			len++;
		}

		return result;
	}

	private static int nonIntersectingSegment(int[] arr, int start, int len, int end) {
		if (start == end) {
			return 0;
		}

		if (start + len > end) {
			return 0;
		}
		
		int result = 0;
		int[] givenSubArray = new int[len];
		
		for(int j=0;j<len;j++){
			givenSubArray[j] = arr[start+j];
		}
		
		for(int i=1;i<=end+1-start-len;i++){
			int[][] subarrayList = getSubArraysOfLen(arr,start+len,i);
			for(int j=0;j<subarrayList.length;j++){
				result += isDistinctArrays(givenSubArray,subarrayList[j]);
			}
		}
		

		return result;
	}

	private static int isDistinctArrays(int[] givenSubArray, int[] subArray) {
		for(int i=0;i<subArray.length;i++){
			for(int j=0;j<givenSubArray.length;j++){
				if(subArray[i] == givenSubArray[j]){
					return 0;
				}
			}
		}
		return 1;
	}

	private static int[][] getSubArraysOfLen(int[] arr, int start, int len) {
		int row = arr.length-start-len+1;
		int[][] resArr = new int[row][len];
		
		for(int i=0;i<row;i++){
			for(int j=0;j<len;j++){
				resArr[i][j] = arr[start+j];
			}
			start += 1;
		}
		
		return resArr;
	}
}
