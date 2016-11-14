package com.cs.todolist.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.todolist.entities.Status;
import com.cs.todolist.entities.User;
import com.cs.todolist.persistence.TaskDAO;

@Service
public class UpdateTasksService {
	@Autowired TaskDAO taskDAO;

	public void updateTaskStatus(int taskId, Status newStatus){
		taskDAO.updateTaskStatus(taskId, newStatus);
	}
	
	public void updateTaskAssignee(int taskId, User assignee){
		taskDAO.updateTaskAssignee(taskId, assignee);
	}
	
	public void updateTaskClosingDate(int taskId, Date newClosingDate){
		taskDAO.updateClosingDate(taskId, newClosingDate);
	}
}