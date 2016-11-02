package com.java678;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

import com.practice.SegmentTree;
/*
 * Reflection (java.lang.reflect): The following methods in java.lang.Class were generified:
getInterfaces() , getClasses() . getConstructors() . getMethod(String,
Class...) , getConstructor(Class...) , getDeclaredClasses() ,
getDeclaredConstructors() , getDeclaredMethod(String, Class...) , and
getDeclaredConstructor(Class...) . as a result, code which uses these methods now
produces warnings during compilation.
 */

/*
 * To remove the warning, the declaration of c should be modified to include an appropriate
generic type. In this case, the declaration should be:
Class<?> c = warn.getClass();
 */

/*
 * The final parameter of Array.newInstance(Class, int...) is of variable
argument.
 */
public class ReflectionJava6 {

	public static void main(String[] args) {
		int[] arr = new int[1];
		SegmentTree seg = new SegmentTree(arr, 1);
		Class<?> c = seg.getClass();
		Method[] a = c.getDeclaredMethods();
		for (Method m : a) {
			System.out.println(m.getName());
		}

		Array.newInstance(SegmentTree.class, 2, 3);
	}

}
