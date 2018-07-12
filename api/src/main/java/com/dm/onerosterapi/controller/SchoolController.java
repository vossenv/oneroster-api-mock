package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
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

}
