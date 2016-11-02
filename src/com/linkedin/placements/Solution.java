package com.linkedin.placements;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int res;
		String _s;
		try {
			_s = in.nextLine();
		} catch (Exception e) {
			_s = null;
		}

		res = replacements(_s);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();
	}

	/*
	 * Complete the function below.
	 */

	static int replacements(String s) {
		int i = 0;
		int j = s.length() - 1;
		int replacements = 0;
		boolean hasLinkedIn = false;
		boolean hasL = false;
		boolean hasI = false;
		boolean hasN = false;
		boolean hasK = false;
		boolean hasE = false;
		boolean hasD = false;
		boolean hasI2 = false;
		boolean hasN2 = false;
		char[] arr = s.toCharArray();
		while (i < j) {

			if (arr[i] == arr[j]) {
				// do nothing
				if (hasLinkedIn) {
					i++;
					j--;
					continue;
				}

				if (!hasL && arr[i] == 'l') {
					hasL = true;
					i++;
					j--;
					continue;
				}

				if (hasL) {
					if (hasI) {
						if (hasN) {
							if (hasK) {
								if (hasE) {
									if (hasD) {
										if (hasI2) {
											if (hasN2) {
												hasL = false;
												hasI = false;
												hasN = false;
												hasK = false;
												hasE = false;
												hasD = false;
												hasI2 = false;
												hasN2 = false;
												hasLinkedIn = true;
											}else if (arr[i] != 'n') {
												arr[i] = 'n';
												arr[j] = 'n';
												replacements = replacements + 2;
												hasL = false;
												hasI = false;
												hasN = false;
												hasK = false;
												hasE = false;
												hasD = false;
												hasI2 = false;
												hasN2 = false;
												hasLinkedIn = true;
											}else{
												hasL = false;
												hasI = false;
												hasN = false;
												hasK = false;
												hasE = false;
												hasD = false;
												hasI2 = false;
												hasN2 = false;
												hasLinkedIn = true;
											}
										} else if (arr[i] != 'i') {
											arr[i] = 'i';
											arr[j] = 'i';
											replacements = replacements + 2;
											hasI2 = true;
										}else{
											hasI2 = true;
										}
									} else if (arr[i] != 'd') {
										arr[i] = 'd';
										arr[j] = 'd';
										replacements = replacements + 2;
										hasD = true;
									}else{
										hasD = true;
									}
								} else if (arr[i] != 'e') {
									arr[i] = 'e';
									arr[j] = 'e';
									replacements = replacements + 2;
									hasE = true;
								}else{
									hasE = true;
								}
							} else if (arr[i] != 'k') {
								arr[i] = 'k';
								arr[j] = 'k';
								replacements = replacements + 2;
								hasK = true;
							}else{
								hasK = true;
							}
						} else if (arr[i] != 'n') {
							arr[i] = 'n';
							arr[j] = 'n';
							replacements = replacements + 2;
							hasN = true;
						}else{
							hasN = true;
						}
					} else if (arr[i] != 'i') {
						arr[i] = 'i';
						arr[j] = 'i';
						replacements = replacements + 2;
						hasI = true;
					}else{
						hasI = true;
					}
				}
			} else {

				if (hasLinkedIn) {

					arr[i] = arr[j];
					replacements++;

				} else if (arr[i] == 'l' || arr[j] == 'l') {
					arr[i] = 'l';
					arr[j] = 'l';
					hasL = true;
					replacements++;
				} else {

					if (hasL) {
						if (hasI) {
							if (hasN) {
								if (hasK) {
									if (hasE) {
										if (hasD) {
											if (hasI2) {
												if (hasN2) {
													hasLinkedIn = true;
													hasL = false;
													hasI = false;
													hasN = false;
													hasK = false;
													hasE = false;
													hasD = false;
													hasI2 = false;
													hasN2 = false;
												} else if (arr[i] == 'n' || arr[j] == 'n') {
													arr[i] = 'n';
													arr[j] = 'n';
													hasL = false;
													hasI = false;
													hasN = false;
													hasK = false;
													hasE = false;
													hasD = false;
													hasI = false;
													hasN = false;
													hasLinkedIn = true;
													replacements++;
												} else {
													arr[i] = 'n';
													arr[j] = 'n';
													replacements = replacements + 2;
													hasL = false;
													hasI = false;
													hasN = false;
													hasK = false;
													hasE = false;
													hasD = false;
													hasI = false;
													hasN = false;
													hasLinkedIn = true;
												}
											} else if (arr[i] == 'i' || arr[j] == 'i') {
												arr[i] = 'i';
												arr[j] = 'i';
												hasI2 = true;
												replacements++;
											} else {
												arr[i] = 'i';
												arr[j] = 'i';
												hasI2 = true;
												replacements = replacements + 2;
											}
										} else if (arr[i] == 'd' || arr[j] == 'd') {
											arr[i] = 'd';
											arr[j] = 'd';
											hasD = true;
											replacements++;
										} else {
											arr[i] = 'd';
											arr[j] = 'd';
											hasD = true;
											replacements = replacements + 2;
										}

									} else if (arr[i] == 'e' || arr[j] == 'e') {
										arr[i] = 'e';
										arr[j] = 'e';
										hasE = true;
										replacements++;
									} else {
										arr[i] = 'e';
										arr[j] = 'e';
										hasE = true;
										replacements = replacements + 2;
									}

								} else if (arr[i] == 'k' || arr[j] == 'k') {
									arr[i] = 'k';
									arr[j] = 'k';
									hasK = true;
									replacements++;
								} else {
									arr[i] = 'k';
									arr[j] = 'k';
									hasK = true;
									replacements = replacements + 2;
								}

							} else if (arr[i] == 'n' || arr[j] == 'n') {
								arr[i] = 'n';
								arr[j] = 'n';
								hasN = true;
								replacements++;
							} else {
								arr[i] = 'n';
								arr[j] = 'n';
								hasN = true;
								replacements = replacements + 2;
							}

						} else if (arr[i] == 'i' || arr[j] == 'i') {
							arr[i] = 'i';
							arr[j] = 'i';
							hasI = true;
							replacements++;
						} else {
							arr[i] = 'i';
							arr[j] = 'i';
							hasI = true;
							replacements = replacements + 2;
						}

					} else {
						arr[i] = arr[j];
						replacements++;
						hasL = false;
					}

				}

			}

			i++;
			j--;

		}
		return replacements;
	}
}
