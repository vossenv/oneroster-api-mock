package com.dm.onerosterapi.dao;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.RosterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class users {

	@Autowired
	RosterService rosterService;

	@Test
	public void getUsersByClass(){

	    List<User> userList = rosterService.getUsersByClass("cee2f870-852c-47e8-988a-73e2c296fc77");
        assertEquals(userList.size(),55);

	}


}
