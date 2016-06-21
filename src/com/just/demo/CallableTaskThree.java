package com.just.demo;

import java.util.concurrent.Callable;

public class CallableTaskThree implements Callable<String>{
	@Override
	public String call() throws Exception {
		String name = "CallableTaskThree";
		Thread.sleep(1000);
		return name;
	}
}