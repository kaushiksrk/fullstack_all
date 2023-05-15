package com.cgi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.dao.UserDAO;
import com.cgi.model.Users;
import com.cgi.service.UsersService;

@Component("usersService")
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UserDAO userDAO;
	
	public boolean login(Users users) {
		return userDAO.login(users);
	}
}
