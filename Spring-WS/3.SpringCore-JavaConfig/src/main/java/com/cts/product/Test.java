package com.cts.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.service.BillingService;

public class Test {

	public static void main(String[] args) {
		System.out.println("===> main method <===");
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		String[] cart1 = { "Item01", "Item02", "Item03" };
		String[] cart2 = { "Item04", "Item05" };

		BillingService billingService = ac.getBean(BillingService.class);

		double totalPayable = billingService.getCartTotal(cart1);
		System.out.println("Cart1 Total Payable: " + totalPayable);

		totalPayable = billingService.getCartTotal(cart2);
		System.out.println("Cart2 Total Payable: " + totalPayable);

	}

}
