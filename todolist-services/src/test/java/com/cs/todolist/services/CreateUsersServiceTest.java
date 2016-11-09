package com.cs.todolist.services;

import static org.junit.Assert.assertNotNull;

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
		String email = "a.b@c";
		String firstName = "myFirstName";
		String lastName = "myLastName";
		String password = "password";
		Date birthday = new Date();
		
		//Act
		User user = new User(email, firstName, lastName, password, birthday);
		createUsersService.createUser(user);
		
		//Assert
		assertNotNull(user.getId());
	}
}
