package com.he.IITKanpurFreshersProgrammingContest2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Pokencrypt {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int max = (int) 1e9;
		List<Integer> primeList = new ArrayList<Integer>();
		findPrimes(max,primeList);

		for (int i = 0; i < t; i++) {

		}

	}

	private static void findPrimes(int max, List<Integer> primeList) {
		
	}

}
