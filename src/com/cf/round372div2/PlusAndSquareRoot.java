package com.cf.round372div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PlusAndSquareRoot {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int levelToBe = Integer.parseInt(bf.readLine().trim()) + 1;
		long k = 1;
		long n = 2;
		int max = (int) 1e6;
		List<Long> sqrtList = new ArrayList<>();

		for (int i = 2; i <= max; i++) {
			sqrtList.add((long) i * i);
		}

		double sqrt;
		long x;
		long prev = 0;
		long count = 0;

		while (true) {
			if (k == levelToBe) {
				break;
			}
			
			n = n + k;
			count++;

			sqrt = Math.sqrt(n);
			x = (long) sqrt;
			if (Math.pow(sqrt, 2) == Math.pow(x, 2)) {
				k++;
				prev = n;
				n = x;

				if (n % k == 0) {
					bw.write(count + "");
					count = 0;
					bw.newLine();
				} else {
					n = prev;
					k--;
				}

			}
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
