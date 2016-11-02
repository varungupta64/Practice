package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CHDOGS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		double s, v, time;
		BigDecimal d;
		DecimalFormat df = new DecimalFormat("#.#######");

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			s = Double.parseDouble(input[0]);
			v = Double.parseDouble(input[1]);

			time = (2 * s) / (3 * v);
			d = new BigDecimal(time);

			bw.write("" + df.format(d.setScale(7, RoundingMode.CEILING).doubleValue()));
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
