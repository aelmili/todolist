package com.cs.todolist.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.todolist.entities.User;

public class GetUsersServiceTest {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static GetUsersService getUsersService = (GetUsersService) context.getBean("getUsersService");
	
	@Test
	public void testGetUserById() {
		//Arrange
		//Act
		User user = getUsersService.getUserById(1);
		
		//Assert
		assertTrue(user.getId() > 0);
	}

}
