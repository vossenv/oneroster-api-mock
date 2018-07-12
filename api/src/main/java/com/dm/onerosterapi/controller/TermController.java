package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.TermNotFoundException;
import com.dm.onerosterapi.service.interfaces.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TermController {

    private ClassService classService;

    @Autowired
    TermController(ClassService classService) {
        this.classService = classService;
    }

    @RequestMapping(value="/terms/{id}/classes", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getClassesForTerm(@PathVariable("id") String id) throws ClassOfCourseNotFoundException, TermNotFoundException {
        return classService.getClassesByTerm(id);
    }
}
