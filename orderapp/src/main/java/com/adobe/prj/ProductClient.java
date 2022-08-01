package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
public class ProductClient implements CommandLineRunner {

	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
//		printProducts();
//		addProduct();
//		update();
	}

	private void update() {
		service.updateProductPrice(399, 4);
		System.out.println("price updated!!!");
	}

	private void addProduct() {
		Product p = new Product(0, "Logitech Mouse", 890.00, 100);
		service.addProduct(p);
	}

	private void printProducts() {
		List<Product> products = service.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
