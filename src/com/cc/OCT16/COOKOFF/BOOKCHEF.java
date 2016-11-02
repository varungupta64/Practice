package com.cc.OCT16.COOKOFF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOOKCHEF {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		List<Person_BOOKCHEF> special;
		List<Person_BOOKCHEF> others;
		Map<Integer, Boolean> isSpecial = new HashMap<>();

		input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		special = new ArrayList<Person_BOOKCHEF>(n);
		others = new ArrayList<Person_BOOKCHEF>();
		input = bf.readLine().trim().split(" ");

		for (int i = 0; i < n; i++) {
			isSpecial.put(Integer.parseInt(input[i]), true);
		}
		
		for(int i=0;i<m;i++){
			input = bf.readLine().trim().split(" ");
			if(isSpecial.get(Integer.parseInt(input[0])) != null){
				special.add(new Person_BOOKCHEF(input));
			}else{
				others.add(new Person_BOOKCHEF(input));
			}
		}
		
		Collections.sort(special);
		Collections.sort(others);
		
		for(int i=0;i<special.size();i++){
			bw.write(special.get(i).s);
			bw.newLine();
		}
		
		for(int i=0;i<others.size();i++){
			bw.write(others.get(i).s);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		bf.close();

	}
}

class Person_BOOKCHEF implements Comparable<Person_BOOKCHEF>{
	int f;
	int p;
	String s;

	public Person_BOOKCHEF(int f) {
		this.f = f;
	}

	public Person_BOOKCHEF(String[] input) {
		this.f = Integer.parseInt(input[0]);
		this.p = Integer.parseInt(input[1]);
		this.s = input[2];
	}

	@Override
	public int compareTo(Person_BOOKCHEF p1) {
		return Integer.valueOf(p1.p).compareTo(Integer.valueOf(this.p));
	}
}
