package com.cts.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	private JdbcTemplate jt;

	public void saveProduct(Product prod) {
		String qry = "insert into product values(?,?,?,?)";
		jt.update(qry, prod.getId(), prod.getDescription(), prod.getName(), prod.getPrice());
	}

	public List<Product> findAll() {

		return null;
	}

}
