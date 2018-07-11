package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EnrollmentController {

    private EnrollmentService enrollmentService;

    @Autowired
    EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @RequestMapping(value="/enrollments", method=RequestMethod.GET)
    @ResponseBody
    public List<?> getAllEnrollments() throws EnrollmentNotFoundException {
        return enrollmentService.getAllEnrollments();
    }

    @RequestMapping(value="/enrollments/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Object getEnrollmentById(@PathVariable("id") String id) throws EnrollmentNotFoundException {
        return enrollmentService.getBySourcedId(id);
    }
}
