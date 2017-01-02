package com.spoj.classical;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class EASYPROB {
	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] list = { 137, 1315, 73, 136, 255, 1384, 16385 };
		String binary;
		int count = 0;
		StringBuffer str;
		StringBuffer result = new StringBuffer("");
		for (int num : list) {
			result = new StringBuffer("");
			binary = Integer.toBinaryString(num);
			count = 0;
			for (int i = binary.length() - 1; i >= 0; i--) {
				switch (binary.charAt(i)) {
				case '0':
					break;
				case '1':
					str = new StringBuffer(num+"=2(");
					for (int j = 0; j < count; j++) {
						str.append("2(0)+");
					}
					str.append("0)");
					result.append(str + "+");
					break;
				}
				count++;
			}
			System.out.println(result.toString().substring(0, result.toString().length()-1));
		}
	}
}
