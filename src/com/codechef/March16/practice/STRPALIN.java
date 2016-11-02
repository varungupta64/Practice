package com.codechef.March16.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class STRPALIN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		
		for(int i=0;i<t;i++){
			
			char[] a = bf.readLine().trim().toCharArray();
			char[] b = bf.readLine().trim().toCharArray();
			
			boolean[] a1 = new boolean[256];
			boolean[] b1 = new boolean[256];
			
			for(char c='a';c<='z';c++){
				a1[c] = b1[c] = false;
			}
			
			for(int j=0;j<a.length;j++){
				a1[a[j]] = true;
			}
			
			for(int j=0;j<b.length;j++){
				b1[b[j]] = true;
			}
			
			boolean isPalindrome = false;
			
			for(char c='a';c<='z';c++){
				if(a1[c] && b1[c]){
					isPalindrome = true;
					break;
				}
			}
			
			if(isPalindrome){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}

	}

}
