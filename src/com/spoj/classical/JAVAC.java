package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JAVAC {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		char[] arr;
		String error = "Error!";
		StringBuffer s;
		boolean isJava;
		boolean isC;
		boolean isError;
		boolean isNext_;
		while ((input = bf.readLine()) != null && !input.trim().equals("")) {
			isError = false;
			isJava = false;
			isC = false;
			isNext_ = false;
			s = new StringBuffer("");
			arr = input.trim().toCharArray();
			for (char c : arr) {
				if(Character.isUpperCase(c)){
					isJava = true;
					if(isC){
						isError = true;
						break;
					}
					s.append('_');
					s.append(Character.toLowerCase(c));
				}else if(c == '_'){
					isC = true;
					if(isJava){
						isError = true;
						break;
					}
					isNext_ = true;
				}else if(isNext_){
					s.append(Character.toUpperCase(c));
					isNext_ = false;
				}else{
					s.append(c);
				}
			}
			if(isError){
				bw.write(error);
			}else{
				bw.write(s.toString());
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
