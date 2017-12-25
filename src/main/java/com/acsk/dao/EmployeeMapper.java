package com.acsk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.acsk.model.EmployeeBean;

public class EmployeeMapper implements RowMapper<EmployeeBean> {

	public EmployeeBean mapRow(ResultSet rs, int rows) throws SQLException {
		EmployeeBean emp = new EmployeeBean();
		
		emp.setId(rs.getInt("empid"));
		emp.setAddress(rs.getString("empaddress"));
		emp.setAge(rs.getInt("empAge"));
		emp.setName(rs.getString("empname"));
		emp.setSalary(rs.getLong("salary"));
		
		return emp;
	}

}
