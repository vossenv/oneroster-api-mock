package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.service.interfaces.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClassController {

    private ClassService classService;

    @Autowired
    ClassController(ClassService classService) {
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
}
