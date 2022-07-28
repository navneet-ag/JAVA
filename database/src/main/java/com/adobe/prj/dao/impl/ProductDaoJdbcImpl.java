package com.adobe.prj.dao.impl;

import java.sql.Connection;
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
	
	@Override
	public void addProduct(Product p) throws DaoException {
		String SQL = "INSERT INTO products (id, name, price, quantity) VALUES (0, ?, ?, ?)";
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL); // Precompiled and cached
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate(); // insert, delete, or update
		} catch (SQLException e) {
			throw new DaoException("unable to add product " , e);
		} finally {
			DBUtil.closeConnection(con);
		}
	}

	@Override
	public List<Product> getProducts() throws DaoException {
		List<Product> products = new ArrayList<>();
		String SQL = "SELECT id, name, price, quantity FROM products";
		Connection con = null;
		try {
			  con = DBUtil.getConnection();
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
			throw new DaoException("unable to get products ", e);
		} finally {
			DBUtil.closeConnection(con);
		}
		return products;
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		String SQL = "SELECT id, name, price, quantity FROM products WHERE id = ?";
		return null;
	}

	@Override
	public void updateProduct(Product p) throws DaoException {
		String SQL = "UPDATE products set price = ?, quantity = ? WHERE id  = ?";
	}

}
