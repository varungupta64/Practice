package com.spoj.classical;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ARITH2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(sc.nextLine());
		long num1, num2;
		char op;
		for (int i = 0; i < t; i++) {
			num1 = sc.nextLong();
			while ((op = sc.next().charAt(0)) != '=') {
				switch (op) {
				case '*':
					num2 = sc.nextLong();
					num1*=num2;
					break;
				case '+':
					num2 = sc.nextLong();
					num1+=num2;
					break;
				case '-':
					num2 = sc.nextLong();
					num1-=num2;
					break;
				case '/':
					num2 = sc.nextLong();
					num1/=num2;
					break;
				}
			}
			bw.write(""+num1);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}
