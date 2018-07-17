package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.TermNotFoundException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.service.interfaces.ClassService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "Term Controller", description = "Set of endpoints for reading Terms")
public class TermController {

    private ClassService classService;

    @Autowired
    TermController(ClassService classService) {
        this.classService = classService;
    }

    @RequestMapping(value="/terms/{term}/classes", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of classes that are taught in this term.",
            response=ClassOfCourse.class, responseContainer="List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = ClassOfCourse.class, responseContainer="List")
    })
    @ResponseBody
    public List<?> getClassesForTerm(
            @ApiParam(value = "String of Term to select Classes from", required = true)
                @PathVariable("term") String term
    ) throws ClassOfCourseNotFoundException, TermNotFoundException {
        return classService.getClassesByTerm(term);
    }
}
