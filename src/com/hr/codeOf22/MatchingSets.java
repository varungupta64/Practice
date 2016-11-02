package com.hr.codeOf22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatchingSets {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input;
		long[] x = new long[n];
		long[] y = new long[n];
		long pos = 0;
		long neg = 0;
		long inter = 0;
		
		input = bf.readLine().trim().split(" ");
		
		for(int i=0;i<n;i++){
			x[i] = Long.parseLong(input[i]);
		}
		
		input = bf.readLine().trim().split(" ");
		
		for(int i=0;i<n;i++){
			y[i] = Long.parseLong(input[i]);
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		for(int i=0;i<n;i++){
			inter = x[i] - y[i];
			if(inter > 0){
				pos += inter;
			}else if(inter < 0){
				neg += (-1*inter);
			}
		}
		
		if(pos == neg){
			System.out.println(pos);
		}else{
			System.out.println("-1");
		}
	}

}
