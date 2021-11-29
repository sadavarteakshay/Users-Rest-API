package com.users.api.controller;

 

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.users.api.model.Users;
import com.users.api.service.UserService;
 
@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	UserService usersServiceImpl;
	
	
	@PostMapping(path = "/add")
	public Users addUser(@Valid @RequestBody Users user) {

		return usersServiceImpl.addUser(user);

	}
	

	@PutMapping(path = "/update/{id}")
	public Users updateUser(@PathVariable("id") Long uid,  @RequestBody Users user) {

		return usersServiceImpl.updateUser(uid,user);

	}
	
	

	@GetMapping(path = "/")
	public List<Users> getUsers(@RequestParam ("searchQuery")  String keyword, @RequestParam ("fetchSize") int fetchSize ) {

		return usersServiceImpl.getUsers(keyword,fetchSize);

	}


}
