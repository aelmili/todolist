package com.cs.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.todolist.entities.User;
import com.cs.todolist.persistence.UserDAO;

@Service
public class CreateUsersService {
	@Autowired UserDAO userDAO;
	
	public void createUser(User user){
		userDAO.createUser(user);
	}
}