package com.just.demo;

import java.util.concurrent.Callable;

public class CallableTaskOne implements Callable<String>{
	@Override
	public String call() throws Exception {
		String name = "CallableTaskOne";
		Thread.sleep(2000);
		return name;
	}
}