package com.student.management.persistence.dao.config;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*Hibernate configuration class*/


@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = 
				new LocalContainerEntityManagerFactoryBean();
		//Properties properties = new Properties();
	      //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		hibernateJpaVendorAdapter.setShowSql(true);
		//localContainerEntityManagerFactoryBean.setJpaProperties(properties);
		
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.student.management.persistence.dto");
		return localContainerEntityManagerFactoryBean;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.postgresql.Driver");
		datasource.setUsername("postgres");
		datasource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		datasource.setPassword("password");
		return datasource;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		JpaTransactionManager platformTransactionManager = new JpaTransactionManager();
		platformTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return platformTransactionManager;
	}
}
