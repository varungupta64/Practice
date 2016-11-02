package com.he.BattleOfBots6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Draughts {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] board = new int[8][8];
		int id;
		String[] input;

		for (int i = 0; i < 8; i++) {
			input = bf.readLine().trim().split(" ");
			for (int j = 0; j < 8; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}

		id = Integer.parseInt(bf.readLine().trim());

		makeMove(board, id, bw);

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void makeMove(int[][] board, int id, BufferedWriter bw) {
		
	}
}
