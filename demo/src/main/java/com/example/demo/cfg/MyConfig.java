package com.example.demo.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.EmailService;

@Configuration
public class MyConfig {

	// factory method
	@Bean
	public EmailService emailService () {
		return new EmailService("127.100.25.12", 120);
				
	}
}
