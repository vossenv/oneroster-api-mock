package com.dm.onerosterapi.service;

import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.jpa.UserRepository;
import com.dm.onerosterapi.apiconfig.ApiMessageConfig;
import com.dm.onerosterapi.utility.AttributeTransformer;
import com.dm.onerosterapi.service.interfaces.UserService;
import com.dm.onerosterapi.utility.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class helper {

    @Autowired
    Validator validator;

	@Autowired
    AttributeTransformer attributeTransformer;

	@Autowired
    UserService userService;

	@Autowired
    UserRepository userRepository;

	@Test
	public void userHelperTest() throws ResourceNotFoundException {

	    User u = new User();
	    u.setSchoolId("1");
	    u.setUserId("5");

	    attributeTransformer.processResults(u);
	    assertEquals(u.getSchoolId(),"f9a75f84-130b-419e-bbe6-463585e930e9");

	    List<User> userList = new ArrayList<>();
	    userList.add(new User());
	    userList.add(new User());

	    userList.get(0).setSchoolId("1");
	    userList.get(1).setSchoolId("2");

	    attributeTransformer.processResults(userList);
	    assertEquals(userList.get(0).getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(userList.get(1).getSchoolId(), "f5897384-9488-466f-b049-1992f7a53f15");

 	}

 	@Test
    public void courseHelperTest() throws ResourceNotFoundException {

	    Course c = new Course();
	    c.setSchoolId("1");

        attributeTransformer.processResults(c);
        assertEquals(c.getSchoolId(),"f9a75f84-130b-419e-bbe6-463585e930e9");

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course());
        courseList.add(new Course());

        courseList.get(0).setSchoolId("1");
        courseList.get(1).setSchoolId("2");

        attributeTransformer.processResults(courseList);
        assertEquals(courseList.get(0).getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(courseList.get(1).getSchoolId(), "f5897384-9488-466f-b049-1992f7a53f15");
    }

    @Test
    public void classHelperTest() throws ResourceNotFoundException {

	    ClassOfCourse c = new ClassOfCourse();
	    c.setSchoolId("1");
	    c.setCourseId("1");

	    attributeTransformer.processResults(c);
        assertEquals(c.getSchoolId(),"f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(c.getCourseId(), "7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4");

        List<ClassOfCourse> classList = new ArrayList<>();
        classList.add(new ClassOfCourse());
        classList.add(new ClassOfCourse());

        classList.get(0).setSchoolId("1");
        classList.get(0).setCourseId("1");
        classList.get(1).setSchoolId("2");
        classList.get(1).setCourseId("2");

        attributeTransformer.processResults(classList);
        assertEquals(classList.get(0).getSchoolId(), "f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(classList.get(0).getCourseId(),"7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4");

        assertEquals(classList.get(1).getSchoolId(), "f5897384-9488-466f-b049-1992f7a53f15");
        assertEquals(classList.get(1).getCourseId(),"1970f8a9-6595-4063-9e2e-6bb424e6913e");

    }

    @Test
    public void enrollmentHelperTest() throws ResourceNotFoundException {

        Enrollment e = new Enrollment();
        e.setUserId("1");
        e.setClassId("1");

        attributeTransformer.processResults(e);
        assertEquals(e.getUserId(),"cda272c0-bf6c-4e72-8b13-5f1f3be72339");
        assertEquals(e.getClassId(), "5fbd34b6-ea52-4a4a-b6ae-e43f60139695");

        List<Enrollment> enrollmentList = new ArrayList<>();
        enrollmentList.add(new Enrollment());
        enrollmentList.add(new Enrollment());

        enrollmentList.get(0).setUserId("1");
        enrollmentList.get(0).setClassId("1");
        enrollmentList.get(1).setUserId("2");
        enrollmentList.get(1).setClassId("2");

        attributeTransformer.processResults(enrollmentList);
        assertEquals(enrollmentList.get(0).getUserId(), "cda272c0-bf6c-4e72-8b13-5f1f3be72339");
        assertEquals(enrollmentList.get(0).getClassId(),"5fbd34b6-ea52-4a4a-b6ae-e43f60139695");

        assertEquals(enrollmentList.get(1).getUserId(), "bc16d091-7017-4f2f-9109-250fd590ca6a");
        assertEquals(enrollmentList.get(1).getClassId(),"cc724397-3281-4e3a-90a4-8eb27b23dc37");

    }

    @Test
    public void testNullResults(){

	    List<Object> testList = new ArrayList<>();

	    try {
            attributeTransformer.processResults(testList);
            fail ("Exception is expected");
        } catch (ResourceNotFoundException e){
	        // pass
        }

        List<Object> nullList = null;

        try {
            attributeTransformer.processResults(nullList);
            fail ("Exception is expected");
        } catch (ResourceNotFoundException e){
            // pass
        }

        try {
            attributeTransformer.processResults(null);
            fail ("Exception is expected");
        } catch (ResourceNotFoundException e){
            // pass
        }

    }

    @Test
    public void testValidation() throws Exception {

        validator.validateUser("8057df9d-72a3-419a-98b5-6eab87ec0a6d","any");
	    try {
	        validator.validateUser("x","any");
	        fail ("Id should be invalid");
        } catch (UserNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_USER + "x"));
        }

        validator.validateUser("f1e4b385-b0c9-4054-ad08-95c580ac715d", "teacher");
        try {
            validator.validateUser("8057df9d-72a3-419a-98b5-6eab87ec0a6d", "teacher");
            fail ("Id student - should be invalid");
        } catch (UserNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_USER + "8057df9d-72a3-419a-98b5-6eab87ec0a6d"));
        }

        validator.validateUser("8057df9d-72a3-419a-98b5-6eab87ec0a6d", "student");
        try {
            validator.validateUser("f1e4b385-b0c9-4054-ad08-95c580ac715d", "student");
            fail ("Id teacher - should be invalid");
        } catch (UserNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_USER + "f1e4b385-b0c9-4054-ad08-95c580ac715d"));
        }

        validator.validateClass("dca81f5a-1d99-491a-85fb-ad9591d4b96d");
        try {
            validator.validateClass("x");
            fail ("Id should be invalid");
        } catch (ClassOfCourseNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_CLASS + "x"));
        }

        validator.validateCourse("2441eeb2-4df0-4726-a882-f0e722d129c6");
        try {
            validator.validateCourse("x");
            fail ("Id should be invalid");
        } catch (CourseNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_COURSE + "x"));
        }

        validator.validateSchool("f9a75f84-130b-419e-bbe6-463585e930e9");
        try {
            validator.validateSchool("x");
            fail ("Id should be invalid");
        } catch (SchoolNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_SCHOOL + "x"));
        }

        validator.validateEnrollment("44e3d2cf-af91-4e2f-a5ec-5e304b5a66cb");
        try {
            validator.validateEnrollment("x");
            fail ("Id should be invalid");
        } catch (EnrollmentNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_ENROLLMENT + "x"));
        }

        validator.validateClassTerm("Fall");
        try {
            validator.validateClassTerm("x");
            fail ("Id should be invalid");
        } catch (TermNotFoundException e){
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_TERM));
        }

    }


}
