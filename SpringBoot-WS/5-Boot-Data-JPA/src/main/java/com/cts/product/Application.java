package com.cts.product;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);
		ProductService ps = ac.getBean(ProductService.class);

		/*
		for (Product prod : ps.findAll()) {
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getDescription());
			System.out.println(prod.getPrice());
			System.out.println("----------------------------------");
		}
		*/
		
		/*
		Product prod=ps.findProductById(10);
		System.out.println(prod.getId());
		System.out.println(prod.getName());
		System.out.println(prod.getDescription());
		System.out.println(prod.getPrice());
		System.out.println("----------------------------------");
		
		*/
		
	/*
		Product prod=new Product();
		prod.setId(20);
		prod.setName("Guchi Bag");
		prod.setPrice(16000);
		prod.setDescription("Red Bag");
		
		ps.savePeroduct(prod);
		
	*/
		
		//List<Product> prods=ps.findProductByNameLike("%e%");
		//List<Product> prods=ps.findProductByPriceBetween(5000, 20000);
		List<Product> prods=ps.findProductsByName("%e");
		for (Product prod : prods) {
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getDescription());
			System.out.println(prod.getPrice());
			System.out.println("----------------------------------");
		}
		
		
		
		
	}

}
