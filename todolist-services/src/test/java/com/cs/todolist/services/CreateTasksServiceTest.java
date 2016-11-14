package com.cs.todolist.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.todolist.entities.Task;
import com.cs.todolist.entities.User;

public class CreateTasksServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static CreateTasksService createTasksService = (CreateTasksService) context.getBean("createTasksService");
	static GetUsersService getUsersService = (GetUsersService) context.getBean("getUsersService");

	@Test
	public void testCreateTask() {
		//Arrange
		User user = getUsersService.getUserById(1);
		Date creationDate = new Date();

		//Act
		Task task = new Task(creationDate, user, creationDate, "", "MySecondTask");
		createTasksService.createTask(task);

		//Assert
		assertNotNull(task.getId());
	}
}