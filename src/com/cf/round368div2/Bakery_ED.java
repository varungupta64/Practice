package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bakery_ED {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		String[][] arr;

		input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		if (k == 0) {
			bw.write("" + -1);
		} else {
			int min = Integer.MAX_VALUE;
			boolean[] storage = new boolean[n + 1];
			arr = new String[m][3];
			for (int i = 0; i < m; i++) {
				arr[i] = bf.readLine().trim().split(" ");
			}

			input = bf.readLine().trim().split(" ");
			for (int i = 0; i < k; i++) {
				storage[Integer.parseInt(input[i])] = true;
			}
			
			int u,v,l;
			
			for (int i = 0; i < m; i++) {
				u = Integer.parseInt(arr[i][0]);
				v = Integer.parseInt(arr[i][1]);
				l = Integer.parseInt(arr[i][2]);
				
				if(storage[u] && !storage[v]){
					if(l<min){
						min = l;
					}
				}
				
				if(!storage[u] && storage[v]){
					if(l<min){
						min = l;
					}
				}
			}
			
			if(min == Integer.MAX_VALUE){
				min = -1;
			}
			bw.write(""+min);
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
