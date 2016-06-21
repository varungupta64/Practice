package com.just.demo;

import java.util.concurrent.Callable;

public class CallableTaskTwo implements Callable<String>{
	@Override
	public String call() throws Exception {
		String name = "CallableTaskTwo";
		Thread.sleep(3000);
		return name;
	}
}