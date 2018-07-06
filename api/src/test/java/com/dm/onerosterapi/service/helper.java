package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.model.Enrollment;
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

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class helper {

	@Autowired
    HelperService helperService;

	@Autowired
    UserService userService;

	@Test
	public void userHelperTest(){

	    User u = new User();
	    u.setSchoolId("1");

	    helperService.idFieldSwap(u);
	    assertEquals(u.getSchoolId(),"f9a75f84-130b-419e-bbe6-463585e930e9");

	    List<User> userList = new ArrayList<>();
	    userList.add(new User());
	    userList.add(new User());

	    userList.get(0).setSchoolId("1");
	    userList.get(1).setSchoolId("2");

	    helperService.idFieldSwap(userList);
	    assertEquals(userList.get(0).getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(userList.get(1).getSchoolId(), "f5897384-9488-466f-b049-1992f7a53f15");

 	}

 	@Test
    public void courseHelperTest(){

	    Course c = new Course();
	    c.setSchoolId("1");

        helperService.idFieldSwap(c);
        assertEquals(c.getSchoolId(),"f9a75f84-130b-419e-bbe6-463585e930e9");

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course());
        courseList.add(new Course());

        courseList.get(0).setSchoolId("1");
        courseList.get(1).setSchoolId("2");

        helperService.idFieldSwap(courseList);
        assertEquals(courseList.get(0).getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(courseList.get(1).getSchoolId(), "f5897384-9488-466f-b049-1992f7a53f15");
    }

    @Test
    public void classHelperTest(){

	    ClassOfCourse c = new ClassOfCourse();
	    c.setSchoolId("1");
	    c.setCourseId("1");

	    helperService.idFieldSwap(c);
        assertEquals(c.getSchoolId(),"f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(c.getCourseId(), "7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4");

        List<ClassOfCourse> classList = new ArrayList<>();
        classList.add(new ClassOfCourse());
        classList.add(new ClassOfCourse());

        classList.get(0).setSchoolId("1");
        classList.get(0).setCourseId("1");
        classList.get(1).setSchoolId("2");
        classList.get(1).setCourseId("2");

        helperService.idFieldSwap(classList);
        assertEquals(classList.get(0).getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(classList.get(0).getCourseId(),"7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4");

        assertEquals(classList.get(1).getSchoolId(), "f5897384-9488-466f-b049-1992f7a53f15");
        assertEquals(classList.get(1).getCourseId(),"1970f8a9-6595-4063-9e2e-6bb424e6913e");

    }

    @Test
    public void enrollmentHelperTest(){

        Enrollment e = new Enrollment();
        e.setUserId("1");
        e.setClassId("1");

        helperService.idFieldSwap(e);
        assertEquals(e.getUserId(),"cda272c0-bf6c-4e72-8b13-5f1f3be72339");
        assertEquals(e.getClassId(), "5fbd34b6-ea52-4a4a-b6ae-e43f60139695");

        List<Enrollment> enrollmentList = new ArrayList<>();
        enrollmentList.add(new Enrollment());
        enrollmentList.add(new Enrollment());

        enrollmentList.get(0).setUserId("1");
        enrollmentList.get(0).setClassId("1");
        enrollmentList.get(1).setUserId("2");
        enrollmentList.get(1).setClassId("2");

        helperService.idFieldSwap(enrollmentList);
        assertEquals(enrollmentList.get(0).getUserId(), "cda272c0-bf6c-4e72-8b13-5f1f3be72339");
        assertEquals(enrollmentList.get(0).getClassId(),"5fbd34b6-ea52-4a4a-b6ae-e43f60139695");

        assertEquals(enrollmentList.get(1).getUserId(), "bc16d091-7017-4f2f-9109-250fd590ca6a");
        assertEquals(enrollmentList.get(1).getClassId(),"cc724397-3281-4e3a-90a4-8eb27b23dc37");

    }


}
