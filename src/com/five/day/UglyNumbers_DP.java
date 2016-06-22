package com.five.day;

public class UglyNumbers_DP {

	public static void main(String[] args) {
		System.out.println(uglyNumber(150));
	}

	public static int uglyNumber(int n) {
		int[] uglyNumArr = new int[n];
		uglyNumArr[0] = 1;

		int i2 = 0, i3 = 0, i5 = 0;

		int x, y, z;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			x = 2 * uglyNumArr[i2];
			y = 3 * uglyNumArr[i3];
			z = 5 * uglyNumArr[i5];

			if (x <= y && x <= z) {
				i2++;
				min = x;
			} 
			if (y <= x && y <= z) {
				i3++;
				min = y;
			} 
			if(z<=x && z<=y) {
				i5++;
				min = z;
			}
			uglyNumArr[i] = min;
		}

		return uglyNumArr[n - 1];
	}
}
