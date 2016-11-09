package com.cs.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.todolist.entities.User;
import com.cs.todolist.persistence.UserDAO;

@Service
public class GetUsersService {
	@Autowired UserDAO userDAO;
	
	public User getUserByCredentials(String email, String password){
		return userDAO.findUserByCredentials(email, password);
	}
	
	public User getUserById(int id){
		return userDAO.findUserById(id);
	}
}
