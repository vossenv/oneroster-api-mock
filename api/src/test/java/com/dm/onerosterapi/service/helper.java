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

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;
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

	    User u = new User();
	    u.setSchoolId("1");

	    try {
            helperService.idFieldSwap(u);
            assertEquals(u.getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        } catch (IllegalAccessException e){ fail();  }


	    List<User> userList = new ArrayList<>();
	    userList.add(new User());
	    userList.add(new User());

	    userList.get(0).setSchoolId("1");
	    userList.get(1).setSchoolId("2");

	    try {
	    helperService.idFieldSwap(userList);
	    assertEquals(userList.get(0).getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(userList.get(1).getSchoolId(), "f5897384-9488-466f-b049-1992f7a53f15");
        } catch (IllegalAccessException e){ fail();  }


 	}


}
