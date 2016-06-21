package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BIPIN3 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(bf.readLine());
			for(int i=0;i<t;i++){
				String[] s = bf.readLine().split(" ");
				int n = Integer.parseInt(s[0]);
				BigInteger kb = new BigInteger(s[1]);
				BigInteger ONE = new BigInteger("1");
				BigInteger MODULO = new BigInteger("1000000007");
				/*BigInteger resultb = kb.multiply(kb.subtract(ONE).pow(n - 1));*/
				BigInteger resultb = kb;
				for(int j =0;j<n-1;j++){
					resultb = resultb.multiply(kb.subtract(ONE)).mod(MODULO);
				}
				resultb = resultb.mod(MODULO);
				System.out.println(resultb);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
