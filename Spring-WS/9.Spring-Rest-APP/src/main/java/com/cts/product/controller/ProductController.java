package com.cts.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@RestController
@RequestMapping("api/products")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductDao prodDao;

	@RequestMapping(value = "/s1", method = RequestMethod.GET)
	public String f1() {
		return "Welcome to my App";
	}

	@GetMapping("/s2")
	public String f2() {
		return "Welcome V2";
	}

	// find a product
	@GetMapping("/{id}")
	public Product f3(@PathVariable("id") int id) {
		return prodDao.findById(id);
	}

	// List All Products

	@GetMapping
	public List<Product> findAll() {
		return prodDao.findAll();
	}

	// update object

	@PutMapping
	public Product upfdateProduct(@RequestBody Product prod) {
		return prodDao.updateProduct(prod);
		
	}

}
