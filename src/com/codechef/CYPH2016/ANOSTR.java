package com.codechef.CYPH2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ANOSTR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		List<Record> list;

		for (int i = 0; i < t; i++) {

			n = Integer.parseInt(bf.readLine().trim());
			list = new ArrayList<Record>();

			for (int j = 0; j < n; j++) {
				list.add(new Record(bf.readLine().trim().split(" ")));
			}

			Collections.sort(list, new Comparator<Record>() {

				@Override
				public int compare(Record r1, Record r2) {
					if (r1.getScore() > r2.getScore()) {
						return 1;
					} else if (r1.getScore() < r2.getScore()) {
						return -1;
					} else if (r1.getTime() > r2.getTime()) {
						return 1;
					} else if (r1.getTime() < r2.getTime()) {
						return -1;
					} else if (r1.getSubmissions() > r2.getSubmissions()) {
						return 1;
					} else if (r1.getSubmissions() < r2.getSubmissions()) {
						return -1;
					}
					return r1.getName().compareTo(r2.getName());
				}

			});

			for (int j = 0; j < n; j++) {
				System.out.println(list.get(j));
			}
			
		}
	}

}

class Record {
	private int score;
	private int time;
	private int submissions;
	private String name;

	public Record(int score, int time, int submissions, String name) {
		this.score = score;
		this.time = time;
		this.submissions = submissions;
		this.name = name;
	}

	public Record(String[] arr) {
		this.score = Integer.parseInt(arr[0]);
		this.time = Integer.parseInt(arr[1]);
		this.submissions = Integer.parseInt(arr[2]);
		this.name = arr[3];
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getSubmissions() {
		return submissions;
	}

	public void setSubmissions(int submissions) {
		this.submissions = submissions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.getScore()+" "+this.getTime()+" "+this.getSubmissions()+" "+this.getName();
	}
}
