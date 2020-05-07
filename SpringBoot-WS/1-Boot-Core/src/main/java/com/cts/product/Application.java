package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.service.AccountService;

@SpringBootApplication
//@ComponentScan("com.cts")
public class Application {

	public static void main(String[] args) {
		System.out.println("---- Starting boot");
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		
		AccountService as= ac.getBean(AccountService.class);
		as.f1();
		
	}

}
