package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.implementation.HelperService;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class helper {

	@Autowired
    HelperService helperService;

	@Autowired
    UserService userService;

	@Test
	public void helperTest(){

	    User u = userService.getUserById(25);
	    List<User> userList = userService.getAllUsers();


 	}


}
