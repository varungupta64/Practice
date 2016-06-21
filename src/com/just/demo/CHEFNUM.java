package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CHEFNUM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		for(int i = 0;i<testCase;i++){
			String[] input = bf.readLine().trim().split(" ");
			long l = Long.parseLong(input[0]);
			long r = Long.parseLong(input[1]);
			long result = 0;
			while(l<=r){
				result += amazingness(String.valueOf(l).split(""));
				System.out.println("intemediate : "+result);
				result%=1000000007;
				l++;		
			}
			System.out.println("final : "+result);
		}
	}

	private static long amazingness(String[] a)
	{
		System.out.print("Num : ");
		for(String asd : a){
			System.out.print(asd);
		}
		System.out.println("");
	    HashSet<Long> set = new HashSet<Long>();
	    long ans = 0;
	    for (int i = 0; i < a.length; i++ ) {
	         long val = 0;
	         for ( int j = i; j < a.length; j++ ) {
	        	if(val != Long.parseLong(a[j])){
	        		System.out.print(val+"^"+a[j]);
	        		val ^= Long.parseLong(a[j]);  
	        		System.out.print(" = "+val+" | ");
		            if(!set.contains(val)) {
		                 ans += val;
		                 set.add(val);
		            }
	        	}
	         }
	   }
	   System.out.println(""); 
	   System.out.println("Set : "); 
	   for(Long d : set){
		   System.out.print(d+" ");
	   }
	   System.out.println("");
	   System.out.println("Ans : "+ans);
	   return ans;
	}
}
