package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CourseController {

    private CourseService courseService;
    private ClassService classService;

    @Autowired
    CourseController(CourseService courseService, ClassService classService) {
        this.courseService = courseService;
        this.classService = classService;
    }

    @RequestMapping(value="/courses", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getAllCourses() throws CourseNotFoundException {
        return courseService.getAllCourses();
    }

    @RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object getCourseById(@PathVariable("id") String id) throws CourseNotFoundException {
        return courseService.getBySourcedId(id);
    }

    @RequestMapping(value="/courses/{id}/classes", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getClassesForCourse(@PathVariable("id") String id) throws ClassNotFoundException {
        return classService.getClassesByCourse(id);
    }

}
