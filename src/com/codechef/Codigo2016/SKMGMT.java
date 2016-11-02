package com.codechef.Codigo2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SKMGMT {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int n, m;
		String[] input;
		JobTime[] jobtime;
		int tm, jb;
		int max = 1000;
		int[] s;
		int totalTime, totalJob;
		int prev;
		int prevJob;
		int[] arr;

		for (int i = 0; i < t; i++) {
			totalJob = 0;
			totalTime = 0;
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			jobtime = new JobTime[n];
			s = new int[max];

			for (int j = 0; j < n; j++) {
				input = bf.readLine().trim().split(" ");
				tm = Integer.parseInt(input[0]);
				jb = Integer.parseInt(input[1]);
				jobtime[j] = new JobTime(tm, jb);
			}

			Arrays.sort(jobtime, new Comparator<JobTime>() {

				@Override
				public int compare(JobTime o1, JobTime o2) {
					if (o1.getJob() > o2.getJob()) {
						return 1;
					} else if (o1.getJob() == o2.getJob()) {

						if (o1.getTime() > o2.getTime()) {
							return 1;
						} else {
							return -1;
						}

					} else {
						return -1;
					}
				}
			});

			for (int j = 0; j < n; j++) {
				totalJob += jobtime[j].getJob();
				totalTime += jobtime[j].getTime();
			}

			s[totalTime] = totalJob;
			prev = totalTime;
			prevJob = totalJob;

			for (int j = 0; j < n; j++) {
				s[prev - jobtime[j].getTime()] = prevJob - jobtime[j].getJob();

				for (int k = prev - jobtime[j].getTime() + 1; k < prev; k++) {
					s[k] = prevJob - jobtime[j].getJob();
				}

				prev = prev - jobtime[j].getTime();
				prevJob = prevJob - jobtime[j].getJob();
			}

			input = bf.readLine().trim().split(" ");
			arr = new int[m];
			for (int j = 0; j < m; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}
			for (int j = 0; j < m; j++) {
				if(arr[j]>totalTime){
					System.out.print(s[totalTime] + " ");
				}else{
					System.out.print(s[arr[j]] + " ");
				}
			}
			System.out.println("");
		}
	}

}

class JobTime {
	private int time;
	private int job;

	public JobTime(int time, int job) {
		this.time = time;
		this.job = job;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}
}
