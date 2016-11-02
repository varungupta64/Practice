package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LifeTheUniverseAndEverything {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;

		while (!(input = bf.readLine().trim()).equals("42")) {
			bw.write(input);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
