package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

public class HashStory {

	public static void main(String[] args) {
		Product p1 = new Product(834, "Logitech Mouse", 600.00, "computer");
		Product p2 = new Product(834, "Logitech Mouse", 600.00, "computer");
		
		Product ref  = p1;
		
		if(ref == p1) {
			System.out.println("Ref and p1 same reference");
		}
		
		if(p1 == p2) {
			System.out.println("p2 and p1 same reference");
		}
		
		if(p1.equals(p2)) {
			System.out.println("Same content!!!");
		}
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		if(s1.equals(s2)) {
			System.out.println("same!!!");
		}
		
		System.out.println("******* HASHCODE *******");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		String s3 = "Aa";
		String s4 = "BB";
		
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
	}

}
