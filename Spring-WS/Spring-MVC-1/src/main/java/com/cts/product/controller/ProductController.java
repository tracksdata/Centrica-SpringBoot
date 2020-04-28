package com.cts.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.entity.Product;

@Controller
public class ProductController {

	@RequestMapping(value = "/s1")
	public void sayHello() {
		System.out.println("--- Hello from Spring Web MVC......");
	}

	@RequestMapping(value = "/s2")
	public String f2() {
		System.out.println("--- f2 megthod");
		return "one";
	}

	@RequestMapping("s3")
	public String f3(Model data) {
		// Model interface adds data into request scope
		String name = "Praveen";
		data.addAttribute("personName", name);
		return "two";
	}

	@RequestMapping("s4")
	public ModelAndView f4() {
		ModelAndView mav = new ModelAndView();

		String city = "Hyderabad";

		mav.setViewName("three");
		mav.addObject("cityName", city);

		return mav;
	}
	
	@RequestMapping("/findAll")
	public ModelAndView listProducts() {
		
		Product p1=new Product(10, "Pen", "Blue Ink", 762);
		Product p2=new Product(11, "Book", "white pages", 630);
		Product p3=new Product(12, "Mobile", "Samsung S20", 12000);
		Product p4=new Product(13, "Laptop", "Dell Laptop I7", 75000);
		Product p5=new Product(14, "Mouse", "Wireless Mouse", 1200);
		
		
		
		ModelAndView mav=new ModelAndView();
		
		
		mav.setViewName("products");
		//mav.addObject("product", p2); // adds p1 into request scope
		
		List<Product> products=new ArrayList<Product>();
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		mav.addObject("prods", products);
		
		
		return mav;
		
	}
	
	
	
	
	
	
	
	

}
