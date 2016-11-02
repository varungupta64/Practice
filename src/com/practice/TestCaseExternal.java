package com.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TestCaseExternal {

	public static void main(String[] args) {
		try {

			File file = new File("/home/nagarro/Desktop/testCase.txt");

			if (!file.exists()) {
				file.createNewFile();
			} else {
				file.delete();
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);

			// logic
			bw.write("10000");
			bw.newLine();
			for (int i = 1; i <= 10000; i++) {
				bw.write("1000");
				bw.newLine();
				for (int j = 1; j <= 1000; j++) {
					bw.write(j + " ");
				}
				bw.newLine();
			}
			// logic

			bw.close();

		} catch (Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}

}
