package com.dm.onerosterapi.controller;

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
    public List<?> getAllClasses() throws ClassNotFoundException {
        return classService.getAllClasses();
    }
}
