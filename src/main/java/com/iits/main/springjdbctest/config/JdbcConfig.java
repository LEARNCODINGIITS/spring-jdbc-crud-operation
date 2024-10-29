package com.iits.main.springjdbctest.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.iits.main.springjdbctest.dao.Employee;
import com.iits.main.springjdbctest.dao.EmployeeDAO;

@Configuration
@ComponentScan(basePackageClasses = {EmployeeDAO.class,Employee.class})
public class JdbcConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dms = new DriverManagerDataSource();
		dms.setUrl("jdbc:mysql://localhost:3306/mydb2");
		dms.setUsername("root");
		dms.setPassword("root");
		return dms;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
