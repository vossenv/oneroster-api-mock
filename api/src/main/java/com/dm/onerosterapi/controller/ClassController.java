package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.InvalidParameterException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.SimplePage;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.UserService;
import com.dm.onerosterapi.utility.ApiResponseBuilder;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@RestController
@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "DefaultAnnotationParam"})
@Api(tags = "Class Controller", description = "Set of endpoints for reading Classes")
public class ClassController {

    final private ClassService classService;
    final private UserService userService;

    @Inject
    ClassController(ClassService classService, UserService userService) {
        this.userService = userService;
        this.classService = classService;
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return collection of classes.",
            response = ClassOfCourse.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = ClassOfCourse.class, responseContainer = "List")
    })
    public Object getAllClasses(
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws ClassOfCourseNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(classService.getAllClasses(p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value = "/classes/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return specific class.", response = ClassOfCourse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ClassOfCourse.class)
    })
    public Object getClassById(
            @ApiParam(value = "SourcedId of Class to be selected", required = true)
            @PathVariable("id") String id
    ) throws ClassOfCourseNotFoundException {
        return classService.getBySourcedId(id);
    }

    @RequestMapping(value = "/classes/{id}/students", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return the collection of students that are taking this class.",
            response = User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List")
    })
    public Object getStudentsForClass(
            @ApiParam(value = "SourcedId of Class to be selected", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws UserNotFoundException, ClassOfCourseNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(userService.getUsersByClass(id, "student", p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value = "/classes/{id}/teachers", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return the collection of teachers that are teaching this class.",
            response = User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List")
    })
    public Object getTeachersForClass(
            @ApiParam(value = "SourcedId of Class to be selected", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws UserNotFoundException, ClassOfCourseNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(userService.getUsersByClass(id, "teacher", p.getOffset(), p.getLimit()), p);
    }
}
