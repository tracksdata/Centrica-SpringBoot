package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.dao.EmployeeDao;
import com.cts.product.model.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);

		EmployeeDao empDao = ac.getBean(EmployeeDao.class);
		Employee emp = new Employee();
		emp.set_id(1027);
		emp.setEmpName("Bucky");
		emp.setSalary(27000);
		emp.setDesignation("Developer");

		//empDao.save(emp);

		for (Employee e : empDao.findAll()) {
			System.out.println(e.get_id());
			System.out.println(e.getEmpName());
			System.out.println(e.getSalary());
			System.out.println(e.getDesignation());
			System.out.println("-------------------------");
		}
		
		

	}

}
