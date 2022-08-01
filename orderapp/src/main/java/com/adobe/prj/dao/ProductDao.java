package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
//	@Query(value = "select * from products where price >= :low and price <= :high", nativeQuery = true)
	@Query("from Product where price >= :low and price <= :high")
	List<Product> fetchByRange(@Param("low") double lower, @Param("high") double higher);
	
	@Modifying
	@Query("update Product set price = :pr where id = :id")
	void updatePrice(@Param("pr") double price,  @Param("id") int id);
}
