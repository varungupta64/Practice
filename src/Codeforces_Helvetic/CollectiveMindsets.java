package Codeforces_Helvetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectiveMindsets {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		if(n%2==0){
			System.out.println(n/2);
		}else{
			System.out.println(n/2+1);
		}
	}

}
