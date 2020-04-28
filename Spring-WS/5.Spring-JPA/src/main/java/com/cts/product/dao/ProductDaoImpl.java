package com.cts.product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.model.Product;

@Repository
public class ProductDaoImpl {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void saveProduct(Product prod) {

		em.persist(prod);

		System.out.println("Record saved... ");
	}

	// list all products

	@Transactional
	public List<Product> findAll() {
		
		String hqlQuery="from Product";
		
		Query qry=em.createQuery(hqlQuery);
	
		return qry.getResultList();

	}

}
