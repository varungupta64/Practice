package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFPATH {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(bf.readLine());
			for(int i=0;i<t;i++){
				String[] mn = bf.readLine().split(" ");
				long m = Long.parseLong(mn[0]);
				long n = Long.parseLong(mn[1]);
				
				if((m==1 && n!=2)||(m!=2 && n ==1)){
					System.out.println("No");
				}
				else if(m*n % 2 == 0){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
