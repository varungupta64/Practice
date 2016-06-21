package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CHEFMATH {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(bf.readLine().trim());
		List<Long> fiboList = new ArrayList<Long>();
		fiboList.add(1L);
		fiboList.add(2L);
		for(int i=0;i<q;i++){
			String[] input = bf.readLine().trim().split(" ");
			long x = Long.parseLong(input[0]);
			long k = Long.parseLong(input[1]);
			
			if(checkIfFibonacciTerm(x)){
				createSeries(x,(int)k,fiboList);
				//System.out.println(term);
			}else{
				System.out.println("0");
				continue;
			}
		}
	}
	
	private static void createSeries(long x, int k, List<Long> fiboList) {
		int i = fiboList.size();
		int term = fiboList.indexOf(x);
		if(term == -1){
			while(x!=fiboList.get(fiboList.size() - 1)){
				fiboList.add(fiboList.get(fiboList.size() - 1)+fiboList.get(fiboList.size() - 2));
				i++;
			}
			term = i - 1;
		}
		
		/*
		 * Tree logic starts
		 * */
		long counter = 1;
		long[][][] tree = new long[k][(int)Math.pow(2, k)][2];
		tree[0][0][0] = x;
		tree[0][0][1] = term;
		int j = 0;
		long leafnode = 0;
		while(j<k-1){
			int m = 0;
			counter = 0;
			while(tree[j][m][0] != 0){
				if(tree[j][m][0]>1){
					tree[j+1][m*2][0] = fiboList.get(((tree[j][m][1]-1)>=0)?((int)tree[j][m][1]-1):0);
					tree[j+1][m*2][1] = ((tree[j][m][1]-1)>=0)?((int)tree[j][m][1]-1):0;
					tree[j+1][(m*2)+1][0] = fiboList.get(((tree[j][m][1]-2)>=0)?((int)tree[j][m][1]-2):0);
					tree[j+1][(m*2)+1][1] = ((tree[j][m][1]-2)>=0)?((int)tree[j][m][1]-2):0;
					counter++;
					counter=counter%1000000007;
				}else{
					if(tree[j][m][0]==1){
						leafnode++;
					}
					tree[j+1][m*2][0] = -1;
					tree[j+1][(m*2)+1][0] = -1;
				}
				m++;
			}
			j++;
		}
		/*
		 * Tree logic ends
		 * */
		
		diplayTree(tree);
		
		if(counter == 0 && k <= leafnode){
			counter = 1;
		}
		//System.out.println("Leaf node : "+leafnode);
		System.out.println(counter);
		
		//return i;
	}

	private static void diplayTree(long[][][] tree) {
		int i = 0;
		int j = 0;
		System.out.println("length: "+tree.length);
		while(i<tree.length && tree[i][j][0]!=0){
			j=0;
			while(j<tree[0].length && tree[i][j][0]!=0){
				System.out.print(tree[i][j][0]+" ");
				j++;
			}
			System.out.println("");
			i++;
		}
	}

	static boolean checkIfFibonacciTerm(long x){
		long num = 5 * x * x;
		long one = num + 4;
		long two = num - 4;
		long sqrtOne = (long)Math.sqrt(one);
		long sqrtTwo = (long)Math.sqrt(two);
		
		boolean bOne = (sqrtOne*sqrtOne == one);
		boolean bTwo = (sqrtTwo*sqrtTwo == two);
		
		if(bOne || bTwo){
			return true;
		}
		return false;
	}
}
