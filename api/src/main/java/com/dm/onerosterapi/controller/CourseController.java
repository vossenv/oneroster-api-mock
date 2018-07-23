package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.exceptions.InvalidParameterException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.apiconfig.ApiResponseBuilder;
import com.dm.onerosterapi.model.SimplePage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

@RestController
@Api(tags = "Course Controller", description = "Set of endpoints for reading Courses")
public class CourseController {

    private CourseService courseService;
    private ClassService classService;

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
            @RequestParam("offset") Optional<String> offset,
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore @RequestHeader("host") String host)
            throws CourseNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(offset, limit, host +  "/courses");
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
            @RequestParam("offset") Optional<String> offset,
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore @RequestHeader("host") String host)
            throws ClassOfCourseNotFoundException, CourseNotFoundException, InvalidParameterException {

        SimplePage p = new SimplePage(offset, limit, host +  "/courses/" + id + "/classes");
        return ApiResponseBuilder
                .buildApiResponse(classService.getClassesByCourse(id, p.getOffset(), p.getLimit()), p);
    }

}
