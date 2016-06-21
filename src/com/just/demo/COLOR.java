package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class COLOR {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(bf.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(bf.readLine());
				String[] s = bf.readLine().split("");
				int r = 0;
				int g = 0;
				int b = 0;

				for (String a : s) {
					switch (a) {
					case "R":
						r++;
						break;
					case "G":
						g++;
						break;
					case "B":
						b++;
						break;
					}
				}
				
				int result = 0;
				if(r>=b && r>=g){
					result = b+g;
				}else if(b>=r && b>=g){
					result = r+g;
				}else if(g>=r && g>=b){
					result = r+b;
				}
				
				System.out.println(result);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
