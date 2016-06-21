package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LADDU {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCaseNum = Integer.parseInt(bf.readLine());
			for (int i = 0; i < testCaseNum; i++) {
				boolean isInd = false;
				String[] lineOne = bf.readLine().split(" ");
				int activities = Integer.parseInt(lineOne[0]);
				String origin = lineOne[1];
				if(origin.startsWith("I")){
					isInd = true;
				}
				int totalPoints = 0;
				for(int j=0;j<activities;j++){
					String[] input = bf.readLine().split(" ");
					switch(input[0]){
					case "CONTEST_WON":
						totalPoints+= 300 + (20 - (Integer.parseInt(input[1])>20?20:Integer.parseInt(input[1])));
						break;
					case "TOP_CONTRIBUTOR":
						totalPoints+= 300;
						break;
					case "BUG_FOUND":
						totalPoints+= Integer.parseInt(input[1]);
						break;
					case "CONTEST_HOSTED":
						totalPoints+=50;
						break;
					}
				}
				int div = 400;
				if(isInd){
					div = 200;
				}
				System.out.println(totalPoints/div);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
