package com.he.IITKanpurFreshersProgrammingContest2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Pokedivisors {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			printPrimes(n, bw);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void printPrimes(int n, BufferedWriter bw) throws IOException {
		while (n % 2 == 0) {
			bw.write("" + 2 + " ");
			n = n / 2;
		}

		for (int i = 3; i <= (int) Math.sqrt(n); i = i + 2) {

			while (n % i == 0) {
				bw.write("" + i + " ");
				n = n / i;
			}

		}

		if(n>2){
			bw.write(""+n);
		}
		
	}

}
