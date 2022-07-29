package com.example.demo.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.EmailService;

@Configuration
public class MyConfig {
	@Value("${address}")
	private String address;
	
	@Value("${port}")
	private int port;
	
	// factory method
	@Bean
	public EmailService emailService () {
		return new EmailService(address, port);
				
	}
}
