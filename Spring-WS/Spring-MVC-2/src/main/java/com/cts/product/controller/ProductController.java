package com.cts.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao prodDao;

	@RequestMapping("/")
	public String welocme() {
		return "index";
	}

	// load Product Form Page

	@RequestMapping("/loadProductForm")
	public String loadProductForm() {
		return "productform";
	}

	// save Product Data to DB

	@RequestMapping("/saveProduct")
	public String saveProduct(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("price") double price, @RequestParam("description") String description) {
		Product prod = new Product();
		prod.setId(id);
		prod.setName(name);
		prod.setPrice(price);
		prod.setDescription(description);

		prodDao.saveProduct(prod);

		return "productform";
	}
	
	@RequestMapping("/saveProductV2")
	public String saveproductV2(@ModelAttribute Product prod,Model data) {
		
		prodDao.saveProduct(prod);
		
		data.addAttribute("msg", "Product Saved Successfully");
		
		
		return "productform";
	}
	
	
	// List all produst to jsp
	
	@RequestMapping("/listAll")
	public String listAll(Model data) {
		
		List<Product> prods=prodDao.findAll();
		
		data.addAttribute("prods", prods);
		
		return "products";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
