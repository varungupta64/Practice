package com.codechef.June16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CHCOINSG {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine().trim());
			
			if(n>100000){
				System.out.println("Chef");
			}else{
				List<Integer>[] arr = primeFactors(n);
				
				boolean isChef = false;
				for(int j=arr[1].size()-1;j>=0;j--){
					if(checkForSol(arr[1],j,1)){
						isChef = true;
						break;
					}
				}
				
				if(isChef){
					System.out.println("Chef");
				}else{
					System.out.println("Misha");
				}
				
				//printPrimes(arr[0], n);
				//printList(arr[1], n);
			}
		}
	}

	private static boolean checkForSol(List<Integer> list, int index, int count) {
		boolean result = true;
		if(list.contains(0) && count%2!=0){
			return true;
		}else if(list.contains(0) && count%2==0){
			return false;
		}else{
			List<Integer>[] arr = primeFactors(list.get(index));
				for(int j=arr[1].size()-1;j>=0;j--){
					boolean localResult = checkForSol(arr[1],j,count+1);
						result = result && localResult;
						if(result == false){
							break;
						}
				}
				return result;
		}
	}

	static List<Integer>[] primeFactors(int n) {
		int originalNum = n;
		List<Integer>[] arr = new List[2];
		List<Integer> primeList = new ArrayList<Integer>();
		List<Integer> toOperateList = new ArrayList<Integer>();
		arr[0] = primeList;
		arr[1] = toOperateList;
		primeList.add(1);
		toOperateList.add(n-1);
		int index = 1;
		while (n % 2 == 0) {
			n = n / 2;
			primeList.add(2);
			toOperateList.add(originalNum-(int)Math.pow(2, index++));
		}

		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
			int count = 1;
			while (n % i == 0) {
				n = n / i;
				primeList.add(i);
				toOperateList.add(originalNum-(int)Math.pow(i, count++));
			}
		}

		if (n > 2){
			primeList.add(n);
			toOperateList.add(originalNum-n);
		}

		return arr;
	}

	/*static void printPrimes(List<Integer> list, int n) {
		System.out.println("");
		System.out.println("Prime factors for " + n + " : ");
		int mult = 1;
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
			mult *= list.get(i);
		}
		System.out.println("");
		System.out.println("Product is : " + mult);
		System.out.println("");
	}
	
	static void printList(List<Integer> list, int n) {
		System.out.println("");
		System.out.println("To operate list for " + n + " : ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
	}*/
}
