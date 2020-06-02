package com.cts.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/s1")
	public void test() {
		System.out.println("====> ProductCOntroller fromm String boot");
	}

	@RequestMapping("/s2")
	public String test1() {
		System.out.println("=====> test1 method <=====");
		return "one";
	}

}
