package com.dm.onerosterapi.service;

import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.service.interfaces.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class courses {

	@Autowired
    CourseService courseService;

    private static final String tstSId = "2441eeb2-4df0-4726-a882-f0e722d129c6";
    private static final String tstId = "11";

    @Test
    public void getCourseBySourcedId() throws CourseNotFoundException {
        assertTrue(checkValues(courseService.getBySourcedId(tstSId)));
    }

	@Test
	public void getAllCourses() throws CourseNotFoundException {
        List<Course> courseList = courseService.getAllCourses(0,Integer.MAX_VALUE);
        assertEquals(courseList.size(),42);
        assertTrue(checkValues(courseList.get(10)));
	}

	@Test
    public void getCoursesBySchool() throws CourseNotFoundException, SchoolNotFoundException {
        List<Course> courseList = courseService.getCoursesBySchool("f9a75f84-130b-419e-bbe6-463585e930e9",0,Integer.MAX_VALUE);
        assertEquals(courseList.size(),21);
    }

    @Test
    public void testFailedSearch(){
        try {
            Course c = courseService.getBySourcedId("500");
            fail("NP Exception expected");
        } catch (CourseNotFoundException e){
            // pass
        }
    }

    private static boolean checkValues(Course testObject){

        Course refObject = new Course();
        refObject.setCourseId(tstId);
        refObject.setSourcedId(tstSId);
        refObject.setSchoolId("f9a75f84-130b-419e-bbe6-463585e930e9");
        refObject.setDateLastModified("2017-12-16 01:34:39");
        refObject.setStatus("active");
        refObject.setMetadata("");
        refObject.setGrade("7");
        refObject.setTitle("History II");
        refObject.setSchoolYear("2018");
        refObject.setCourseCode("His-102");
        refObject.setSubjects("History II");

        return (testObject.equals(refObject));

    }

}
