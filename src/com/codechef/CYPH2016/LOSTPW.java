package com.codechef.CYPH2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LOSTPW {

	public static void main(String[] args) throws IOException {
		//48-57
		//97-122
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input;
		boolean[] arr = new boolean[256];
		boolean containsNum;
		boolean containsAlphabet;
		int a;
		boolean isInvalid = true;
		
		while(null != (input = bf.readLine().trim()) && !"".equals(input) && isInvalid){
			isInvalid = false;
			containsNum = false;
			containsAlphabet = false;
			
			for(int i=0;i<256;i++){
				arr[i] = false;
			}
			
			for(int i=0;i<input.length();i++){
				a = input.charAt(i);
				
				if(a>=97 && a<=122){
					containsAlphabet = true;
				}else{
					containsNum = true;
				}
				
				if(!arr[input.charAt(i)]){
					arr[input.charAt(i)] = true;
				}else{
					System.out.println("Invalid");
					isInvalid = true;
					break;
				}
			}
			
			if(isInvalid){
				//nothing
			}else if(containsAlphabet && containsNum){
				System.out.println("Valid");
			}else{
				System.out.println("Invalid");
			}
			
		}
		bf.close();
	}

}
