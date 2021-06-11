package com.luv2code.springdemo.service;


import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.UserDAO;
import com.luv2code.springdemo.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User getUser(String theId) {
		return userDAO.getUser(theId);
	}
}
