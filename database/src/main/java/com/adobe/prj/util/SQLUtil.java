package com.adobe.prj.util;

import java.lang.reflect.Method;

import com.adobe.prj.entity.Column;
import com.adobe.prj.entity.Table;

public class SQLUtil {
	// Product.class
	public static String generateCreateStatement(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		Table table = clazz.getAnnotation(Table.class);
		if( table != null) {
			builder.append("create table " + table.name()); // create table products
			builder.append("(");
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m : methods) {
				Column col = m.getAnnotation(Column.class);
				if(col != null) {
					builder.append(col.name());
					builder.append(" ");
					builder.append(col.type());
					builder.append(", ");
				}
			}
		}
		builder.setCharAt(builder.lastIndexOf(","), ')');
		return builder.toString();
	}
}
