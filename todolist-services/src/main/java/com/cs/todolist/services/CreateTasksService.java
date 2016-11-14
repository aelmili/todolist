package com.cs.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.todolist.entities.Task;
import com.cs.todolist.persistence.TaskDAO;

@Service
public class CreateTasksService {
	@Autowired TaskDAO taskDAO;

	public void createTask(Task task){
		taskDAO.CreateTask(task);
	}
}
