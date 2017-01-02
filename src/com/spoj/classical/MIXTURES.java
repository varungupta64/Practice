package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MIXTURES {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int n;
		String[] seq;
		int[] arr;
		while((input = bf.readLine().trim())!=null && !input.equals("")){
			n = Integer.parseInt(input);
			seq = bf.readLine().trim().split(" ");
			arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = Integer.parseInt(seq[i]);
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
