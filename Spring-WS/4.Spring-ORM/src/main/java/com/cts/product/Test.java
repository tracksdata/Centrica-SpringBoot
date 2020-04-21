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

		ProductDaoImpl prodDao= ac.getBean(ProductDaoImpl.class);
		
		Product prod=new Product();
		prod.setId(7);
		prod.setName("Remote Car");
		prod.setDescription("Toy Game");

		prod.setPrice(6553);
		
		//prodDao.saveProduct(prod);
		
		prodDao.findAll().forEach((product)->{
			System.out.println(product.getName());
		});
		
		
	}

}
