package com.codechef.JulyCookOff2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFFED {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine().trim();
		int length = input.length();
		int num = Integer.parseInt(input);

		int minNum = num - (9 * length + 16);
		if (minNum < 0) {
			minNum = 0;
		}

		int result = 0;
		int inter = 0;
		int inter1 = 0;
		int count = 0;
		
		for(int i = minNum;i<num;i++){
			inter = sumOfDigits(i);
			inter1 = sumOfDigits(inter);
			result = i + inter + inter1;
			
			if(num == result){
				//System.out.println(i);
				count++;
			}
		}
		
		System.out.println(count);
		
		bf.close();
	}

	private static int sumOfDigits(int num) {
		if (num == 0) {
			return 0;
		}
		return num % 10 + sumOfDigits(num / 10);
	}

}
