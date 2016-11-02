package com.cf.round370div2;

import java.util.Arrays;
import java.util.Scanner;

public class D_20513110
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b = in.nextInt(), k = in.nextInt(), t = in.nextInt();
		int M = 1000000007;
		int[] arr = new int[k+1];
		arr[0] = 1;
		for (int i = 1; i <= t; ++i)
		{
			int[] newarr = new int[i*k+1];
			int qsize = 0, qL = 0, qR = 0, q = 0;
			for (int j = 0; j < newarr.length; ++j)
			{
				qR = j;
				int qRind = qR < arr.length ? qR : (arr.length - 1 - (qR-arr.length+1));
				q = (q + arr[qRind]) % M;
				qsize++;
				if (qsize > 2*k+1) {
					q = (q + M - arr[qL]) % M;
					qL++;
				}
				newarr[j] = q;
			}
			arr = newarr;
		}
		int[] cnts = new int[2*arr.length -1];
		for (int i =0 ; i < cnts.length; ++i) cnts[i] = i  < arr.length ? arr[i] : arr[arr.length-1-(i-arr.length+1)];
		int[] sums = new int[cnts.length];
		sums[0] = cnts[0];
		for (int i = 1; i < sums.length; ++i) sums[i] = (cnts[i] + sums[i-1]) % M;
		int zero = arr.length, ret = 0;
		for (int Lexa = 0; Lexa < cnts.length; ++Lexa)
		{
			int Memory = Lexa + b-a+1;
			if (Memory >= cnts.length) break;
			Memory = Math.max(Memory, 0);
			long LexaN = cnts[Lexa];
			long MemoryN = Memory == 0 ? sums[sums.length-1] : (sums[sums.length-1]-sums[Memory-1] + M)%M;
			int val = (int)(( LexaN * MemoryN) %M);
			ret = (ret + val) % M;
		}
		System.out.println(ret);
	}
}
