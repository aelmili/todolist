package com.cs.todolist.services;

import static org.junit.Assert.*;

import java.util.List;

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
		int id = 1;

		//Act
		User user = getUsersService.getUserById(id);

		//Assert
		assertTrue(user.getId() == id);
	}

	@Test
	public void testGetUserByCredentials() {
		//Arrange
		String email = "a.b@c";
		String password = "password";

		//Act
		User user = getUsersService.getUserByCredentials(email, password);

		//Assert
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());
	}

	@Test
	public void testGetUsers() {
		//Act
		List<User> users = getUsersService.getUsers();

		//Assert
		assertTrue(users.size() > 0);
	}
}