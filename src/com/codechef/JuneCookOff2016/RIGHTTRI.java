package com.codechef.JuneCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RIGHTTRI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int i=0;i<t;i++){
			
			String[] input = bf.readLine().trim().split(" ");
			double h = Double.parseDouble(input[0]);
			double s = Double.parseDouble(input[1]);
			
			long start = 0;
			long end = (long)Math.ceil(Math.sqrt(Math.pow(h, 2)/2));
			long mid = (start+end)/2;
			
			binarySearch(start,mid,end,s,h);
		}
	}

	private static long binarySearch(long start, long mid, long end, double s, double h) {
		double hypotenuse = Math.pow(mid, 2)+Math.pow((s*2)/mid, 2);
		if(hypotenuse == h){
			return mid;
		}
		
		if(end<start){
			return -1;
		}
		
		if(hypotenuse<h){
			start = mid+1;
		}else{
			end = mid;
		}
		mid = (start+end)/2;
		return binarySearch(start, mid, end, s, hypotenuse);
	}

}
