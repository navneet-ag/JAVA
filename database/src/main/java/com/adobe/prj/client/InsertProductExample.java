package com.adobe.prj.client;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.impl.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class InsertProductExample {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			 Product p = new Product(0, "iPad", 35000.00, 500);
			 productDao.addProduct(p);
			 System.out.println("Product added successfully!!!");
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
