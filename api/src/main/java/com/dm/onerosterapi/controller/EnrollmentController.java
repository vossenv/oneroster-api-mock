package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "Enrollment Controller", description = "Set of endpoints for reading Enrollments")
public class EnrollmentController {

    private EnrollmentService enrollmentService;

    @Autowired
    EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @RequestMapping(value="/enrollments", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return collection of all enrollments.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = Enrollment.class, responseContainer="List")
    })
    public List<?> getAllEnrollments() throws EnrollmentNotFoundException {
        return enrollmentService.getAllEnrollments();
    }

    @RequestMapping(value="/enrollments/{id}", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return specific enrollment.", response = Enrollment.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Enrollment.class)
    })
    public Object getEnrollmentById(
            @ApiParam(value = "SourcedId of Enrollment to be selected", required = true)
                @PathVariable("id") String id
    ) throws EnrollmentNotFoundException {
        return enrollmentService.getBySourcedId(id);
    }
}
