package com.adobe.prj.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {
	
	// externalize this to "config.properties"
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/adobe_java";
	private static String USER = "root";
	private static String PWD = "Welcome123";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addProduct(Product p) throws DaoException {
		String SQL = "INSERT INTO products (id, name, price, quantity) VALUES (0, ?, ?, ?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps = con.prepareStatement(SQL); // Precompiled and cached
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate(); // insert, delete, or update
		} catch (SQLException e) {
			throw new DaoException("unable to add product " , e);
		} finally {
			if( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public List<Product> getProducts() throws DaoException {
		List<Product> products = new ArrayList<>();
		String SQL = "SELECT id, name, price, quantity FROM products";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				Product p = new Product(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getDouble("price"), 
						rs.getInt("quantity"));
				products.add(p);
			}
		} catch (SQLException e) {
			throw new DaoException("unable to get products " , e);
		} finally {
			if( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product p) throws DaoException {
		// TODO Auto-generated method stub

	}

}
