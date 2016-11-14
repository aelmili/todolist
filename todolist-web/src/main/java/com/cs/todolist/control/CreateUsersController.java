package com.cs.todolist.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.todolist.entities.User;
import com.cs.todolist.services.CreateUsersService;

@RestController
@RequestMapping("/users/create")
public class CreateUsersController {
	@Autowired CreateUsersService createUsersService;

	@RequestMapping(params={"fname", "lname", "birthday", "email", "password", "admin"})
	public void createUser(@RequestParam String fname, @RequestParam String lname, @RequestParam String email,
			@RequestParam String password, @RequestParam long birthday, @RequestParam int admin){
		Date bDate = new Date(birthday);
		User user = new User(email, fname, lname, password, bDate, admin != 0);
		createUsersService.createUser(user);
	}
}
