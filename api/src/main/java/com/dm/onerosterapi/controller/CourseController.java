package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.exceptions.InvalidParameterException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.model.SimplePage;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.utility.ApiResponseBuilder;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@Api(tags = "Course Controller", description = "Set of endpoints for reading Courses")
public class CourseController {

    final private CourseService courseService;
    final private ClassService classService;

    @Autowired
    CourseController(CourseService courseService, ClassService classService) {
        this.courseService = courseService;
        this.classService = classService;
    }

    @RequestMapping(value="/courses", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return collection of courses.",
            response=Course.class, responseContainer="List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = Course.class, responseContainer="List")
    })
    public Object getAllCourses(
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws CourseNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(courseService.getAllCourses( p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/courses/{id}", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return specific course.", response=Course.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Course.class)
    })
    public Object getCourseById(
            @ApiParam(value = "SourcedId of Course to be selected", required = true)
                @PathVariable("id") String id
    ) throws CourseNotFoundException {
        return courseService.getBySourcedId(id);
    }

    @RequestMapping(value="/courses/{id}/classes", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of classes that are teaching this course.",
            response=ClassOfCourse.class, responseContainer="List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = ClassOfCourse.class, responseContainer="List")
    })
    public Object getClassesForCourse(
            @ApiParam(value = "SourcedId of Course to select Classes from", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws ClassOfCourseNotFoundException, CourseNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(classService.getClassesByCourse(id, p.getOffset(), p.getLimit()), p);
    }

}
