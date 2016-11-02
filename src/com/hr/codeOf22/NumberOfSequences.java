package com.hr.codeOf22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfSequences {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 1000000000+7;
		int result = 1;
		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n+1];
		String[] input;
		
		input = bf.readLine().trim().split(" ");
		
		for(int i=1;i<=n;i++){
			arr[i] = Integer.parseInt(input[i-1]);
		}
		
		for(int i=1;i<=n;i++){
			if(arr[i] == -1){
				result *= i;
				result = result%num;
			}			
		}
		
		System.out.println(result);
	}

}
