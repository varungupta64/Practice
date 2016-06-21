package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LEPAINT {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		for (int i = 0; i < t; i++) {
			String[] input = bf.readLine().trim().split(" ");
			int n = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);

			List<int[]> list = new ArrayList<int[]>();
			int[] arr = new int[n + 1];
			arr[0] = -1;
			for (int a = 1; a <= n; a++) {
				arr[a] = 1;
			}
			list.add(arr);

			displayList(list, 0);
			
			List<int[]> newlist = new ArrayList<int[]>();
			for (int j = 1; j <= k; j++) {
				newlist.removeAll(newlist);
				String[] input1 = bf.readLine().trim().split(" ");
				int l = Integer.parseInt(input1[0]);
				int r = Integer.parseInt(input1[1]);
				while (!list.isEmpty()) {
					for (int m = 0; m < c; m++) {
						int[] newarr = new int[n + 1];
						populateColourInGivenRange(list.get(0), newarr, l, r, m, c);
						
						//displayArray(newarr);
						
						newlist.add(newarr);
					}
					list.remove(0);
				}
				
				displayList(newlist,j);
				
				for(int p=0;p<newlist.size();p++){
					list.add(newlist.get(p));
				}
			}
			
			
			int sum = 0;
			int prob[] = new int[c];
			int counter = 0;
			for(int y=0;y<newlist.size();y++){
				for(int x=0;x<newlist.get(y).length;x++){
					if(newlist.get(y)[x]>=0){
						sum+=newlist.get(y)[x];
						prob[newlist.get(y)[x]] = prob[newlist.get(y)[x]]+1;
						counter++;
					}
				}
			}
			
			double result = 0;
			for(double o=0;o<prob.length;o++){
				result+=(o+1)*prob[(int)o]/counter;
			}
			
			System.out.println("Sol : "+sum);
			System.out.println("Result : "+result);
		}
	}

	private static void displayList(List<int[]> newlist, int counter) {
		System.out.println("Counter : "+counter);
		for(int i=0;i<newlist.size();i++){
			for(int j=0;j<newlist.get(i).length;j++){
				System.out.print(newlist.get(i)[j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
	}

	private static void displayArray(int[] newarr) {
		System.out.println("");
		for(int i=1;i<=newarr.length;i++){
			System.out.print(newarr[i]+" ");
		}
		
	}

	private static void populateColourInGivenRange(int[] arr, int[] newarr, int l, int r, int colour, int colourNum) {
		for(int j=0;j<arr.length;j++){
			newarr[j] = arr[j];
		}
		
		for (int i = l; i <= r; i++) {
			newarr[i] = (newarr[i] * colour) % colourNum;
		}
	}
}
