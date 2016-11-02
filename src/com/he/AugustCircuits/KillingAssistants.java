package com.he.AugustCircuits;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KillingAssistants {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());

		int n, m;
		String[] input;
		Fraction f1;
		Fraction f2;
		Fraction f3 = new Fraction(1, 2);
		Fraction f4 = new Fraction(2, 3);
		Fraction f5 = new Fraction(1, 2);
		Fraction f6 = new Fraction(1, 3);
		Fraction f11 = f3.multiply(f5);
		Fraction f12 = f4.multiply(f6);
		Fraction f7;
		Fraction f8;
		Fraction f9;
		Fraction f10;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			f1 = new Fraction(m, n);
			f2 = new Fraction(n - m, n);

			f7 = f1.multiply(f11);
			f8 = f2.multiply(f12);

			f9 = f7.add(f8);

			f10 = f7.divide(f9);

			bw.write(f10.toString());

			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}

class Fraction {
	private int num;
	private int den;

	public Fraction(int n, int d) {
		num = n;
		den = d;
	}

	private static int gcd(int x, int y) {
		if (x == 0) {
			return y;
		}

		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}

	private Fraction reduce(int n, int d) {
		int gcdNum = gcd(n, d);
		d = d / gcdNum;
		n = n / gcdNum;
		return new Fraction(n, d);
	}

	public Fraction add(Fraction b) {
		int num1 = (this.num * b.den) + (b.num * this.den);
		int num2 = this.den * b.den;
		return reduce(num1, num2);
	}

	public Fraction subtract(Fraction b) {
		int num1 = (this.num * b.den) - (b.num * this.den);
		int num2 = this.den * b.den;
		return reduce(num1, num2);
	}

	public Fraction multiply(Fraction b) {
		int num1 = this.num * b.num;
		int num2 = this.den * b.den;

		return reduce(num1, num2);
	}

	public Fraction divide(Fraction b)

	{
		int num1 = this.num * b.den;
		int num2 = this.den * b.num;
		return reduce(num1, num2);
	}

	public String toString() {
		return (num + "/" + den);
	}
}