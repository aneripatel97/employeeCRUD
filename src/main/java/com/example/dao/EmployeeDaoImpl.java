package com.example.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemp;

	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> empList() {
		List<Employee> list = jdbcTemp.query("Select * from employee ", new RowMapper<Employee>(){
			
			@Override
			public Employee mapRow (ResultSet rs , int rowNum) throws SQLException {
				Employee emp = new Employee();
				
				emp.setName(rs.getString("name"));
				emp.setDesignation(rs.getString("designation"));
				emp.setDept(rs.getString("dept"));
				emp.setSalary(rs.getInt("salary"));
				emp.setLocation(rs.getString("location"));


				return emp;
			}
	   });
		
		return list;
	}
}
