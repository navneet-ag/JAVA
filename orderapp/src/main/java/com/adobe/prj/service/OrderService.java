package com.adobe.prj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao; // wire class genereted by Spring Data JPA
	
	@Autowired
	private CustomerDao customerDao; // wire class genereted by Spring Data JPA
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	public Product getProductById(int id) {
		return productDao.findById(id).get();
	}
	
	public Customer addCustomer(Customer c) {
		return customerDao.save(c);
	}
}
