package com.dm.onerosterapi.service;

import com.dm.onerosterapi.utility.ApiMessages;
import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
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
    public void getUserBySourcedId() throws UserNotFoundException {
        assertTrue(checkValues(userService.getUserBySourcedId(tstSId)));
    }

    @Test
    public void getStudentBySourcedId() throws UserNotFoundException {
        assertTrue(checkValues(userService.getStudentBySourcedId(tstSId)));

        try {
            userService.getStudentBySourcedId("f1e4b385-b0c9-4054-ad08-95c580ac715d");
            fail ("Exception expected");
        } catch (UserNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessages.NOT_A_STUDENT));
        }

    }

    @Test
    public void getTeacherBySourcedId() throws UserNotFoundException {
        assertEquals(userService.getTeacherBySourcedId(
                "f1e4b385-b0c9-4054-ad08-95c580ac715d").getGivenName(),"Jobi");

        try {
            userService.getTeacherBySourcedId(tstSId);
            fail ("Exception expected");
        } catch (UserNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessages.NOT_A_TEACHER));
        }

    }


	@Test
	public void getAllUsers() throws UserNotFoundException {

        List<User> userList = userService.getAllUsers(0, Integer.MAX_VALUE);
        List<User> teacherList = userService.getAllTeachers(0, Integer.MAX_VALUE);
        List<User> studentList = userService.getAllStudents(0, Integer.MAX_VALUE);

        assertEquals(teacherList.size(),8);
        assertEquals(userList.size(),300);
        assertEquals(studentList.size(),292);
        assertTrue(checkValues(userList.get(64)));

        for (User u : studentList){assertEquals(u.getRole(),"student");}
        for (User u : teacherList){assertEquals(u.getRole(),"teacher");}

	}


    @Test
    public void getUsersByClass() throws UserNotFoundException, ClassOfCourseNotFoundException {
        String classId = "cee2f870-852c-47e8-988a-73e2c296fc77";

        List<User> userList = userService.getUsersByClass(classId, 0, Integer.MAX_VALUE);
        List<User> studentList = userService.getStudentsByClass(classId,0, Integer.MAX_VALUE);
        List<User> teacherList = userService.getTeachersByClass(classId,0, Integer.MAX_VALUE);

        assertEquals(userList.size(),55);
        assertEquals(studentList.size(),47);
        assertEquals(teacherList.size(),8);

        try {
            userService.getTeachersByClass("2ba9f25c-ef54-4072-85ab-2db066988091",0, Integer.MAX_VALUE);
            fail("Class has no teachers");
        } catch (UserNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessages.NO_RESULTS));
        }
    }

    @Test
    public void getUsersForSchool() throws UserNotFoundException, SchoolNotFoundException {

        String schoolId = "f9a75f84-130b-419e-bbe6-463585e930e9";

        List<User> userList = userService.getUsersBySchool(schoolId);
        List<User> studentList = userService.getStudentsBySchool(schoolId);
        List<User> teacherList = userService.getTeachersBySchool(schoolId);

        assertEquals(userList.size(),150);
        assertEquals(studentList.size(),146);
        assertEquals(teacherList.size(),4);

    }


    @Test
    public void getUsersForClassInSchool() throws UserNotFoundException, SchoolNotFoundException, ClassOfCourseNotFoundException  {

        String schoolId = "f5897384-9488-466f-b049-1992f7a53f15";
        String classId = "de02e4fa-9f8e-4f05-86fb-1173a246594c";

        List<User> userList = userService.getUsersForClassInSchool(classId, schoolId);
        List<User> studentList = userService.getStudentsForClassInSchool(classId, schoolId);
        List<User> teacherList = userService.getTeachersForClassInSchool(classId, schoolId);

        assertEquals(userList.size(),54);
        assertEquals(studentList.size(),50);
        assertEquals(teacherList.size(),4);

    }

    @Test
    public void testFailedSearch(){
        try {
            User u = userService.getUserBySourcedId("1265");
            fail("NP Exception expected");
        } catch (UserNotFoundException e){
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
