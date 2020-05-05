package com.cts.product.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cts.product.entity.Product;

public interface ProductDao {

	void saveProduct(Product prod);

	public Product findById(int id);

	List<Product> findAll();
	
	public Product updateProduct(Product newPeoduct);
	public void deleteProduct(int id);

}