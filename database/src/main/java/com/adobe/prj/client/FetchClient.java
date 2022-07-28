package com.adobe.prj.client;

import java.util.List;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.impl.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class FetchClient {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			List<Product> products = productDao.getProducts();
			for(Product p : products) {
				System.out.println(p.getName()  +", " + p.getPrice());
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
