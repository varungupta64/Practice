package com.five.day;

public class PartitionProblem_R {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 12, 5 };
		System.out.println(isPartitionable(arr));
	}

	private static boolean isPartitionable(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		if (sum % 2 == 0) {
			return checkForSubset(arr,0,arr.length-1,sum/2,0);
		}
		return false;
	}

	private static boolean checkForSubset(int[] arr, int start, int end, int sum, int sumTillHere) {
		if(start>end){
			return false;
		}
		
		if(sumTillHere==sum){
			return true;
		}
		
		if(sumTillHere>sum){
			return false;
		}
		
		return (checkForSubset(arr, start+1, end, sum, sumTillHere)||checkForSubset(arr, start+1, end, sum, sumTillHere+arr[start]));
	}

}
