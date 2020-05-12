package com.cts.product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl {

	@PersistenceContext
	private EntityManager em;
	
	public void saveProduct(Product prod) {
		em.persist(prod);
	}

	public List<Product> findAll() {

		String qry = "from Product";
		Query q = em.createQuery(qry);

		return q.getResultList();

	}

}
