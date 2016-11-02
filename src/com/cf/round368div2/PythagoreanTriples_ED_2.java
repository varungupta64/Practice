package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PythagoreanTriples_ED_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int q = Integer.parseInt(input[2]);

		boolean[][] bookshelf = new boolean[n + 1][m + 1];
		Ques[] arr = new Ques[q + 1];
		for (int i = 0; i <= q; i++) {
			arr[i] = new Ques();
		}

		for (int i = 1; i <= q; i++) {
			input = bf.readLine().trim().split(" ");
			arr[i].type = Byte.parseByte(input[0]);

			switch (arr[i].type) {
			case 1:
				arr[i].i = Integer.parseInt(input[1]);
				arr[i].j = Integer.parseInt(input[2]);
				arr[i - 1].child.add(arr[i]);
				break;
			case 2:
				arr[i].i = Integer.parseInt(input[1]);
				arr[i].j = Integer.parseInt(input[2]);
				arr[i - 1].child.add(arr[i]);
				break;
			case 3:
				arr[i].i = Integer.parseInt(input[1]);
				arr[i - 1].child.add(arr[i]);
				break;
			case 4:
				arr[i].i = Integer.parseInt(input[1]);
				arr[arr[i].i].child.add(arr[i]);
				break;
			}
		}

		dfs(arr[0], 0, bookshelf);
		for (int i = 1; i <= q; i++) {
			bw.write("" + arr[i].ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static void dfs(Ques ques, int ans, boolean[][] bookshelf) {
		int count = 0;
		switch (ques.type) {
		case 1:
			if (!bookshelf[ques.i][ques.j]) {
				bookshelf[ques.i][ques.j] = true;
				count++;
			}
			break;
		case 2:
			if (bookshelf[ques.i][ques.j]) {
				bookshelf[ques.i][ques.j] = false;
				count--;
			}
			break;
		case 3:
			for (int i = 1; i < bookshelf[ques.i].length; i++) {
				if (!bookshelf[ques.i][i]) {
					count++;
				} else {
					count--;
				}
				bookshelf[ques.i][i] = !bookshelf[ques.i][i];
			}
			break;
		}

		ques.ans = count + ans;

		for (Ques q : ques.child) {
			dfs(q, ques.ans, bookshelf);
		}

		// UNDO
		switch (ques.type) {
		case 1:
			if (bookshelf[ques.i][ques.j] && count > 0) {
				bookshelf[ques.i][ques.j] = false;
			}
			break;
		case 2:
			if (!bookshelf[ques.i][ques.j] && count < 0) {
				bookshelf[ques.i][ques.j] = true;
			}
			break;
		case 3:
			for (int i = 1; i <= ques.j; i++) {
				bookshelf[ques.i][i] = !bookshelf[ques.i][i];
			}
			break;
		}
	}

}

class Ques {
	int index;
	byte type;
	int i;
	int j;
	int ans;
	List<Ques> child = new ArrayList<Ques>();
}