package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	@Autowired
	private ProductService ps;

	@GetMapping
	public List<Product> f1() {
		return ps.findAll();
	}

	@GetMapping("/{id}")
	public Product f1v1(@PathVariable int id) {
		Product prod = ps.findProductById(id);
		if (prod != null) {
			return prod;
		}
		return null;
	}

	@GetMapping("/byName/{name}")
	public List<Product> findByName(@PathVariable String name) {
		return ps.findProductByNameLike("%" + name + "%");
	}

	@PostMapping
	public Product f2(@RequestBody Product prod) {
		return ps.savePeroduct(prod);
	}

	@PutMapping
	public Product f3(@RequestBody Product prod) {

		return ps.savePeroduct(prod);
	}

	@DeleteMapping("/{id}")
	public String f4(@PathVariable int id) {
		System.out.println("====> ID: " + id);
		ps.deleteProduct(id);
		return "Product is deleted";
	}

	@PatchMapping
	public String f5() {
		return "PATCH HTTP request Data";
	}

}
