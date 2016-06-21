package com.java;

import java.util.HashSet;
import java.util.Set;

class A {
	@Override
	public String toString() {
		return "A [i=" + i + ", s=" + s + "]";
	}

	public A(int i, String s) {
		super();
		this.i = i;
		this.s = s;
	}

	int i;
	String s;

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		A a = (A) obj;
		return this.s.equals(a.s);
	}
}

public class TestMap {
	public static void main(String[] args) {

		Set<A> s = new HashSet<A>();
		s.add(new A(5, "a"));
		s.add(new A(2, "b"));
		s.add(new A(7, "a"));

		System.out.println(s);
	}
}