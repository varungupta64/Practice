package com.codechef.AprilCookOff2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class MOVIEWKN {
	static StringTokenizer input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine().trim());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());

			int[] l = populateArray(br, input, n);
			int[] r = populateArray(br, input, n);
			
			int maxProduct = 0;
			int maxR = 0;
			int index = 0;
			
			int interProd = 1;
			
			for(int i=1;i<=n;i++){
				interProd = l[i] * r[i];
				if(interProd > maxProduct){
					maxProduct = interProd;
					maxR = r[i];
					index = i;
				}else if(interProd == maxProduct && r[i] > maxR){
					maxR = r[i];
					index = i;
				}
			}
			
			System.out.println(index);
		}
	}

	private static int[] populateArray(BufferedReader br, StringTokenizer input, int n) throws IOException {
		input = new StringTokenizer(br.readLine().trim(), " ");
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input.nextToken());
		}
		return arr;
	}
}
