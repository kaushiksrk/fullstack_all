package com.cgi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cgi.dao.EmployeeDAO;
import com.cgi.factory.DBFactory;
import com.cgi.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Connection connection;

	{
		try {
			connection=DBFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Employee createEmployee(Employee employee) throws SQLException {
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
		
		preparedStatement.setInt(1, new Random().nextInt());
		preparedStatement.setString(2, employee.getEmpName());
		preparedStatement.setInt(3, employee.getEmpAge());
		preparedStatement.setString(4, employee.getAddr1());
		preparedStatement.setString(5, employee.getAddr2());
		preparedStatement.setString(6, employee.getEmpEmail());
		preparedStatement.setInt(7, employee.getDeptId());
		preparedStatement.setInt(8, employee.getSalary());
		
	
		preparedStatement.executeUpdate();
		return employee;
	}
	
	@Override
	public List<Employee> getEmployees() throws SQLException {
		List<Employee> listCustomer=new ArrayList<Employee>();
		
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("SELECT * FROM EMPLOYEE");
		
		while(rs.next()) {
			Employee employee=new Employee(Integer.parseInt(rs.getString("emp_id")), rs.getString("emp_name"), Integer.parseInt(rs.getString("emp_age")), 
					rs.getString("addr1"), rs.getString("addr2"), rs.getString("emp_email"), Integer.parseInt(rs.getString("dept_id")), Integer.parseInt(rs.getString("salary")));
			listCustomer.add(employee);
		}
		return listCustomer;
	}
	
	@Override
	public Employee getEmployeeById(Employee employee) throws SQLException {
		PreparedStatement statement=connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID=?");
		statement.setInt(1, employee.getEmpId());
		
		ResultSet rs=statement.executeQuery();
		
		if(rs.next()) {
			employee=new Employee(Integer.parseInt(rs.getString("emp_id")), rs.getString("emp_name"), Integer.parseInt(rs.getString("emp_age")), 
					rs.getString("addr1"), rs.getString("addr2"), rs.getString("emp_email"), Integer.parseInt(rs.getString("dept_id")), Integer.parseInt(rs.getString("salary")));
		}
		return employee;
	}
	
	public Employee updateEmployee(Employee employee) throws SQLException {
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set emp_name=?, emp_age=?, addr1=?, addr2=?, emp_email=?, dept_id=?, salary=? "
				+ "where emp_id=?");
		
		preparedStatement.setString(1, employee.getEmpName());
		preparedStatement.setInt(2, employee.getEmpAge());
		preparedStatement.setString(3, employee.getAddr1());
		preparedStatement.setString(4, employee.getAddr2());
		preparedStatement.setString(5, employee.getEmpEmail());
		preparedStatement.setInt(6, employee.getDeptId());
		preparedStatement.setInt(7, employee.getSalary());
		
		preparedStatement.setInt(8, employee.getEmpId());
	
		preparedStatement.executeUpdate();
		return employee;
	}
	
	public int deleteEmployee(Employee employee) throws SQLException {
		PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where emp_id=?");
		
		preparedStatement.setInt(1, employee.getEmpId());
		preparedStatement.executeUpdate();
		
		return preparedStatement.executeUpdate();
	}
	
	public int deleteAllCustomers() throws SQLException {
		PreparedStatement preparedStatement=connection.prepareStatement("truncate table employee");
		
		return preparedStatement.executeUpdate();
	}

}
