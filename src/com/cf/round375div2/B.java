package com.cf.round375div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int len = Integer.parseInt(bf.readLine().trim());
		String input = bf.readLine().trim();
		int longest = 0;
		int wordsInsideParenthesis = 0;
		int temp = 0;
		for (int i = 0; i < len; i++) {
			if (input.charAt(i) == '_') {

				if (temp != 0) {
					if (temp > longest) {
						longest = temp;
					}
					temp = 0;
				} else {
					// do nothing
				}

			} else if (input.charAt(i) == '(') {
				
				if (temp != 0) {
					if (temp > longest) {
						longest = temp;
					}
					temp = 0;
				} else {
					// do nothing
				}
				
				boolean isCharPresent = false;
				while (input.charAt(++i) != ')') {
					if (input.charAt(i) == '_') {

						if (isCharPresent) {
							wordsInsideParenthesis++;
						}
						isCharPresent = false;

					} else {
						isCharPresent = true;
					}
				}
				if (isCharPresent) {
					wordsInsideParenthesis++;
				}
				isCharPresent = false;

			} else {
				temp++;
			}
		}
		if (temp != 0) {
			if (temp > longest) {
				longest = temp;
			}
			temp = 0;
		}

		bw.write("" + longest + " " + wordsInsideParenthesis);

		bw.flush();
		bw.close();
		bf.close();
	}

}
