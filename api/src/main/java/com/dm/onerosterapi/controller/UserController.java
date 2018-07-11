package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions1.UserNotFoundException;
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

    @RequestMapping("/students")
    @ResponseBody
    public List<?> getAllStudents() throws UserNotFoundException {
        return userService.getAllStudents();
    }

    @RequestMapping("/teachers")
    @ResponseBody
    public List<?> getAllTeachers() throws UserNotFoundException {
        return userService.getAllTeachers();
    }

    @RequestMapping("/users/{id}")
    @ResponseBody
    public Object getUserById(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getUserBySourcedId(id);
    }

    @RequestMapping("/students/{id}")
    @ResponseBody
    public Object getStudentById(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getStudentBySourcedId(id);
    }

    @RequestMapping("/teachers/{id}")
    @ResponseBody
    public Object getTeacherById(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.getTeacherBySourcedId(id);
    }

    @RequestMapping("/users/{id}/classes")
    @ResponseBody
    public List<?> getClassesForUser(@PathVariable("id") String id) throws ClassNotFoundException {
        return classService.getClassesByUser(id);
    }

    @RequestMapping("/students/{id}/classes")
    @ResponseBody
    public List<?> getClassesForStudent(@PathVariable("id") String id) throws ClassNotFoundException {
        return classService.getClassesByStudent(id);
    }

    @RequestMapping("/teachers/{id}/classes")
    @ResponseBody
    public List<?> getClassesForTeachers(@PathVariable("id") String id) throws ClassNotFoundException {
        return classService.getClassesByTeacher(id);
    }

}
