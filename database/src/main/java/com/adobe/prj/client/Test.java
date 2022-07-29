package com.adobe.prj.client;

import com.adobe.prj.entity.Product;
import com.adobe.prj.util.SQLUtil;

public class Test {

	public static void main(String[] args) {
		String SQL = SQLUtil.generateCreateStatement(Product.class);
		System.out.println(SQL);
	}

}
