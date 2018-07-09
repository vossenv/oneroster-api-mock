package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
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
	public void getAllCourses(){
        List<Course> courseList = courseService.getAllCourses();
        assertEquals(courseList.size(),42);
        assertTrue(checkValues(courseList.get(10)));
	}

    @Test
    public void getCourseById(){
        Course c = courseService.getCourseById(tstId);
        assertTrue(checkValues(c));
    }

    @Test
    public void testFailedSearch(){
        try {
            Course c = courseService.getCourseById("500");
            fail("NP Exception expected");
        } catch (Exception e){
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
