package com.codeforces.round365Div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MishkaAndGame {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int n = Integer.parseInt(bf.readLine().trim());
		int one,two;
		int misha = 0;
		int chris = 0;
		
		for(int i=0;i<n;i++){
			input = bf.readLine().trim().split(" ");
			one = Integer.parseInt(input[0]);
			two = Integer.parseInt(input[1]);
			if(one > two){
				misha++;
			}else if(one < two){
				chris++;
			}
		}
		
		if(misha == chris){
			bw.write("Friendship is magic!^^");
		}else if(misha > chris){
			bw.write("Mishka");
		}else{
			bw.write("Chris");
		}
		
		bw.flush();
		bw.close();
		bf.close();

	}

}
