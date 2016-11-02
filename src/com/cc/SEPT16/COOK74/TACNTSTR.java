package com.cc.SEPT16.COOK74;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TACNTSTR {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = bf.readLine().trim().toCharArray();
		int modulo = 1000000007;
		
		long result = 1;
		int z = 'Z';
		int diff;

		for (char c : arr) {
			diff = z - c + 1;
			result = (result * diff)%modulo;
		}

		result-=1;
		System.out.println(result);
	}
}
