package com.dm.onerosterapi.controller;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.CourseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(description = "Set of endpoints for reading Courses")
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
    @ResponseBody
    public List<?> getAllCourses() throws CourseNotFoundException {
        return courseService.getAllCourses();
    }

    @RequestMapping(value="/courses/{id}", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return specific course.", response=Course.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Course.class)
    })
    @ResponseBody
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
            @ApiResponse(code = 200, message = "Success", response = ClassOfCourse.class, responseContainer="List")
    })
    @ResponseBody
    public List<?> getClassesForCourse(
            @ApiParam(value = "SourcedId of Course to be selected", required = true)
                @PathVariable("id") String id
            ) throws ClassOfCourseNotFoundException, CourseNotFoundException {
        return classService.getClassesByCourse(id);
    }

}
