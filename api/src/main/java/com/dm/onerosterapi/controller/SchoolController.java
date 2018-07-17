package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.*;
import com.dm.onerosterapi.service.interfaces.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(description = "Set of endpoints for reading Schools")
public class SchoolController {

    private SchoolService schoolService;
    private ClassService classService;
    private CourseService courseService;
    private EnrollmentService enrollmentService;
    private UserService userService;

    @Autowired
    SchoolController(SchoolService schoolService, ClassService classService, CourseService courseService,
                     EnrollmentService enrollmentService, UserService userService){
        this.schoolService = schoolService;
        this.classService = classService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
        this.userService = userService;
    }

    @RequestMapping(value="/schools", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return collection of schools. A School is an instance of an Org.",
                response=School.class, responseContainer="List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = School.class, responseContainer="List")
    })
    @ResponseBody
    public List<?> getAllSchools() throws SchoolNotFoundException {
        return schoolService.getAllSchools();
    }

    @RequestMapping(value="/schools/{id}", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return specific school. A School is an instance of an Org.", response=School.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = School.class)
    })
    @ResponseBody
    public Object getSchoolById(
            @ApiParam(value = "SourcedId of School to be selected", required = true)
                @PathVariable("id") String id
    ) throws SchoolNotFoundException {
        return schoolService.getBySourcedId(id);
    }

    @RequestMapping(value="/schools/{id}/classes", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of classes taught by this school.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = ClassOfCourse.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getClassesForSchool(
            @ApiParam(value = "SourcedId of School to select Classes from", required = true)
                @PathVariable("id") String id
    ) throws ClassOfCourseNotFoundException, SchoolNotFoundException {
        return classService.getClassesBySchool(id);
    }

    @RequestMapping(value="/schools/{id}/courses", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of courses taught by this school.",
            response=Course.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = Course.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getCoursesForSchool(
            @ApiParam(value = "SourcedId of School to select Courses from", required = true)
                @PathVariable("id") String id
    ) throws CourseNotFoundException,SchoolNotFoundException {
        return courseService.getCoursesBySchool(id);
    }

    @RequestMapping(value="/schools/{id}/enrollments", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of all enrollments for this school.",
            response=Enrollment.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = Enrollment.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getEnrollmentsForSchool(
            @ApiParam(value = "SourcedId of School to select Enrollments from", required = true)
                @PathVariable("id") String id
    ) throws EnrollmentNotFoundException, SchoolNotFoundException {
        return enrollmentService.getEnrollmentsForSchool(id);
    }

    @RequestMapping(value="/schools/{id}/students", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of students attending this school.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getStudentsBySchool(
            @ApiParam(value = "SourcedId of School to select Students from", required = true)
                @PathVariable("id") String id
    ) throws UserNotFoundException, SchoolNotFoundException {
        return userService.getStudentsBySchool(id);
    }

    @RequestMapping(value="/schools/{id}/teachers", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of teachers teaching at this school.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getTeachersBySchool(
            @ApiParam(value = "SourcedId of School to select Teachers from", required = true)
                @PathVariable("id") String id
    ) throws UserNotFoundException, SchoolNotFoundException {
        return userService.getTeachersBySchool(id);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/enrollments",
            method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of all enrollments into this class.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                response = Enrollment.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getEnrollmentsForClassInSchool(
            @ApiParam(value = "SourcedId of School to select a Class from", required = true)
                @PathVariable("school_id") String school_id,
            @ApiParam(value = "SourcedId of Class to select Enrollments from", required = true)
                @PathVariable("class_id") String class_id
    ) throws SchoolNotFoundException, ClassOfCourseNotFoundException, EnrollmentNotFoundException {
        return enrollmentService.getEnrollmentsForClassInSchool(class_id, school_id);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/students",
            method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of students taking this class in this school.",
            response=User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getStudentsForClassInSchool(
            @ApiParam(value = "SourcedId of School to select a Class from", required = true)
                @PathVariable("school_id") String school_id,
           @ApiParam(value = "SourcedId of Class to select Students from", required = true)
                @PathVariable("class_id") String class_id
    ) throws SchoolNotFoundException, ClassOfCourseNotFoundException, UserNotFoundException {
        return userService.getStudentsForClassInSchool(class_id, school_id);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/teachers",
            method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of teachers taking this class in this school",
            response=User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    @ResponseBody
    public List<?> getTeachersForClassInSchool(
            @ApiParam(value = "SourcedId of School to select a Class from", required = true)
                @PathVariable("school_id") String school_id,
            @ApiParam(value = "SourcedId of Class to select Teachers from", required = true)
                @PathVariable("class_id") String class_id
    ) throws SchoolNotFoundException, ClassOfCourseNotFoundException, UserNotFoundException {
        return userService.getTeachersForClassInSchool(class_id, school_id);
    }
}
