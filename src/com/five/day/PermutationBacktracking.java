package com.five.day;

public class PermutationBacktracking {

	public static void main(String[] args) {
		char[] str = "ABC".toCharArray();
		int n = str.length;
	    permute(str, 0, n-1);
	}
	
	public static void permute(char[] a, int l, int r)
	{
	   int i;
	   if (l == r)
	     System.out.println(a);
	   else
	   {
	       for (i = l; i <= r; i++)
	       {
	          swap(l, i, a);
	          permute(a, l+1, r);
	          swap(l, i, a); //backtrack
	       }
	   }
	}
	
	public static void swap(int x, int y, char[] a)
	{
	    char temp;
	    temp = a[x];
	    a[x] = a[y];
	    a[y] = temp;
	}

}
