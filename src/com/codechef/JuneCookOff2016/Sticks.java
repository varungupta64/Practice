package com.codechef.JuneCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Sticks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int i=0;i<t;i++){
			
			int n = Integer.parseInt(bf.readLine().trim());
			String[] input = bf.readLine().trim().split(" ");
			Integer[] arr = new Integer[n];
			
			for(int j=0;j<n;j++){
				arr[j] = Integer.parseInt(input[j]);
			}
			
			Arrays.sort(arr,Collections.reverseOrder());
			
			int area = 1;
			int count = 0;
			
			for(int j=0;j<n-1;j++){
				if(arr[j] == arr[j+1]){
					area*=arr[j];
					j++;
					count++;
				}
				
				if(count==2){
					break;
				}
			}
			
			if(count<2){
				area = -1;
			}
			System.out.println(area);
		}
		
	}

}
