package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FENCE1_Copy {
	 public static void main(String[] args) throws IOException {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out = new PrintWriter(System.out);
	        int l;
	        while ((l = Integer.parseInt(in.readLine())) != 0) {
	            out.printf("%.2f\n", l*l/(2*Math.PI));
	        }
	        out.flush();
	    }
}
