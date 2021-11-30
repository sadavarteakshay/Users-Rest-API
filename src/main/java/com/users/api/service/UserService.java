package com.users.api.service;

 

 
import java.util.List;

import com.users.api.model.Users;


public interface UserService {
	
	
	
	  Users addUser(Users user);

	  Users updateUser( Long uid, Users user);
	  
	  List<Users> getUsers(String keyword, int fetchSize);

	void deleteUser(Long uid);

}
