package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    private UserService userService;
    private ClassService classService;

    @Autowired
    UserController(UserService userService, ClassService classService){
        this.userService = userService;
        this.classService = classService;
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getAllUsers() throws UserNotFoundException {
        return userService.getAllUsers();
    }

    @RequestMapping(value="/students", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getAllStudents() throws UserNotFoundException {
        return userService.getAllStudents();
    }

    @RequestMapping(value="/teachers", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getAllTeachers() throws UserNotFoundException {
        return userService.getAllTeachers();
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.GET )
    @ResponseBody
    public Object getUserById(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getUserBySourcedId(id);
    }

    @RequestMapping(value="/students/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object getStudentById(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getStudentBySourcedId(id);
    }

    @RequestMapping(value="/teachers/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object getTeacherById(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getTeacherBySourcedId(id);
    }

    @RequestMapping(value="/users/{id}/classes", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getClassesForUser(@PathVariable("id") String id) throws ClassNotFoundException {
        return classService.getClassesByUser(id);
    }

    @RequestMapping(value="/students/{id}/classes", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getClassesForStudent(@PathVariable("id") String id) throws ClassNotFoundException {
        return classService.getClassesByStudent(id);
    }

    @RequestMapping(value="/teachers/{id}/classes", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getClassesForTeachers(@PathVariable("id") String id) throws ClassNotFoundException {
        return classService.getClassesByTeacher(id);
    }

}
