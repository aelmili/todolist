package com.cs.todolist.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.todolist.entities.Task;
import com.cs.todolist.services.GetTasksService;
import com.cs.todolist.services.GetUsersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tasks")
public class GetTasksController {
	@Autowired GetTasksService getTasksService;
	@Autowired GetUsersService getUsersService;

	@RequestMapping
	@ResponseBody
	public List<Task> getTasks(){
		return getTasksService.getTasks();
	}

	@RequestMapping(params="creatorId")
	@ResponseBody
	public List<Task> getTasksByCreator(@RequestParam int creatorId){
		return getTasksService.getTasksByCreator(getUsersService.getUserById(creatorId));
	}

	@RequestMapping(params="assigneeId")
	@ResponseBody
	public List<Task> getTasksByAssignee(@RequestParam int assigneeId){
		return getTasksService.getTasksByAssignee(getUsersService.getUserById(assigneeId));
	}

	@RequestMapping(params="id")
	public Task getTaskById(@RequestParam int id){
		return getTasksService.getTaskById(id);
	}
}