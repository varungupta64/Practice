package com.HE.GameOfCodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MrHolaReturns {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n];
		int[][] diff = new int[n][n];
		String[] input;
		int min = Integer.MAX_VALUE;
		
		input = bf.readLine().trim().split(" ");
		
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(input[i]);
		}
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				diff[i][j] = Math.abs(arr[i] - arr[j]);
				if(diff[i][j] < min){
					min = diff[i][j];
				}
			}
		}
		
		List<Point> list = new ArrayList<>();		
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(diff[i][j] == min){
					list.add(new Point(arr[i], arr[j]));
				}
			}
		}
		
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++){
			bw.write(list.get(i).toString()+" ");
		}
		
		bw.flush();
		bw.close();
		bf.close();
	}

}

class Point implements Comparable<Point>{
	int a,b;
	
	public Point(int x,int y){
		if(x>y){
			a = y;
			b = x;
		}else{
			a = x;
			b = y;
		}
	}
	
	@Override
	public String toString(){
		return a+" "+b;		
	}

	@Override
	public int compareTo(Point o) {
		if(this.a > o.a){
			return 1;
		}else if(this.a < o.a){
			return -1;
		}else{
			if(this.b > o.b){
				return 1;
			}else if(this.b < o.b){
				return -1;
			}
		}
		return 0;
	}

	
}