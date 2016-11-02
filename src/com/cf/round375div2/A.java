package com.cf.round375div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = bf.readLine().trim().split(" ");
		int[] arr = new int[3];
		for (int i = 0; i <= 2; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		bw.write(""+(arr[2] - arr[0]));

		bw.flush();
		bw.close();
		bf.close();
	}

}
