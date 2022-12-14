package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.ReportDTO;
import com.adobe.prj.service.OrderService;

@Component
public class OrderClient implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
//		placeOrder();
		
//		getOrders();
		
//		getReport();
	}

	private void getReport() {
		List<ReportDTO> reports = service.getOrderReport();
		for(ReportDTO report : reports) {
			System.out.println(report.getOrderDate() +"," + report.getTotal() + "," + report.getFirstName());
		}
	}

	private void getOrders() {
		List<Order> orders = service.getOrders();
		for(Order o : orders) {
			System.out.println("Order Date : " + o.getOrderDate());
			System.out.println("Customer Email:" + o.getCustomer().getEmail());
			System.out.println("Total : " + o.getTotal());
			System.out.println("Items:");
			List<Item> items = o.getItems();
			for(Item item : items) {
				System.out.println("Product " + item.getProduct().getName());
				System.out.println("Qty " + item.getQty());
				System.out.println("Amount " + item.getAmount());
			}
		}
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
