package com.java678;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.sql.SQLException;

import com.practice.SegmentTree;

public class ServiceLoaderJava6 {
	public static void main(String[] args) {
		int a = 0b100;
		long cardNum = 1919_9898;
		System.out.println(a);
		System.out.println(cardNum);
		
		try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
			Class c = SegmentTree.class;
			Method[] m = c.getDeclaredMethods();
			for(Method method : m){
				System.out.println(method);
			}
			throw new ArithmeticException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("In Exception catch");
			throw e;
		}
		
			try {
				if (Math.random() < 0.5)
					throw new IOException("cannot copy to file");
				else
					throw new SQLException("cannot copy to database");
			} catch (IOException | SQLException ex) {
				//ex = new Exception("Copy Complete");
				System.out.println(ex.getMessage());
			}
	}
}