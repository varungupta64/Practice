package com.gfg.practice;

public class InversionCountMergeSort {

	public static void main(String[] args) {
		int arr[] = { 1, 20, 6, 4, 5 };
		System.out.println(mergeSort(arr, arr.length));
	}

	private static int mergeSort(int[] arr, int n) {
		int[] temp = new int[n];
		return mergeSortUtil(arr, temp, 0, n - 1);
	}

	private static int mergeSortUtil(int[] arr, int[] temp, int left, int right) {
		int mid, inversions = 0;

		if (left < right) {
			mid = (right + left) / 2;

			inversions += mergeSortUtil(arr, temp, left, mid);
			inversions += mergeSortUtil(arr, temp, mid + 1, right);

			inversions += merge(arr, temp, left, mid + 1, right);

		}

		return inversions;
	}

	private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		int i, j, k;
		int inversionCount = 0;

		i = left;
		j = mid;
		k = left;

		while ((i <= mid - 1) && (j <= right)) {

			if(arr[i]<=arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
				inversionCount = inversionCount + (mid - i);
			}			
		}
		
		while(i<=mid-1){
			temp[k++] = arr[i++];
		}
		
		while(j<=right){
			temp[k++] = arr[j++];
		}

		for (i=left; i <= right; i++)
		    arr[i] = temp[i];
		
		return inversionCount;
	}

}
