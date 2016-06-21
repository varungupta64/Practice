package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Editorial_FORESTGA {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		long w = Long.parseLong(input[1]);
		long l = Long.parseLong(input[2]);
		
		long h[] = new long[n];
		long r[] = new long[n];
		
		for(int i = 0;i<n;i++){
			String[] inputOne = bf.readLine().trim().split(" ");
			h[i] = Long.parseLong(inputOne[0]);
			r[i] = Long.parseLong(inputOne[1]);
		}
		
		int time = 0;
		
		long tl = -1;
		long tr = 1000;
		long tm = 0;
		
		while(tr - tl > 1){
			tm = (tl + tr)/2;
			if(canCut(tm, n, w, tl, h, r)){
				tr = tm;
			}else{
				tl = tm;
			}
		}
		
		while(!canCut(time,n,w,l,h,r)){
			time++;
		}
		System.out.println(tr);
		System.out.println(time);
	}
	
	private static boolean canCut(long time, int n, long w, long l, long[] h, long[] r){
		long totalCut = 0;
		for(int i=0;i<n;i++){
			long height = h[i] + (time * r[i]);
			if(height > l){
				totalCut+=height;
			}
		}
		return (totalCut>=w);
	}
}
