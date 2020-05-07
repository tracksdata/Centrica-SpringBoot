package com.cts.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> listAll() {
		System.out.println("--- dao: listig all products");
		return null;
	}

	@Override
	public Product findProductById(int id) {
		System.out.println("--- dao: finding product");
		return null;
	}

	@Override
	public void saveProduct(Product prod) {
		System.out.println("--- dao: saving product");
	}

}
