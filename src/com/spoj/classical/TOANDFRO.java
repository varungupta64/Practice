package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TOANDFRO {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int column;
		char[][] arr;
		String input;
		int row;
		int count;

		while (true) {
			column = Integer.parseInt(bf.readLine().trim());
			if (column == 0) {
				break;
			} else {
				input = bf.readLine().trim();
				row = input.length() / column;
				arr = new char[row][column];

				count = 0;

				for (int i = 0; i < row; i++) {

					if (i % 2 == 0) {

						for (int j = 0; j < column; j++) {
							arr[i][j] = input.charAt(count++);
						}

					} else {

						for (int j = column - 1; j >= 0; j--) {
							arr[i][j] = input.charAt(count++);
						}

					}

				}

				for (int j = 0; j < column; j++) {
					for (int i = 0; i < row; i++) {
						bw.write(arr[i][j]);
					}
				}
				
				bw.newLine();

			}
		}

		bw.flush();
		bw.close();
		bf.close();

	}
}
