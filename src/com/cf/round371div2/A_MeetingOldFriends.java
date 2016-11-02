package com.cf.round371div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_MeetingOldFriends {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");

		long l1 = Long.parseLong(input[0]);
		long r1 = Long.parseLong(input[1]);
		long l2 = Long.parseLong(input[2]);
		long r2 = Long.parseLong(input[3]);
		long k = Long.parseLong(input[4]);
		long a, b;

		if (l2 > r1 || r2 < l1) {
			System.out.println(0);
		} else {

			if (l2 >= l1) {
				a = l2;
			} else {
				a = l1;
			}

			if (r2 >= r1) {
				b = r1;
			} else {
				b = r2;
			}

			long ans = b - a + 1;

			if (k >= a && k <= b) {
				ans--;
			}

			System.out.println(ans);
		}
	}

}
