package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SEASTONE {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m;
		Box_SEASTONE[] box;
		Box_SEASTONE_EnergyComparator energyComparator = new Box_SEASTONE_EnergyComparator();

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			input = bf.readLine().trim().split(" ");
			box = new Box_SEASTONE[n];
			for (int j = 0; j < n; j++) {
				box[j] = new Box_SEASTONE(Integer.parseInt(input[j]), 0);
			}

			Arrays.sort(box, Collections.reverseOrder(energyComparator));
			
			//TODO
			

		}
		
		bw.flush();
		bw.close();
		bf.close();
	}
}

class Box_SEASTONE {
	int energy;
	int stone;

	public Box_SEASTONE() {
		this.energy = 0;
		this.stone = 0;
	}

	public Box_SEASTONE(int energy, int stone) {
		this.energy = energy;
		this.stone = stone;
	}
}

class Box_SEASTONE_EnergyComparator implements Comparator<Box_SEASTONE> {

	@Override
	public int compare(Box_SEASTONE b1, Box_SEASTONE b2) {
		return Integer.valueOf(b1.energy).compareTo(Integer.valueOf(b2.energy));
	}

}