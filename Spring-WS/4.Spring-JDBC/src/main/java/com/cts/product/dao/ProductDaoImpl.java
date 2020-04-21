package com.cts.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cts.product.model.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	private JdbcTemplate jt;

	public void saveProduct(Product prod) {
		String qry = "insert into product values(?,?,?,?)";
		jt.update(qry, prod.getId(), prod.getDescription(), prod.getName(), prod.getPrice());
		System.out.println("Record saved... ");
	}

	// list all products

	public List<Product> findAll() {
		return jt.query("select * from Product", new ListProducts());
	}

}

class ListProducts implements ResultSetExtractor<List<Product>> {
	List<Product> prods = new ArrayList<Product>();

	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {

		while (rs.next()) {
			Product prod = new Product();
			prod.setId(rs.getInt("id"));
			prod.setName(rs.getString("name"));
			prod.setDescription(rs.getString("description"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);
		}
		return prods;
	}
}
