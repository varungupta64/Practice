package com.just.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class FORESTGA {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" "); 
		long n = Long.parseLong(input[0]);
		long w = Long.parseLong(input[1]);
		long l = Long.parseLong(input[2]);
		
		Map<Long,Long[]> map = new TreeMap<>();
		for(int i=0;i<n;i++){
			String[] num = bf.readLine().trim().split(" ");
			long h = Long.parseLong(num[0]);
			long r = Long.parseLong(num[1]);
			long key = l/r;
			/*
			 * for cases where, e.g.
			 *  h -> 7
			 * r -> 7
			 * l -> 49
			 * key -> 7
			 */
			if(key > 0){
				key--;
			}
			long cal = h + r * key;
			
			while(cal < l){
				key++;
				cal+=r;
			}
			
			if(map.containsKey(key)){
				Long[] arr = new Long[2];
				arr[0] = map.get(key)[0] + cal;
				arr[1] = map.get(key)[1] + r;
				map.put(key, arr);
			}else {
				Long[] arr = new Long[2];
				arr[0] = cal;
				arr[1] = r;
				map.put(key, arr);
			}
		}

		long result = 0;
		long months = 0;
		long incrementBy = 0;
		
		Set<Map.Entry<Long, Long[]>> set = map.entrySet();
		Iterator<Map.Entry<Long, Long[]>> it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry<Long, Long[]> m = it.next();
			months = m.getKey();
			result = m.getValue()[0];
			incrementBy = m.getValue()[1];
			break;
		}
		
		while(result<w){
			months++;
			if(map.containsKey(months)){
				result+=map.get(months)[0]+incrementBy;
				incrementBy+=map.get(months)[1];
			}else{
				result+=incrementBy;
			}
		}
		
		System.out.println(months);
	}
}