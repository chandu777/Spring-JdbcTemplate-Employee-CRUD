package com.acsk.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.acsk.model.EmployeeBean;

public class EmployeeDaoImpl {

	private JdbcTemplate jdbcTemplateObject;

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplateObject = template;
	}

	public void addEmployee(EmployeeBean employee) {
		String SQL = "INSERT INTO `Employee`(`empaddress`, `empAge`, `empname`, `salary`) VALUES (?,?,?,?)";
		jdbcTemplateObject.update(SQL, employee.getAddress(), employee.getAge(), employee.getName(),
				employee.getSalary());
	}

	public List<EmployeeBean> listEmployeess() {
		String sql = "select * from Employee";
		List<EmployeeBean> list = jdbcTemplateObject.query(sql, new EmployeeMapper());
		return list;
	}

	public EmployeeBean getEmployee(int empid) {

		String sql = "SELECT * FROM `Employee` WHERE `empid` = ?";
		EmployeeBean employeeBean = jdbcTemplateObject.queryForObject(sql, new Object[] { empid },
				new EmployeeMapper());
		return employeeBean;
	}

	public void deleteEmployee(EmployeeBean employee) {
		String SQL = "delete from Employee where empid = ?";
		jdbcTemplateObject.update(SQL, employee.getId());
	}
}
