package com.cs.todolist.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.todolist.entities.Status;
import com.cs.todolist.entities.Task;
import com.cs.todolist.services.CreateTasksService;
import com.cs.todolist.services.GetUsersService;
import com.cs.todolist.services.UpdateTasksService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tasks")
public class CreateOrUpdateTasksController {
	@Autowired CreateTasksService createTasksService;
	@Autowired UpdateTasksService updateTasksService;
	@Autowired GetUsersService getUsersService;

	@RequestMapping(value="/create", params={"title", "desc", "creatorId", "deadline"})
	public void createTask(@RequestParam String title, @RequestParam String desc, @RequestParam int creatorId,
			@RequestParam long deadline){
		createTasksService.createTask(new Task(getUsersService.getUserById(creatorId), new Date(deadline), desc, title));
	}
	
	//@RequestMapping(value="/update", params={"taskId", "assigneeId", "status", "closingDate"})
	@RequestMapping(value="/update")
	public void updateTask(@RequestParam int taskId, @RequestParam(required=false, defaultValue="0") int assigneeId,
			@RequestParam(required=false, defaultValue="0") long closingDate, @RequestParam Status status){
		if(status != null)
			updateTasksService.updateTaskStatus(taskId, status);
		
		if(assigneeId != 0)
			updateTasksService.updateTaskAssignee(taskId, getUsersService.getUserById(assigneeId));
		
		if(closingDate != 0)
			updateTasksService.updateTaskClosingDate(taskId, new Date(closingDate));
	}
}