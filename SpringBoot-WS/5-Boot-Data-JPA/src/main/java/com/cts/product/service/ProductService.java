package com.cts.product.service;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductService {

	public Product savePeroduct(Product product);

	public Product findProductById(long id);

	public List<Product> findAll();

	public void deleteProduct(long id);

	public Product updateProduct(Product newProduct);

	List<Product> findProductByNameLike(String name);

	List<Product> findProductByPriceBetween(double startRange, double endRange);

	public List<Product> findProductsByName(String pname);
}
