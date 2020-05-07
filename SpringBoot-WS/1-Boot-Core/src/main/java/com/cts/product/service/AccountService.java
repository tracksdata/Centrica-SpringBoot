package com.cts.product.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	public AccountService() {
		System.out.println("AccountService class object created...");
	}

	public void f1() {
		System.out.println("--- AccountService f1 method");
	}
}
