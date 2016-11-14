package com.cs.todolist.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.todolist.entities.Task;
import com.cs.todolist.entities.User;

public class GetTasksServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static GetTasksService getTasksService = (GetTasksService) context.getBean("getTasksService");
	static GetUsersService getUsersService = (GetUsersService) context.getBean("getUsersService");

	@Test
	public void testGetTaskById() {
		//Arrange
		int id = 1;

		//Act
		Task task = getTasksService.getTaskById(id);

		//Assert
		assertTrue(task.getId() == id);
	}

	@Test
	public void testGetTasksByCreator() {
		//Arrange
		User creator = getUsersService.getUserById(1);

		//Act
		List<Task> tasks = getTasksService.getTasksByCreator(creator);

		//Assert
		assertTrue(tasks.size() > 0);
	}

	@Test
	public void testGetTasksByAssignee() {
		//Arrange
		User assignee = getUsersService.getUserById(1);

		//Act
		List<Task> tasks = getTasksService.getTasksByAssignee(assignee);

		//Assert
		assertTrue(tasks.size() > 0);
	}

	@Test
	public void testGetTasks() {
		//Act
		List<Task> tasks = getTasksService.getTasks();

		//Assert
		assertTrue(tasks.size() > 0);
	}
}