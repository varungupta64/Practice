package com.codechef.JuneLunchTime2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SQNUMBF {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int i=0;i<t;i++){
			
			int n = Integer.parseInt(bf.readLine().trim());
			String[] arr = bf.readLine().trim().split(" ");
			
			long prev = Long.parseLong(arr[0]);
			long gcd = 0;
			long current = 0;
			long result = 0;
			
			if((result = findSquareFactorOfNum(prev)) > 1){
				System.out.println(result);
				continue;
			}
			
			for(int j=1;j<n;j++){
				current = Long.parseLong(arr[j]);
				
				if((result = findSquareFactorOfNum(current)) > 1){
					break;
				}
				for(int k=j-1;k>=0;k--){
					if((result = gcd(Long.parseLong(arr[k]),current)) > 1){
						break;
					}
				}
				if(result>1){
					break;
				}
			}
			
			System.out.println(result);
		}
	}

	private static long findSquareFactorOfNum(long num) {
		boolean isPrime = true;
		long div = 0;
		for(long i=2;i<((long)Math.sqrt(num))+1;i++){
			if(num%i==0){
				isPrime = false;
				div = i;
				break;
			}
		}
		
		if(!isPrime){
			if((num/div)%div==0){
				return div;
			}else{
				return findSquareFactorOfNum(num/div);
			}
		}
		return 0;
	}

	private static long gcd(long prev, long current) {
		if(current == 0){
			return prev;
		}
		return gcd(current,prev%current);
	}

}
