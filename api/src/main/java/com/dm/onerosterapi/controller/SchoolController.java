package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SchoolController {

    private SchoolService schoolService;
    private ClassService classService;
    private CourseService courseService;
    private EnrollmentService enrollmentService;
    private UserService userService;

    @Autowired
    SchoolController(SchoolService schoolService, ClassService classService, CourseService courseService,
                     EnrollmentService enrollmentService, UserService userService){
        this.schoolService = schoolService;
        this.classService = classService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
        this.userService = userService;
    }

    @RequestMapping(value="/schools", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getAllSchools() throws SchoolNotFoundException {
        return schoolService.getAllSchools();
    }

    @RequestMapping(value="/schools/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object getSchoolById(@PathVariable("id") String id) throws SchoolNotFoundException {
        return schoolService.getBySourcedId(id);
    }

    @RequestMapping(value="/schools/{id}/classes", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getClassesForSchool(@PathVariable("id") String id) throws ClassOfCourseNotFoundException, SchoolNotFoundException {
        return classService.getClassesBySchool(id);
    }

    @RequestMapping(value="/schools/{id}/courses", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getCoursesForSchool(@PathVariable("id") String id) throws CourseNotFoundException {
        return courseService.getCoursesBySchool(id);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/enrollments", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getEnrollmentsForClassInSchool(@PathVariable("school_id") String school_id,
                                                  @PathVariable("class_id") String class_id) throws EnrollmentNotFoundException {
        return enrollmentService.getEnrollmentsForClassInSchool(class_id, school_id);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/students", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getStudentsForClassInSchool(@PathVariable("school_id") String school_id,
                                               @PathVariable("class_id") String class_id) throws UserNotFoundException {
        return userService.getStudentsForClassInSchool(class_id, school_id);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/teachers", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getTeachersForClassInSchool(@PathVariable("school_id") String school_id,
                                               @PathVariable("class_id") String class_id) throws UserNotFoundException {
        return userService.getTeachersForClassInSchool(class_id, school_id);
    }

    @RequestMapping(value="/schools/{id}/enrollments", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getEnrollmentsForSchool(@PathVariable("id") String id) throws EnrollmentNotFoundException {
        return enrollmentService.getEnrollmentsForSchool(id);
    }

    @RequestMapping(value="/schools/{id}/students", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getStudentsBySchool(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getStudentsBySchool(id);
    }

    @RequestMapping(value="/schools/{id}/teachers", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getTeachersBySchool(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getTeachersBySchool(id);
    }


}
