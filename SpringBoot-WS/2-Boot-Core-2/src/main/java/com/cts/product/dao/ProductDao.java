package com.cts.product.dao;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductDao {

	List<Product> listAll();

	Product findProductById(int id);

	void saveProduct(Product prod);

}
