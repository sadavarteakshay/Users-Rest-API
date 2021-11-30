package com.users.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.users.api.model.Users;
import com.users.api.service.UserService;
 

@WebMvcTest(UsersController.class)
@WithMockUser(username = "akshay", roles = {"ADMIN"})
public class UsersControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService usersServiceImpl;

    private Users user;
	
    
    @BeforeEach
    void setUp() {
        Users user = new Users(1L,"Akshay","Sadavarte","sadavarteakshay@gmail.com","9898989898","Aai Niwas",
        		"Aurangabad","Maharashtra","431001",0);
                
        Users user1 = new Users(1L,"Akshay","Sadavarte","sadavarteakshay@gmail.com","9898989898","Aai Niwas",
        		"Aurangabad","Maharashtra","431001",0);
        
        List<Users> userList=new ArrayList<>();
        
        userList.add(user);
        userList.add(user1);
    }
    
    
    @WithMockUser(username="spring", roles= {"ADMIN"})
    @Test
    void saveUser() throws Exception {
    	Users inputUser = new Users(1L,"Akshay","Sadavarte","sadavarteakshay@gmail.com","9898989898"
    			,"Aai Niwas",
        		"Aurangabad","Maharashtra","431001",0);

        Mockito.when(usersServiceImpl.addUser(inputUser))
                .thenReturn(user);

        mockMvc.perform(post("/user/add")
         	 
        .contentType(MediaType.APPLICATION_JSON)
        .content(" {\n   \"firstName\": \"Akshay\",\n      "
        		+ "  \"lastName\": \"Sadavarte\",\n       "
        		+ " \"email\": \"sadavarteakshay@gmail.com\",\n      "
        		+ "  \"mobile\": \"9898989898\",\n       "
        		+ " \"address\": \"Aai Niwas\",\n     "
        		+ "   \"city\": \"Aurangabad\",\n       "
        		+ " \"state\": \"Maharashtra\",\n       "
        		+ " \"pincode\": \"431001\"  \n }"))
                .andExpect(status().isOk());

    }
	
    
    
    
    @Test
    void fetchUsersByKeyword() throws Exception {
    	 
    	Users user = new Users(1L,"Akshay","Sadavarte","sadavarteakshay@gmail.com","9898989898","Aai Niwas",
        		"Aurangabad","Maharashtra","431001",0);
                
        Users user1 = new Users(1L,"Akshay","Sadavarte","sadavarteakshay@gmail.com","9898989898","Aai Niwas",
        		"Aurangabad","Maharashtra","431001",0);
        
        List<Users> userList=new ArrayList<>();
        
        userList.add(user);
        userList.add(user1);
    	
    	
    	
    	
    	String keyword="sh";
    	int fetchSize=1;
    	
        Mockito.when(usersServiceImpl.getUsers(keyword, fetchSize))
                .thenReturn(userList);

        mockMvc.perform(get("/user/getUsers")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
         
    }
	
}
