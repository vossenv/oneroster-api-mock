package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.InvalidParameterException;
import com.dm.onerosterapi.exceptions.TermNotFoundException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.SimplePage;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.utility.ApiResponseBuilder;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "DefaultAnnotationParam"})
@Api(tags = "Term Controller", description = "Set of endpoints for reading Terms")
@CrossOrigin
public class TermController {

    final private ClassService classService;

    @Inject
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
    public Object getClassesForTerm(
            @ApiParam(value = "String of Term to select Classes from", required = true)
            @PathVariable("term") String term,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws ClassOfCourseNotFoundException, TermNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(classService.getClassesByTerm(term,p.getOffset(), p.getLimit()), p);

    }
}
