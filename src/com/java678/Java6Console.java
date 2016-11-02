package com.java678;
import java.io.*;

//not working in IDE
public class Java6Console{
	public static void main(String[] args){
		Console c = System.console();
		String s = "";
		String string = "Español";
		System.out.println(string);
		System.console().printf("%s%n", string);
		char[] p = null;
			if(null != c){
				s = c.readLine("Enter name : ");
				p = c.readPassword("Enter Password : ");
			}	
		System.out.println(s);
		System.out.println(p);
	}
}	

