package com.users.api.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.users.api.dao.UsersRepository;
import com.users.api.model.Users;

@DataJpaTest
public class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository userRepo; 

	 @Autowired
	 private TestEntityManager entityManager;
	
	
	@BeforeEach
    void setUp() {
        Users user = new Users(1L,"Akshay","Sadavarte","sadavarteakshay@gmail.com","9898989898","Aai Niwas",
        		"Aurangabad","Maharashtra","431001",0);
                

        entityManager.persist(user);
    }
	
	
	@Test
    public void addUserTest() {
		 Users user = new Users(1L,"Akshay","Sadavarte","sadavarteakshay@gmail.com","9898989898","Aai Niwas",
	        		"Aurangabad","Maharashtra","431001",0);
		 
		Users user1 = userRepo.save(user);
		
        assertEquals(user1.getFirstName() , "Akshay");
    }
	
	
}
