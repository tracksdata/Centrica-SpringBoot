package com.cts.product.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@PropertySource("db.properties")
@ComponentScan("com.cts.product.service,com.cts.product.dao")
@EnableTransactionManagement
public class AppConfig {
	

	/*
	 * Notes ------- 
	 * a. provide db ninformation inside configuration file like .properties or yml
	 * 
	 * 1. Connection pool info - DB Info - MySQL 2. Transaction Management like JTA etc
	 */

	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.username"));
		ds.setPassword(env.getProperty("db.password"));
		System.out.println(env.getProperty("db.password"));
		return ds;
	}

	@Bean
	public JdbcTemplate getJdbcTemplte() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}

	
	// 
	public JtaTransactionManager getTransation() {

		JtaTransactionManager tx = new JtaTransactionManager();
		//tx.setTransactionManagerName(getJdbcTemplte().get);

		return tx;

	}

}
