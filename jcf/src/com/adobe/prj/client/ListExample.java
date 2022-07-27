package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.adobe.prj.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer")); // supports duplicate elements
	
		//Collections.sort(products);
		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
