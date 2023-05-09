package com.cgi.dao;

import java.sql.SQLException;
import java.util.List;

import com.cgi.model.Employee;

public interface EmployeeDAO {

	public Employee createEmployee(Employee employee) throws SQLException;
	public List<Employee> getEmployees() throws SQLException;
	public Employee getEmployeeById(Employee employee) throws SQLException;
	public Employee updateEmployee(Employee employee) throws SQLException;
	public int deleteEmployee(Employee employee) throws SQLException;
	public int deleteAllCustomers() throws SQLException;
}
