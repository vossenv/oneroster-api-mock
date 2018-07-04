package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class users {

	@Autowired
	RosterService rosterService;

	@Test
	public void getAllUsers(){

        List<User> userList = rosterService.getAllUsers();
        assertEquals(userList.size(),300);

	}

    @Test
    public void getUserById(){

        User u = rosterService.getUserById(65);

        assertEquals(u.getUserId(),65);
        assertEquals(u.getSourcedId(), "8057df9d-72a3-419a-98b5-6eab87ec0a6d");

    }

}
