package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

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
	
		System.out.println("*******");
		products.stream()
			.filter(p -> p.getCategory().equals("mobile")) 
			.forEach(p -> System.out.println(p));
		
		System.out.println("*******");
		
		products.parallelStream()
			.map(p -> p.getName())
			.forEach(p -> System.out.println(p));
		
		System.out.println("*******");
		
		
		List<Product> computers  = products.stream()
				.filter(p -> p.getCategory().equals("computer"))
				.collect(Collectors.toList());
		
		// pass computers to presentation tier
		
		computers.forEach(System.out::println); // method reference
		
//		computers.forEach(p ->System.out.println(p)); // method reference
		
		//Collections.sort(products);
//		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
//		
//		for(Product p : products) {
//			System.out.println(p);
//		}
		
		List<String> names = products.stream()
				.filter(p -> p.getCategory().equals("mobile"))
				.map(p -> p.getName())
				.collect(Collectors.toList());
		
		names.forEach(System.out::println);
		
		System.out.println("******** TOTAL COST of all PRODUCTS ********");
		
		double total =  products.stream()
					.map(p->p.getPrice())
					.reduce(0.0, (v1, v2) -> v1 + v2);
		
		System.out.println("Total " + total);
		
		System.out.println("******");
		
//		System.out.println( products.stream()
//					.mapToDouble(p->p.getPrice()).sum());
		
		DoubleSummaryStatistics stats = 
				products.stream().collect(Collectors.summarizingDouble(p -> p.getPrice()));
		
		System.out.println("Total " + stats.getSum());
		System.out.println("Avg : " + stats.getAverage());
		System.out.println("Count :" + stats.getCount());
		System.out.println("Max : " + stats.getMax());
		
	}

}
