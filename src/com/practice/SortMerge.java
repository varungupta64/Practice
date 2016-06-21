package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortMerge {
	public static void main(String[] args) throws IOException {
		System.out.println("Input space separated number list : ");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int[] arr = new int[input.length];
		int count = 0;
		for(String num:input){
			arr[count++] = Integer.parseInt(num);
		}
		System.out.println("List before sorting : ");
		printArray(arr);
		mergeSort(arr,0,input.length-1);
		System.out.println("List after sorting : ");
		printArray(arr);
	}
	
	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}

	private static void mergeSort(int[] arr, int l, int h) {
		if(l<h){
			int m = (l+h)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, h);
			
			merge(arr,l,m,h);
		}
	}

	private static void merge(int[] arr, int l, int m, int h) {
		int i,j,k;
		
		int n1 = m + 1 - l;
		int n2 = h - m;
		
		int[] L = new int[n1];
		int[] H = new int[n2];
		
		for(i=0;i<n1;i++){
			L[i] = arr[l+i];
		}
		
		for(j=0;j<n2;j++){
			H[j] = arr[m+1+j];
		}
		
		i = 0;
		j = 0;
		k = l;
		
		while(i < n1 && j < n2){
			if(L[i]<=H[j]){
				arr[k] = L[i];
				i++;
			}else{
				arr[k] = H[j];
				j++;
			}
			k++;
		}
		
		while(i < n1){
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2){
			arr[k] = H[j];
			j++;
			k++;
		}
		
	}
}