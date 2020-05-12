package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.dao.ProductDaoImpl;
import com.cts.product.entity.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ac = SpringApplication.run(Application.class, args);
		ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);

		Product p = new Product();
		p.setId(19);
		p.setName("Head Phone");
		p.setDescription("Sony Wireless");
		p.setPrice(15000);

		prodDao.saveProduct(p);

	}

}
