package com.cf.round382div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		char[] seq = bf.readLine().trim().toCharArray();
		boolean isPossible = false;

		for (int i = 0; i < n; i++) {
			if (seq[i] == 'G' || seq[i] == 'T') {
				for (int j = i + k; j < n; j = j + k) {
					if (seq[j] == '#') {
						break;
					} else if (seq[j] == 'G' || seq[j] == 'T') {
						isPossible = true;
						break;
					}
				}
				break;
			}
		}
		
		if(isPossible){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
