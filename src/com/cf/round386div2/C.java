package com.cf.round386div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int s = Integer.parseInt(input[0]);
		int x1 = Integer.parseInt(input[1]);
		int x2 = Integer.parseInt(input[2]);
		input = bf.readLine().trim().split(" ");
		int t1 = Integer.parseInt(input[0]);
		int t2 = Integer.parseInt(input[1]);
		input = bf.readLine().trim().split(" ");
		int p = Integer.parseInt(input[0]);
		int d = Integer.parseInt(input[1]);

		int igor = (int) Math.abs(x1 - x2) * t2;
		int timeToReachIgor = 0;
		if (x1 > p && d > 0) {
			timeToReachIgor = (int) Math.abs(x1 - p) * t1;
		} else if (x1 > p && d < 0) {
			timeToReachIgor = (2 * p + (int) Math.abs(x1 - p)) * t1;
			d = 1;
		} else if (x1 < p && d > 0) {
			timeToReachIgor = (2 * (s - p) + (int) Math.abs(x1 - p)) * t1;
			d = -1;
		} else if (x1 < p && d < 0) {
			timeToReachIgor = (int) Math.abs(x1 - p) * t1;
		}

		if (timeToReachIgor >= igor) {
			System.out.println(igor);
		} else {
			if (x2 > x1 && d > 0) {
				timeToReachIgor += (int) Math.abs(x2 - x1) * t1;
			} else if (x2 > x1 && d < 0) {
				timeToReachIgor += (2 * x1 + (int) Math.abs(x2 - x1)) * t1;
				d = 1;
			} else if (x2 < x1 && d > 0) {
				timeToReachIgor += (2 * (s - x1) + (int) Math.abs(x2 - x1)) * t1;
				d = -1;
			} else if (x2 < x1 && d < 0) {
				timeToReachIgor += (int) Math.abs(x2 - x1) * t1;
			}
			
			System.out.println(Integer.min(igor, timeToReachIgor));
		}
		bf.close();
	}
}