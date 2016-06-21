package com.just.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Callable one = new CallableTaskOne();
		Callable two = new CallableTaskTwo();
		Callable three = new CallableTaskThree();
		
		ExecutorService ex = Executors.newFixedThreadPool(3);
		Future<String> fOne = ex.submit(one);
		Future<String> fTwo = ex.submit(two);
		Future<String> fThree = ex.submit(three);
		boolean listenOne = true;
		boolean listenTwo = true;
		boolean listenThree = true;
		List<String> futureList = new ArrayList<String>();
		
		while(listenOne || listenTwo || listenThree){
			if(fOne.isDone() && listenOne){
				try {
					String result = fOne.get();
					System.out.println(result);
					futureList.add(result);
					listenOne = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			
			if(fTwo.isDone() && listenTwo){
				try {
					String result = fTwo.get();
					System.out.println(result);
					futureList.add(result);
					listenTwo = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			
			if(fThree.isDone() && listenThree){
				try {
					String result = fThree.get();
					System.out.println(result);
					futureList.add(result);
					listenThree = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(String fTask : futureList){
				System.out.println(fTask);
		}
		
		System.out.println("Total time : "+(System.currentTimeMillis() - start));
		ex.shutdown();
	}
}
