package com.cts.product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sf;

	@Transactional
	public void saveProduct(Product prod) {

		sf.getCurrentSession().save(prod);

		System.out.println("Record saved... ");
	}

	// update Product

	@Transactional
	public Product updateProduct(Product newPeoduct) {
		return (Product) sf.getCurrentSession().merge(newPeoduct);
	}

	@Transactional
	public void deleteProduct(int id) {
		Session ses = sf.getCurrentSession();
		Product prod = ses.get(Product.class, id);

		if (prod != null) {
			sf.getCurrentSession().delete(prod);
		}

	}

	// list all products

	@Transactional
	public Product findById(int id) {
		return sf.getCurrentSession().get(Product.class, id);
	}

	@Transactional
	public List<Product> findAll() {

		String hqlQuery = "from Product";

		Query<Product> qry = sf.getCurrentSession().createQuery(hqlQuery);

		return qry.getResultList();

	}

}
