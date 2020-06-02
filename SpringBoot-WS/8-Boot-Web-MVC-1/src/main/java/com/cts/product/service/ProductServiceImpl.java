package com.cts.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;

	@Override
	public Product savePeroduct(Product product) {
		// TODO Auto-generated method stub
		return prodDao.save(product);
	}

	@Override
	public Product findProductById(long id) {
		// TODO Auto-generated method stub
		return prodDao.findById(id).orElse(null);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return prodDao.findAll();
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		prodDao.deleteById(id);

	}

	@Override
	public Product updateProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return prodDao.save(newProduct);
	}

	@Override
	public List<Product> findProductByNameLike(String name) {
		// TODO Auto-generated method stub
		return prodDao.findProductByNameLike(name);
	}

	@Override
	public List<Product> findProductByPriceBetween(double startRange, double endRange) {
		// TODO Auto-generated method stub
		return prodDao.findProductByPriceBetween(startRange, endRange);
	}

	@Override
	public List<Product> findProductsByName(String pname) {
		// TODO Auto-generated method stub
		return prodDao.findProductsByName(pname);
	}

}
