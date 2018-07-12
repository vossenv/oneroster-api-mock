package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SchoolController {

    private SchoolService schoolService;
    private ClassService classService;
    private CourseService courseService;

    @Autowired
    SchoolController(SchoolService schoolService, ClassService classService, CourseService courseService){
        this.schoolService = schoolService;
        this.classService = classService;
        this.courseService = courseService;
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


}
