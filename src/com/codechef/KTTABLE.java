package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KTTABLE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int i=0;i<t;i++){
			int n = Integer.parseInt(bf.readLine().trim());
			String[] AS = bf.readLine().trim().split(" ");
			String[] BS = bf.readLine().trim().split(" ");
			
			int[] A = new int[n];
			int[] B = new int[n];
			
			for(int j=0;j<n;j++){
				A[j] = Integer.parseInt(AS[j]);
				B[j] = Integer.parseInt(BS[j]);
			}
			
			int max = 0;
			
			if(A[0]>=B[0]){
				max++;
			}
			
			for(int j=1;j<n;j++){
				if(A[j]-A[j-1] >= B[j]){
					max++;
				}
			}
			
			System.out.println(max);
		}
		
	}
}
