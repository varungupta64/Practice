package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHBLLNS {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(bf.readLine());
			for(int i=0;i<t;i++){
				String[] rgb = bf.readLine().split(" ");
				long r = Long.parseLong(rgb[0]);
				long g = Long.parseLong(rgb[1]);
				long b = Long.parseLong(rgb[2]);
				long k = Long.parseLong(bf.readLine());
				
				long result = 0;
				
				if(k -1 >= r){
					result += r;
				}else{
					result += k - 1;
				}
				
				if(k -1 >= g){
					result += g;
				}else{
					result += k - 1;
				}
				
				if(k -1 >= b){
					result += b;
				}else{
					result += k - 1;
				}
				
				result += 1;
				
				System.out.println(result);
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
