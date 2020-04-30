package com.cts.product.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cts.product.entity.Product;


public interface ProductDao {

	void saveProduct(Product prod);

	List<Product> findAll();

}