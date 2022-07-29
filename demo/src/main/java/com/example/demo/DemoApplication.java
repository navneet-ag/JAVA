package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.SampleService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private SampleService service;
	
	public static void main(String[] args) {
		 SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.doTask();
	}	

}
