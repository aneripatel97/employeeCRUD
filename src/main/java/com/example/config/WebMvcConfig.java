package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.dao , com.example.Controller"})
public class WebMvcConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
	 
	@Bean
	public DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/employeedb");
		ds.setUsername("root");
		ds.setPassword("");

		return ds;
	}
	
	@Bean
	public EmployeeDao geEmployeeDao() {
		return new EmployeeDaoImpl(getDataSource());
				
	}
}

