package com.practice;

public class SegmentTreeFirstExampleGFG {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;

		SegmentTree tree = new SegmentTree(arr, n);
		
		System.out.println("Segment tree is : ");
		for(int i=0;i<tree.st.length;i++){
			System.out.print(tree.st[i]+" ");
		}
		
		System.out.println("Sum is : ");
		System.out.println(tree.getSum(n,1,3));
	}

	static class SegmentTree {
		int[] st;

		public SegmentTree(int[] arr, int n) {
			int height = (int) Math.ceil(Math.log(n) / Math.log(2));
			int maxNodes = 2 * (int) Math.pow(2, height) - 1;

			st = new int[maxNodes];
			constructSegmentTree(arr, 0, n - 1, 0);
		}

		public int getSum(int n, int begin, int stop) {
			if(begin<0 || stop > n-1 || begin>stop){
				return -1;
			}
			return getSumUtil(0,n-1,begin,stop,0);
		}

		private int getSumUtil(int start, int end, int begin, int stop, int current) {
			if(begin<=start && stop>=end){
				return st[current];
			}
			
			if(begin>end || stop<start){
				return 0;
			}
			
			int mid = getMid(start, end);
			return getSumUtil(start, mid, begin, stop, 2*current+1)
					+getSumUtil(mid+1, end, begin, stop, 2*current+2);
		}

		private int constructSegmentTree(int[] arr, int start, int end, int current) {
			if (start == end) {
				st[current] = arr[start];
				return st[current];
			}

			int mid = getMid(start, end);
			st[current] = constructSegmentTree(arr, start, mid, 2 * current + 1)
					+ constructSegmentTree(arr, mid + 1, end, 2 * current + 2);
			return st[current];
		}

		private int getMid(int start, int end) {
			return start + (end - start) / 2;
		}

	}
}
