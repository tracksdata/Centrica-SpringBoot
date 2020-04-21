package com.cts.product.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.model.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	private SessionFactory sf;

	@Transactional
	public void saveProduct(Product prod) {

		sf.getCurrentSession().save(prod);

		System.out.println("Record saved... ");
	}

	// list all products

	@Transactional
	public List<Product> findAll() {
		
		String hqlQuery="from Product";
		
		Query<Product> qry=sf.getCurrentSession().createQuery(hqlQuery);
	
		return qry.getResultList();

	}

}
