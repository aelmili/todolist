package com.cs.todolist.services;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.todolist.entities.User;

public class CreateUsersServiceTest {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static CreateUsersService createUsersService = (CreateUsersService) context.getBean("createUsersService");

	@Test
	public void testCreateUser() {
		//Arrange
		
		//Act
		User user = new User("abdel.elmili@gmail.com", "password", "Abdel", "ELMILI", new Date(1987, 11, 14));
		createUsersService.createUser(user);
		
		// Assert
	}

}
