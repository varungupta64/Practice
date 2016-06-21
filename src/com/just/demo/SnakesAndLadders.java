package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SnakesAndLadders {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCaseNum = Integer.parseInt(bf.readLine().trim());
			for (int i = 0; i < testCaseNum; i++) {
				int[] board = new int[101];
				for (int j = 0; j < 101; j++) {
					board[j] = j;
				}
				int ladderNum = Integer.parseInt(bf.readLine().trim());
				int[] ladArr = new int[ladderNum];
				for (int j = 0; j < ladderNum; j++) {
					String[] num = bf.readLine().trim().split(" ");
					int one = Integer.parseInt(num[0]);
					int second = Integer.parseInt(num[1]);
					board[one] = second;
					ladArr[j] = second;
				}
				int snakeNum = Integer.parseInt(bf.readLine().trim());
				int[] snkArr = new int[snakeNum];
				for (int j = 0; j < snakeNum; j++) {
					String[] num = bf.readLine().trim().split(" ");
					int one = Integer.parseInt(num[0]);
					int second = Integer.parseInt(num[1]);
					board[one] = second;
					snkArr[j] = one;
				}
				
				boolean isPossible = true;
				List<Integer> low = new ArrayList<Integer>();
				List<Integer> high = new ArrayList<Integer>();
				if(snakeNum >= 6){
					Arrays.sort(snkArr);
					Arrays.sort(ladArr);
					for (int j = 0; j < snakeNum-5; j++) {
						if(snkArr[j]+5 == snkArr[j+5]){
							isPossible = false;
							low.add(snkArr[j]);
							high.add(snkArr[j+5]);
							break;
						}
					}
				}
				
				if(!isPossible){
					for(int s=0;s<low.size();s++){
						boolean isLow = false;
						boolean isHigh = false;
						for(int m=0;m<ladderNum;m++){
							if(ladArr[m] < low.get(s)){
								isLow = true;
							}
							if(ladArr[ladderNum - m -1] > high.get(s)){
								isHigh = true;
							}
						}
						if(isLow && isHigh){
							isPossible = true;
						}else{
							isPossible = false;
							break;
						}
					}
				}
				
				LinkedList<Integer> queue = new LinkedList<>();
				if(isPossible){
					queue.add(1);
				}
				int counter = 0;
				int val = -1;
				int res = -1;
				int index = 1;
				int ele = 0;
				int inter = 0;
				while (!queue.isEmpty() && val != 100) {
					while (index > 0  && val != 100) {
						ele = queue.poll();
						index--;
						for (int v = 1; v <= 6; v++) {
							int e = board[board[ele] + v];
							if (e == 100) {
								val = 100;
								res = counter + 1;
								break;
							}
							if (e > 0 && !queue.contains(e)) {
								queue.add(e);
								inter++;
							}
						}
					}
					counter++;
					index = inter;
					inter = 0;
				}
				System.out.println(res);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
