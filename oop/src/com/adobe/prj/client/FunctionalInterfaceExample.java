package com.adobe.prj.client;

import java.util.function.Predicate;

public class FunctionalInterfaceExample {
	
	public static int[] filter(int[] elems, Predicate<Integer> predicate) {
		int[] result = new int[elems.length];
		int i = 0;
		for(int elem : elems) {
			if(predicate.test(elem)) {
				result[i++] = elem;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] data = {5,6,1,2,3,9,12,15};
		int[] output = filter(data, e -> e % 2 == 0);
		for(int no : output) {
			System.out.println(no);
		}
	}

}
