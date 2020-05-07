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
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return prodDao.listAll();
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return prodDao.findProductById(id);
	}

	@Override
	public void saveProduct(Product prod) {
		prodDao.saveProduct(prod);
		// TODO Auto-generated method stub

	}

}
