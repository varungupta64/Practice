package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LarrysArray {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCaseNum = Integer.parseInt(bf.readLine());

			for(int i=0;i<testCaseNum;i++){
				int arrSize = Integer.parseInt(bf.readLine());
				String[] arr = bf.readLine().split(" ");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
