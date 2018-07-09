package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.School;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class users {

	@Autowired
    UserService userService;

    private static final String tstSId = "8057df9d-72a3-419a-98b5-6eab87ec0a6d";
    private static final String tstId = "65";

	@Test
	public void getAllUsers(){

        List<User> userList = userService.getAllUsers();
        List<User> teacherList = userService.getAllTeachers();
        List<User> studentList = userService.getAllStudents();

        assertEquals(teacherList.size(),8);
        assertEquals(userList.size(),300);
        assertEquals(studentList.size(),292);
        assertTrue(checkValues(userList.get(64)));

        for (User u : studentList){assertEquals(u.getRole(),"student");}
        for (User u : teacherList){assertEquals(u.getRole(),"teacher");}

	}

    @Test
    public void getUserById(){
        User u = userService.getUserById("65");
        assertTrue(checkValues(u));
    }

    // Custom Queries
    @Test
    public void getUsersByClass(){
        String classId = "cee2f870-852c-47e8-988a-73e2c296fc77";

        List<User> userList = userService.getUsersByClass(classId);
        List<User> studentList = userService.getStudentsByClass(classId);
        List<User> teacherList = userService.getTeachersByClass(classId);

        assertEquals(userList.size(),55);
        assertEquals(studentList.size(),47);
        assertEquals(teacherList.size(),8);
    }

    @Test
    public void testFailedSearch(){
        try {
            User u = userService.getUserById("1265");
            fail("NP Exception expected");
        } catch (Exception e){
            // pass
        }
    }

    private static boolean checkValues(User testObject){

	    User refObject = new User();

        refObject.setSourcedId(tstSId);
        refObject.setUserId(tstId);
        refObject.setDateLastModified("2018-06-18 04:02:22");
        refObject.setStatus("active");
        refObject.setMetadata("");
        refObject.setEnabledUser("TRUE");
        refObject.setUserIds("");
        refObject.setIdentifier("7wOi-wVMq-E7Wh");
        refObject.setSchoolId("f9a75f84-130b-419e-bbe6-463585e930e9");
        refObject.setGivenName("Dickie");
        refObject.setMiddleName("Elbertine");
        refObject.setFamilyName("Nornable");
        refObject.setEmail("dnornable@spring.perficientads.com");
        refObject.setUsername("dnornable");
        refObject.setPhone("936-649-6419");
        refObject.setRole("student");
        refObject.setGrades("06");
        refObject.setType("LDAP");
        refObject.setPassword("secret");

        return (testObject.equals(refObject));

    }

}
