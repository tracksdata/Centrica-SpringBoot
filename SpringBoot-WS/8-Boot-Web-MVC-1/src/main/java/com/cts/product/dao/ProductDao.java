package com.cts.product.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cts.product.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	
	
	List<Product> findProductByNameLike(String name);
	List<Product> findProductByPriceBetween(double startRange,double endRange);
	
	
	@Query(value = "from Product as p where p.name like:productName ")
	//public List<Product> findProductsByName(String name);
	public List<Product> findProductsByName(@Param("productName")String pname);
	
	
	

}
