package com.cs.todolist.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.todolist.entities.User;
import com.cs.todolist.services.GetUsersService;

@RestController
@RequestMapping("/users")
public class GetUsersController {
	@Autowired GetUsersService getUsersService;

	@RequestMapping
	@ResponseBody
	public List<User> getUsers(){
		return getUsersService.getUsers();
	}

	@RequestMapping(params="id") // Avoid mapping ambiguity
	public User getUserById(@RequestParam("id") int id){
		return getUsersService.getUserById(id);
	}

	@RequestMapping(params={"email", "password"})
	public User getUserByCredentials(@RequestParam(value="email") String email, @RequestParam(value="password") String password){
		return getUsersService.getUserByCredentials(email, password);
	}
}
