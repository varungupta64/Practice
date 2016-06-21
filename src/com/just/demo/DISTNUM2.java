package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class DISTNUM2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		long n = Long.parseLong(input[0]);
		long q = Long.parseLong(input[1]);
		
		String[] arr = bf.readLine().trim().split(" ");
		long[] qArr = new long[(int)q+1];
		qArr[0] = 0;
		for(int i=1;i<=q;i++){
			String[] num = bf.readLine().trim().split(" ");
			long f = qArr[i-1];
			if(f < 0){
				f = 0;
			}
			long[] indices = getIndicesForQuery(Long.parseLong(num[0]),Long.parseLong(num[1]),Long.parseLong(num[2]),Long.parseLong(num[3]),f,Long.parseLong(num[4]),n);
			SortedSet<Long> set = new TreeSet<Long>();
			for(long v=indices[0]-1;v<=indices[1]-1;v++){
				set.add(Long.parseLong(arr[(int)v]));
			}
			if(set.toArray().length>=Integer.parseInt(num[4])){
				long res = (long)set.toArray()[Integer.parseInt(num[4])-1];
				System.out.println(res);
				qArr[i] = res;
			}else{
				System.out.println("-1");
				qArr[i] = -1;
			}
		}
	}

	private static long[] getIndicesForQuery(long a, long b, long c, long d,
			long f,long k,long n) {
		long[] arr = new long[2];
		arr[0] = (((a*f)+b)%n)+1;
		arr[1] = (((c*f)+d)%n)+1;
		if(arr[0]>arr[1]){
			long temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		return arr;
	}
}
