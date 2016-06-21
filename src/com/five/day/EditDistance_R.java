package com.five.day;

public class EditDistance_R {

	public static void main(String[] args) {
		String one = "sunday";
		String two = "saturday";

		int m = one.length();
		int n = two.length();

		System.out.println(ed(one.toCharArray(), two.toCharArray(), m, n));
	}

	private static int ed(char[] one, char[] two, int m, int n) {
		if (m == 0 || n == 0) {
			return max(m, n);
		}else if(one[m-1]==two[n-1]){
			return ed(one,two,m-1,n-1);
		}else{
			return 1+min(ed(one,two,m,n-1),min(ed(one,two,m-1,n),ed(one,two,m-1,n-1)));
		}
	}

	private static int min(int ed1, int ed2) {
		return ed1<ed2?ed1:ed2;
	}

	private static int max(int m, int n) {
		if (m == n) {
			return 0;
		}
		return m > n ? m : n;
	}
}
