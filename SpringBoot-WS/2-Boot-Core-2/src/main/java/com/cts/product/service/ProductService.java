package com.cts.product.service;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductService {

	List<Product> listAll();

	Product findProductById(int id);

	void saveProduct(Product prod);
}
