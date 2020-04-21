package com.cts.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.dao.ProductDaoImpl;
import com.cts.product.model.Product;

public class Test {

	public static void main(String[] args) {

		System.out.println("---- Started...");
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);

		Product product = new Product();
		product.setId(6);
		product.setName("Head-Phones");
		product.setDescription("Wireless");
		product.setPrice(14000);

		prodDao.saveProduct(product);

		prodDao.findAll().forEach((prod) -> {
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getPrice());
			System.out.println(prod.getDescription());
			System.out.println("------------------------------");
		});

	}

}
