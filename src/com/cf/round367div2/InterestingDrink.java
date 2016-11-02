package com.cf.round367div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class InterestingDrink {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int[] arr = new int[n];
		input = bf.readLine().trim().split(" ");
		int index, ele;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		int q = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < q; i++) {
			ele = Integer.parseInt(bf.readLine().trim());
			index = binarySearch(arr, ele, 0, n - 1, n - 1);
			index++;
			bw.write(""+index);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int binarySearch(int[] arr, int ele, int start, int end, int stop) {
		int mid = start + (end - start) / 2;
		
		/*if(ele == arr[mid]){
			return mid;
		}*/
		
		if (ele >= arr[mid]) {
			if (mid == stop) {
				return mid;
			}

			if (ele < arr[mid + 1]) {
				return mid;
			}
		}		
		
		if(start == end){
			return -1;
		}
		
		if(ele < arr[mid]){
			return binarySearch(arr, ele, start, mid, stop); 
		}else{
			return binarySearch(arr, ele, mid+1, end, stop);
		}		
	}

}
