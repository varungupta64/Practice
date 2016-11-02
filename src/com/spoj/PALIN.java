package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PALIN {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			char[] num = bf.readLine().trim().toCharArray();
			char[] palin = new char[num.length];
			for (int j = 0; j < num.length; j++) {
				palin[j] = num[j];
			}
			System.out.println(convertToPalindrome(num, palin, 0, num.length - 1));
		}
	}

	private static char[] convertToPalindrome(char[] num, char[] palin, int start, int end) {
		if (start == end || start + 1 == end) {
			if (Integer.parseInt(String.valueOf(palin)) > Integer.parseInt(String.valueOf(num))) {
				return palin;
			} else {
				while (Integer.parseInt(String.valueOf(palin)) <= Integer.parseInt(String.valueOf(num))) {
					try {
						movePalindromeToNextGreatest(palin, start, end);
					} catch (Exception e) {
						if(e.getMessage().equals("case 9999")){
							int m = palin.length;
							palin = new char[m+1];
							for(int i=0;i<=m;i++){
								if(i==0 || i==m){
									palin[i] = '1';
								}else{
									palin[i] = '0';
								}
							}
						}
					}
				}
				return palin;
			}
		}

		palin[end] = palin[start];

		return convertToPalindrome(num, palin, start + 1, end - 1);
	}

	private static void movePalindromeToNextGreatest(char[] palin, int start, int end) throws Exception {
		if (palin[start] != '9') {
			palin[start] = (char) ((int) palin[start] + 1);
			palin[end] = palin[start];
		} else {
			if (start == 0) {
				throw new Exception("case 9999");
			} else {
				palin[start] = 0;
				palin[end] = palin[start];
				movePalindromeToNextGreatest(palin, start - 1, end + 1);
			}
		}
	}
}
