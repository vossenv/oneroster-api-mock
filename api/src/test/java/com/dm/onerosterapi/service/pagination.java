package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.service.interfaces.UserService;
import com.dm.onerosterapi.utility.AllowedTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class pagination {

	@Inject
    UserService userService;

	@Inject
    RosterDao rosterDao;


    @Test
    public void getAllObjects() {

        // Test limit
        assertEquals(20, rosterDao.getAll(AllowedTypes.User, 0, 20).size());

        // Test offset
        List<User> userList = (List<User>) rosterDao.getAll(AllowedTypes.User, 7, 10);
        assertEquals("3d4616a9-8b7f-4f04-930f-307f59b4a4e0", userList.get(0).getSourcedId());


    }



}
