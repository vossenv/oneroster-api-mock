package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClassController {

    private ClassService classService;
    private UserService userService;

    @Autowired
    ClassController(ClassService classService, UserService userService) {
        this.userService = userService;
        this.classService = classService;
    }

    @RequestMapping(value="/classes", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getAllClasses() throws ClassOfCourseNotFoundException {
        return classService.getAllClasses();
    }

    @RequestMapping(value="/classes/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object getClassById(@PathVariable("id") String id) throws ClassOfCourseNotFoundException {
        return classService.getBySourcedId(id);
    }

    @RequestMapping(value="/classes/{id}/students", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getStudentsForClass(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getStudentsByClass(id);
    }

    @RequestMapping(value="/classes/{id}/teachers", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getTeachersForClass(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getTeachersByClass(id);
    }
}
