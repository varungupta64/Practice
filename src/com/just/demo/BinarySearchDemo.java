package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchDemo {

	public static void main(String[] args) {
		int[] arr = new int[2000];
		for(int i=0;i<arr.length;i++){
			arr[i] = i + 1;
		}
		int search = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			search = Integer.parseInt(bf.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int first = 0;
		int last = arr.length - 1;
		int middle = (first + last)/2;
		
		while(first <= last){
			if(arr[middle] < search){
				first = middle + 1;
			}else if(arr[middle] == search){
				System.out.println("Found Loc : "+(middle + 1));
				break;
			}else{
				last = middle -1;
			}
			
			middle = (first + last)/2;
		}
		
		if(first > last){
			System.out.println("Not present");
		}
	}
}
