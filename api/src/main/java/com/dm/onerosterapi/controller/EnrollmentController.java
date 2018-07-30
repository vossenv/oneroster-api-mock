package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.exceptions.InvalidParameterException;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.model.SimplePage;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import com.dm.onerosterapi.utility.ApiResponseBuilder;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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
    public Object getAllEnrollments(
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws EnrollmentNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(enrollmentService.getAllEnrollments( p.getOffset(), p.getLimit()), p);
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
