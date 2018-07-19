package com.dm.onerosterapi.service;

import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.service.interfaces.ClassService;
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
public class classes {

    @Autowired
    ClassService classService;

    private static final String tstSId = "dca81f5a-1d99-491a-85fb-ad9591d4b96d";
    private static final String tstId = "65";

    @Test
    public void getClassOfCourseBySourcedId() throws ClassOfCourseNotFoundException {
        assertTrue(checkValues(classService.getBySourcedId(tstSId)));
    }

    @Test
    public void getAllClassOfCourses() throws ClassOfCourseNotFoundException {
        List<ClassOfCourse> classList = classService.getAllClasses(0, Integer.MAX_VALUE);
        assertEquals(classList.size(), 84);
        assertTrue(checkValues(classList.get(64)));
    }

	@Test
    public void getClassesByUser() throws ClassOfCourseNotFoundException, UserNotFoundException {
        List<ClassOfCourse> classList = classService
                .getClassesByUser("8057df9d-72a3-419a-98b5-6eab87ec0a6d","any",0, Integer.MAX_VALUE);
        assertEquals(classList.size(),14);
    }

    @Test
    public void getClassesByStudent() throws ClassOfCourseNotFoundException, UserNotFoundException {
        List<ClassOfCourse> classList = classService
                .getClassesByUser("cda272c0-bf6c-4e72-8b13-5f1f3be72339","student", 0, Integer.MAX_VALUE);
        assertEquals(classList.size(), 14);

        try {
            classService.getClassesByUser("f1e4b385-b0c9-4054-ad08-95c580ac715d","student", 0, Integer.MAX_VALUE);
            fail("Exception expected");
        } catch (UserNotFoundException e) {
            // pass
        }
    }

    @Test
    public void getClassesByTeacher() throws ClassOfCourseNotFoundException, UserNotFoundException {
        List<ClassOfCourse> classList = classService.getClassesByUser("f1e4b385-b0c9-4054-ad08-95c580ac715d", "teacher", 0, Integer.MAX_VALUE);
        assertEquals(classList.size(), 14);

        try {
            classService.getClassesByUser("cda272c0-bf6c-4e72-8b13-5f1f3be72339","teacher", 0, Integer.MAX_VALUE);
            fail("Exception expected");
        } catch (UserNotFoundException e) {
            // pass
        }
    }

    @Test
    public void getClassesByCourse() throws ClassOfCourseNotFoundException, CourseNotFoundException {
        List<ClassOfCourse> classList = classService.getClassesByCourse("7c2fc4b7-d53c-4b37-9ba4-1ba3cf2e0fe4", 0, Integer.MAX_VALUE);
        assertEquals(classList.size(), 2);
    }

    @Test
    public void getClassesByTerm() throws ClassOfCourseNotFoundException, TermNotFoundException {
        List<ClassOfCourse> classList = classService.getClassesByTerm("Fall", 0, Integer.MAX_VALUE);
        assertEquals(classList.size(), 42);

        classList = classService.getClassesByTerm("Spring", 0, Integer.MAX_VALUE);
        assertEquals(classList.size(), 42);
    }

    @Test
    public void getClassesBySchool() throws ClassOfCourseNotFoundException, SchoolNotFoundException {
        List<ClassOfCourse> classList = classService.getClassesBySchool("f9a75f84-130b-419e-bbe6-463585e930e9", 0, Integer.MAX_VALUE);
        assertEquals(classList.size(), 42);
    }


    @Test
    public void testFailedSearch() {
        try {
            classService.getBySourcedId("xxx");
            fail("NP Exception expected");
        } catch (ClassOfCourseNotFoundException e) {
            // pass
        }
    }

    private static boolean checkValues(ClassOfCourse testObject) {

        ClassOfCourse refObject = new ClassOfCourse();
        refObject.setClassId(tstId);
        refObject.setCourseId("7975b9f6-2ba5-4d93-bcf6-57137edcff07");
        refObject.setSchoolId("f9a75f84-130b-419e-bbe6-463585e930e9");
        refObject.setClassCode("Physics II - Fall");
        refObject.setClassType("scheduled");
        refObject.setDateLastModified("2017-11-10 03:07:57");
        refObject.setSourcedId(tstSId);
        refObject.setStatus("active");
        refObject.setLocation("212");
        refObject.setPeriods("2");
        refObject.setTerm("Fall");
        refObject.setMetadata("");

        return (testObject.equals(refObject));

    }

}
