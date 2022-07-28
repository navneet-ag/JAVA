package com.adobe.prj.client;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Double> map = new HashMap<>(16, 0.7f);
		map.put("Java", 1250.11);
		map.put("JavaScript", 9850.00);
		map.put("Python", 1250.11);
		map.put("Java", 7899.00); // replace old value
		map.put("Oracle", 1250.11);
		
		System.out.println(map.get("Python")); 
		
		map.forEach((key, value) -> {
			System.out.println(key  + " : " + value);
		});
	}

}
