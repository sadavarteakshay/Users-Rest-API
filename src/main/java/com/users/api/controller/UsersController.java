package com.users.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserService usersServiceImpl;
	
	
	
	//Adding User
	
	@PostMapping(path = "/")
	@PreAuthorize("hasRole('ADMIN')")
	public Users addUser(@Valid @RequestBody Users user) {

		return usersServiceImpl.addUser(user);

	}

	
	
	//Updating User
	
	@PutMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Users updateUser(@PathVariable("id") Long uid, @RequestBody Users user) {

		return usersServiceImpl.updateUser(uid, user);

	}
	
	
	
	//Deleting User
	
	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long uid) {

		usersServiceImpl.deleteUser(uid);

		return new ResponseEntity<String>("User deleted Succefully", HttpStatus.OK);
	}

	
	
	
	//Fetching Users 
	
	@GetMapping(path = "/")
	@PreAuthorize("hasRole('NORMAL')" + "||hasRole('ADMIN')")
	public List<Users> getUsers(@RequestParam("searchQuery") String keyword, @RequestParam("fetchSize") int fetchSize) {

		return usersServiceImpl.getUsers(keyword, fetchSize);

	}

}
