package com.users.api.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.users.api.model.Users;

public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {

	@Query("SELECT u FROM Users u WHERE CONCAT(u.firstName, ' ', u.lastName, ' ',"
			+ " u.email, ' ', u.mobile, ' ', u.address"
			+ ", ' ', u.city, ' ', u.state, ' ', u.pincode) LIKE %?1%")
	public List<Users> getUsers(String keyword, Pageable pageable);

}
 