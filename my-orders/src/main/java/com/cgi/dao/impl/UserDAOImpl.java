package com.cgi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.dao.UserDAO;
import com.cgi.model.Users;

@Component
public class UserDAOImpl implements UserDAO {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public boolean login(Users users) {
		Connection connection;
		try {
			connection = dataSource.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select count(1) as count from users where username=? and password=?");
			
			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getPassword());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String count = resultSet.getString("count");
				
				if(count.equals("1")) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
