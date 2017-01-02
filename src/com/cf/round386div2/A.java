package com.cf.round386div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(bf.readLine().trim());
		int b = Integer.parseInt(bf.readLine().trim());
		int c = Integer.parseInt(bf.readLine().trim());
		int a1,b1,c1;
		int sum = 0;
		a1 = a;
		b1 = b/2;
		c1 = c/4;
		
		int min = Integer.min(Integer.min(a1, b1),c1);
		if(min==0){
			System.out.println("0");
		}else{
			sum = min+2*min+4*min;
			System.out.println(sum);
		}
		bf.close();
	}
}