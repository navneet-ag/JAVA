package com.adobe.prj.client;

import java.lang.reflect.Method;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[5]; // Array of 5 Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
		
		displayExpensive(products);
		
//		displayDetails(products);
		
		displayDetailsOCP(products);
		
	}

	// OCP using Reflection API
	private static void displayDetailsOCP(Product[] products) {
		for(Product p : products) {
			System.out.println("***********");
			Method[] methods = p.getClass().getMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					try {
						Object ret = m.invoke(p);
						System.out.println(m.getName().substring(3).toUpperCase() + " : " + ret);
					} catch(Exception ex) { ex.printStackTrace(); }
				}
			}
			System.out.println("***********");
		}
	}

	// IS this OCP?
	private static void displayDetails(Product[] products) {
		for(Product p : products) {
			System.out.println("**********");
			System.out.println(p.getName() + "," + p.getPrice());
			// type checking
			if(p instanceof Tv) {
				Tv t = (Tv) p; // downcasting
				System.out.println(t.getScreenType());
			}
			if(p.getClass() == Mobile.class) { // strict type checking
				Mobile m = (Mobile) p;
				System.out.println(m.getConnectivity());
			}
			System.out.println("**********");
		}
	}

	// OCP
	private static void displayExpensive(Product[] products) {
		for(Product p : products) {
			if(p.isExpensive()) { // dynamic binding - polymorphism
				System.out.println(p.getName() + " is expensive !!!");
			} else {
				System.out.println(p.getName() + " is not expensive !!!");
			}
		}
	}

}
