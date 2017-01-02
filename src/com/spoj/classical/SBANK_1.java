package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class SBANK_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		String[] arr;
		while (t-- > 0) {
			n = Integer.parseInt(bf.readLine().trim());
			arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = bf.readLine().trim();
			}
			// use merge sort here
			Arrays.sort(arr, new SBANK_Comparator());
			for (int i = 0; i < n; i++) {
				bw.write(arr[i]);
				bw.newLine();
			}
			bw.newLine();
			bf.readLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	public static void mergeSort(String[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(String[] s, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int index = i;
		
		while (i <= mid && j <= right) {
			String[] arr1 = s[i].split(" ");
			String[] arr2 = s[j].split(" ");
			if (Integer.parseInt(arr1[0]) > Integer.parseInt(arr2[0])) {
				s[index] = s[i];
				i++;
			} else if (Integer.parseInt(arr1[0]) < Integer.parseInt(arr2[0])) {
				s[index] = s[j];
				j++;
			} else {
				// 0th is equal
				if (Integer.parseInt(arr1[1]) > Integer.parseInt(arr2[1])) {
					s[index] = s[i];
					i++;
				} else if (Integer.parseInt(arr1[1]) < Integer.parseInt(arr2[1])) {
					s[index] = s[j];
					j++;
				} else {
					// 1st and 0th are equal
					if (Integer.parseInt(arr1[2]) > Integer.parseInt(arr2[2])) {
						s[index] = s[i];
						i++;
					} else if (Integer.parseInt(arr1[2]) < Integer.parseInt(arr2[2])) {
						s[index] = s[j];
						j++;
					} else {
						// 2nd and 1st and 0th are equal
						if (Integer.parseInt(arr1[3]) > Integer.parseInt(arr2[3])) {
							s[index] = s[i];
							i++;
						} else if (Integer.parseInt(arr1[3]) < Integer.parseInt(arr2[3])) {
							s[index] = s[j];
							j++;
						} else {
							// 3rd and 2nd and 1st and 0th are equal
							if (Integer.parseInt(arr1[4]) > Integer.parseInt(arr2[4])) {
								s[index] = s[i];
								i++;
							} else if (Integer.parseInt(arr1[4]) < Integer.parseInt(arr2[4])) {
								s[index] = s[j];
								j++;
							} else {
								// 4th and 3rd and 2nd and 1st and 0th are equal
								if (Integer.parseInt(arr1[5]) > Integer.parseInt(arr2[5])) {
									s[index] = s[i];
									i++;
								} else if (Integer.parseInt(arr1[5]) < Integer.parseInt(arr2[5])) {
									s[index] = s[j];
									j++;
								} else {
									// 5th and 4th and 3rd and 2nd and 1st and 0th
									// are equal
									return 0;
								}
							}
						}
					}
				}
			}
			
			index++;
		}
	}
}

class SBANK1_Comparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		String[] arr1 = s1.split(" ");
		String[] arr2 = s2.split(" ");
		if (Integer.parseInt(arr1[0]) > Integer.parseInt(arr2[0])) {
			return 1;
		} else if (Integer.parseInt(arr1[0]) < Integer.parseInt(arr2[0])) {
			return -1;
		} else {
			// 0th is equal
			if (Integer.parseInt(arr1[1]) > Integer.parseInt(arr2[1])) {
				return 1;
			} else if (Integer.parseInt(arr1[1]) < Integer.parseInt(arr2[1])) {
				return -1;
			} else {
				// 1st and 0th are equal
				if (Integer.parseInt(arr1[2]) > Integer.parseInt(arr2[2])) {
					return 1;
				} else if (Integer.parseInt(arr1[2]) < Integer.parseInt(arr2[2])) {
					return -1;
				} else {
					// 2nd and 1st and 0th are equal
					if (Integer.parseInt(arr1[3]) > Integer.parseInt(arr2[3])) {
						return 1;
					} else if (Integer.parseInt(arr1[3]) < Integer.parseInt(arr2[3])) {
						return -1;
					} else {
						// 3rd and 2nd and 1st and 0th are equal
						if (Integer.parseInt(arr1[4]) > Integer.parseInt(arr2[4])) {
							return 1;
						} else if (Integer.parseInt(arr1[4]) < Integer.parseInt(arr2[4])) {
							return -1;
						} else {
							// 4th and 3rd and 2nd and 1st and 0th are equal
							if (Integer.parseInt(arr1[5]) > Integer.parseInt(arr2[5])) {
								return 1;
							} else if (Integer.parseInt(arr1[5]) < Integer.parseInt(arr2[5])) {
								return -1;
							} else {
								// 5th and 4th and 3rd and 2nd and 1st and 0th
								// are equal
								return 0;
							}
						}
					}
				}
			}
		}
	}
}