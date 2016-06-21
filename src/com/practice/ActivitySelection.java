package com.practice;

/**
 * 
 * @author varungupta01
 *
 *         You are given n activities with their start and finish times. Select
 *         the maximum number of activities that can be performed by a single
 *         person, assuming that a person can only work on a single activity at
 *         a time. Example:
 * 
 *         Consider the following 6 activities. start[] = {1, 3, 0, 5, 8, 5};
 *         finish[] = {2, 4, 6, 7, 9, 9}; The maximum set of activities that can
 *         be executed by a single person is {0, 1, 3, 4}
 *
 */
public class ActivitySelection {
	
	static int counter = 0;
	
	public static void main(String[] args) {
		int[] start = new int[]{0,2,5,8,5,1};
		int[] finish = new int[]{6,4, 7, 9, 9,2};
		
		sortM(start, finish);
		System.out.println("Sorted Finish array : ");
		displayArr(finish);		
		System.out.println("Sorted Start array : ");
		displayArr(start);
		
		int prevSelected = 0;
		for(int i=0;i<start.length;i++){
			if(i>0){
				if(start[i]>=finish[prevSelected]){
					System.out.print(i+" ");
					prevSelected=i;
				}
			}else{
				System.out.print(i+" ");
			}
		}
	}
	
	private static void displayArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	
	private static void sortM(int[] start,int[] finish){
		mergeSort(start, finish, 0, finish.length-1);
	}
	
	private static void mergeSort(int[] start,int[] finish,int l,int h){
		if(h>l){
			int m = (l+h)/2;
						
			mergeSort(start, finish, l, m);
			mergeSort(start, finish, m+1, h);
			
			merge(start, finish, l, m, h);
		}
	}
	
	private static void merge(int[] start,int[] finish,int l,int m,int h){
		int i,j,k;
		int n1=m-l+1;
		int n2=h-m;
		
		int[] L = new int[n1];
		int[] H = new int[n2];
		
		for (i = 0; i < n1; i++)
	        L[i] = finish[l + i];
	    for (j = 0; j < n2; j++)
	        H[j] = finish[m + 1+ j];
		
		i=0;
		j=0;
		k=l;
		
		while(i<n1 && j<n2){
			if(L[i]<=H[j]){
				finish[k]=L[i];
				i++;
			}else{
				finish[k]=H[j];
				j++;
			}
			k++;
		}
		
		while(i<n1){
			finish[k]=L[i];
			i++;
			k++;
		}
		
		while(j<n2){
			finish[k]=L[j];
			j++;
			k++;
		}
	}
}
