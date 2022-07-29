package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;

@Service
public class SampleService {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmployeeDao empDao;
	
	public void doTask() {
		this.empDao.addEmployee();
		emailService.sendMessage("employee added");
	}
}
