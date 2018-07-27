package com.dm.onerosterapi.service;

import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import com.dm.onerosterapi.service.interfaces.UserService;
import com.dm.onerosterapi.apiconfig.ApiMessageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class exceptions {

    @Autowired
    ClassService classService;
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    @Autowired
    EnrollmentService enrollmentService;

    private static final String classId = "dca81f5a-1d99-491a-85fb-ad9591d4b96d";
    private static final String studentId = "8057df9d-72a3-419a-98b5-6eab87ec0a6d";
    private static final String teacherId = "f1e4b385-b0c9-4054-ad08-95c580ac715d";
    private static final String schoolId = "f9a75f84-130b-419e-bbe6-463585e930e9";

    @Test
    public void testUserExceptions() throws
            UserNotFoundException,
            ClassOfCourseNotFoundException,
            SchoolNotFoundException {

        try {
            userService.getUserBySourcedId("x");
        } catch (UserNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.NO_USERS_FOR_ID + "x"));
        }

        try {
            userService.getTeacherBySourcedId(studentId);
        } catch (UserNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.NOT_A_TEACHER + studentId));
        }

        try {
            userService.getStudentBySourcedId(teacherId);
        } catch (UserNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.NOT_A_STUDENT + teacherId));
        }

        try {
            userService.getUsersByClass("x","y",0,Integer.MAX_VALUE);
        } catch (ClassOfCourseNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_CLASS + "x"));
        }

        try {
            userService.getUsersBySchool("x","y", 0, Integer.MAX_VALUE);
        } catch (SchoolNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_SCHOOL + "x"));
        }

        try {
            userService.getUsersForClassInSchool("x", "y", "any", 0, Integer.MAX_VALUE);
        } catch (ClassOfCourseNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_CLASS + "x"));
        }

        try {
            userService.getUsersForClassInSchool(classId, "y", "any", 0, Integer.MAX_VALUE);
        } catch (SchoolNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_SCHOOL + "y"));
        }

    }

    @Test
    public void testClassExceptions() throws
            UserNotFoundException,
            ClassOfCourseNotFoundException {

        try {
            classService.getBySourcedId("x");
        } catch (ClassOfCourseNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.NO_CLASSES_FOR_ID + "x"));
        }

        try {
            classService.getClassesByTerm("x", 0, Integer.MAX_VALUE);
        } catch (TermNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_TERM + "x"));
        }

        try {
            classService.getClassesBySchool("x", 0, Integer.MAX_VALUE);
        } catch (SchoolNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_SCHOOL + "x"));
        }

        try {
            classService.getClassesByCourse("x", 0, Integer.MAX_VALUE);
        } catch (CourseNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_COURSE + "x"));
        }

        try {
            classService.getClassesByUser("x", "any",0, Integer.MAX_VALUE);
        } catch (UserNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_USER + "x"));
        }

        classService.getClassesByUser(studentId, "student",0, Integer.MAX_VALUE);

    }


    @Test
    public void testCourseExceptions() throws CourseNotFoundException {

        try {
            courseService.getCoursesBySchool("x", 0, Integer.MAX_VALUE);
        } catch (SchoolNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_SCHOOL + "x"));
        }

    }


    @Test
    public void testEnrollmentsExceptions() throws
            ClassOfCourseNotFoundException,
            SchoolNotFoundException,
            EnrollmentNotFoundException {

        try {
            enrollmentService.getEnrollmentsForSchool("x",0, Integer.MAX_VALUE);
        } catch (SchoolNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_SCHOOL + "x"));
        }

        try {
            enrollmentService.getEnrollmentsForClassInSchool("x", "y", 0, Integer.MAX_VALUE);
        } catch (ClassOfCourseNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_CLASS + "x"));
        }

        try {
            enrollmentService.getEnrollmentsForClassInSchool(classId, "y", 0, Integer.MAX_VALUE);
        } catch (SchoolNotFoundException e) {
            assertTrue(e.getMessage().contains(ApiMessageConfig.INVALID_SCHOOL + "y"));
        }

        enrollmentService.getEnrollmentsForClassInSchool(classId, schoolId, 0, Integer.MAX_VALUE);

    }

}
