package com.cts.product.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("db.properties")
@ComponentScan("com.cts.product.service,com.cts.product.dao")
@EnableTransactionManagement
public class AppConfig {

	/*
	 * Notes ------- 
	 * a. provide db ninformation inside configuration file like
	 * .properties or yml
	 * 
	 * 1. Connection pool  - DB Info - MySQL 
	 * 2. Provide SessionFactory information
	 * 3. Transaction Management like JTA / Hibernate / JPA
	 * 
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

	
	public JpaVendorAdapter hibJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);
		adapter.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
		return adapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getSessionFactory() {

		LocalContainerEntityManagerFactoryBean lfb=new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(getDataSource());
		lfb.setJpaVendorAdapter(hibJpaVendorAdapter());
		lfb.setPackagesToScan("com.cts.product.model");

		return lfb;

	}

	@Bean
	public PlatformTransactionManager getTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
