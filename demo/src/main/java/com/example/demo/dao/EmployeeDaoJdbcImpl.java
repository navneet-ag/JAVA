package com.example.demo.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("emp stored in rdbms!!!");
	}

}
