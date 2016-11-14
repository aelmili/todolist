package com.cs.todolist.services;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.todolist.entities.Status;
import com.cs.todolist.entities.Task;
import com.cs.todolist.entities.User;

public class UpdateTasksServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static UpdateTasksService updateTasksService = (UpdateTasksService) context.getBean("updateTasksService");
	static GetTasksService getTasksService = (GetTasksService) context.getBean("getTasksService");
	static GetUsersService getUsersService = (GetUsersService) context.getBean("getUsersService");

	@Test
	public void testUpdateTaskStatus() {
		//Arrange
		Status newStatus = Status.IN_PROGRESS;

		//Act
		updateTasksService.updateTaskStatus(1, newStatus); 

		//Assert
		Task task = getTasksService.getTaskById(1);
		assertTrue(task.getStatus() == newStatus);
	}

	@Test
	public void testUpdateTaskClosingDate() {
		//Arrange
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 11, 30);
		Date newClosingDate = cal.getTime();

		//Act
		updateTasksService.updateTaskClosingDate(1, newClosingDate); 

		//Assert
		Task task = getTasksService.getTaskById(1);
		assertTrue(task.getClosingDate().compareTo(newClosingDate) == 0); // Need to change newClosingDate timezone to GMT 
	}

	@Test
	public void testUpdateTaskAssignee() {
		//Arrange
		User assignee = getUsersService.getUserById(2);

		//Act
		updateTasksService.updateTaskAssignee(1, assignee);; 

		//Assert
		Task task = getTasksService.getTaskById(1);
		assertTrue(task.getAssignee().getId() == 2); 
	}
}