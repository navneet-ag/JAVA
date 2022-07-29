package com.example.demo.service;

public class EmailService {
	
	private String address;
	private int port;
	
	public EmailService(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	public void sendMessage(String msg) {
		System.out.println("Message " + msg + " sent to "  + address + ":" + port);
	}
}
