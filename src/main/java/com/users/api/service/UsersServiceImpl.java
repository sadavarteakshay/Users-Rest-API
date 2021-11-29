package com.users.api.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

 
import com.users.api.dao.UsersRepository;
import com.users.api.model.Users;

@Service
public class UsersServiceImpl implements UserService {

	@Autowired
	UsersRepository userRepo;

	
	//Adding New User
	@Override
	public Users addUser(Users user) {

		return userRepo.save(user);
	}

	//Updating User
	@Override
	public Users updateUser(Long uid, Users user) {

		Users userdb = userRepo.findById(uid).get();

		if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
			userdb.setFirstName(user.getFirstName());
		}

		if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
			userdb.setLastName(user.getLastName());
		}

		if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
			userdb.setEmail(user.getEmail());
		}

		if (Objects.nonNull(user.getMobile()) && !"".equalsIgnoreCase(user.getMobile())) {
			userdb.setMobile(user.getMobile());
		}

		if (Objects.nonNull(user.getAddress()) && !"".equalsIgnoreCase(user.getAddress())) {
			userdb.setAddress(user.getAddress());
		}

		if (Objects.nonNull(user.getCity()) && !"".equalsIgnoreCase(user.getCity())) {
			userdb.setCity(user.getCity());
		}

		if (Objects.nonNull(user.getState()) && !"".equalsIgnoreCase(user.getState())) {
			userdb.setState(user.getState());
		}

		if (Objects.nonNull(user.getPincode()) && !"".equalsIgnoreCase(user.getPincode())) {
			userdb.setPincode(user.getPincode());
		}

		userdb.setVersion(userdb.getVersion() + 1);

		return userRepo.save(userdb);
	}

	@Override
	public List<Users> getUsers(String keyword, int fetchSize ) {
		 
		Pageable pageable= PageRequest.ofSize(fetchSize);
		
		return userRepo.getUsers(keyword,pageable);
	}
	
	
	
	
	
	
	
	

}
