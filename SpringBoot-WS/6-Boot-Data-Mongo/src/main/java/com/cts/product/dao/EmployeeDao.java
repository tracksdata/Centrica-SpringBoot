package com.cts.product.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.product.model.Employee;

public interface EmployeeDao extends MongoRepository<Employee, Object>{

	
}
