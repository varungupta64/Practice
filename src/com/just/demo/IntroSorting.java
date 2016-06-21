package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class IntroSorting {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int item = Integer.parseInt(bf.readLine());
			int arrSize = Integer.parseInt(bf.readLine());
			Integer[] arr = Arrays.stream(bf.readLine().split(" ")).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
			//IntStream.range(0, arrSize).filter(i -> arr[i] == item).forEach(System.out::println);		
			//Arrays.stream(bf.readLine().split(" ")).map(s -> Integer.parseInt(s)).filter(s -> s == item).forEach(System.out::println);
			
			int result = -1;
			int first = 0;
			int last = arr.length - 1;
			int middle = (first + last)/2;
			
			while(first<=last){
				if(item > arr[middle]){
					first = middle + 1;
				}else if(item == arr[middle]){
					result = middle;
					break;
				}else{
					last = middle - 1;
				}
				
				middle = (first + last) / 2;
			}
			
			System.out.println(result);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
