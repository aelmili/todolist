package com.cs.todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.todolist.entities.Task;
import com.cs.todolist.entities.User;
import com.cs.todolist.persistence.TaskDAO;

@Service
public class GetTasksService {
	@Autowired TaskDAO taskDAO;

	public Task getTaskById(int id){
		return taskDAO.findTaskById(id);
	}

	public List<Task> getTasksByCreator(User creator){
		return taskDAO.findTaskByCreator(creator);
	}

	public List<Task> getTasksByAssignee(User assignee){
		return taskDAO.findTaskByCreator(assignee);
	}

	public List<Task> getTasks(){
		return taskDAO.findAllTasks();
	}
}