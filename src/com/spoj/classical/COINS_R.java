package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class COINS_R {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int n;

		while ((input = bf.readLine().trim()) != null && !input.equals("")) {

			n = Integer.parseInt(input);
			bw.write("" + coins(n));
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();

	}

	private static int coins(int n) {		
		if(n == 0){
			return 0;
		}
		return Integer.max(n, coins(n/2)+coins(n/3)+coins(n/4));
	}

}
