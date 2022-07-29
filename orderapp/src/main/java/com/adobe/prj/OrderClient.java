package com.adobe.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
public class OrderClient implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
		placeOrder();
	}

	private void placeOrder() {
		Order order = new Order();
		Customer c = new Customer();
		c.setEmail("b@adobe.com");
		order.setCustomer(c); // order is placed by
		
		Product p1 = new Product();
		p1.setId(3);
		Item i1 = new Item();
		i1.setProduct(p1);
		i1.setQty(2);
		
		Product p2 = new Product();
		p2.setId(1);
		Item i2 = new Item();
		i2.setProduct(p2);
		i2.setQty(1);
		
		order.getItems().add(i1);
		order.getItems().add(i2);
		
		service.placeOrder(order);
	}

}
