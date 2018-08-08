package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.*;
import com.dm.onerosterapi.service.interfaces.*;
import com.dm.onerosterapi.utility.ApiResponseBuilder;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "DefaultAnnotationParam"})
@Api(tags = "School Controller", description = "Set of endpoints for reading Schools")
@CrossOrigin
public class SchoolController {

    final private SchoolService schoolService;
    final private ClassService classService;
    final private CourseService courseService;
    final private EnrollmentService enrollmentService;
    final private UserService userService;

    @Inject
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
    public Object getAllSchools(
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws SchoolNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(schoolService.getAllSchools(p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/schools/{id}", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return specific school. A School is an instance of an Org.", response=School.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = School.class)
    })
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
    public Object getClassesForSchool(
            @ApiParam(value = "SourcedId of School to select Classes from", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws ClassOfCourseNotFoundException, SchoolNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(classService.getClassesBySchool(id, p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/schools/{id}/courses", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of courses taught by this school.",
            response=Course.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = Course.class, responseContainer = "List")
    })
    public Object getCoursesForSchool(
            @ApiParam(value = "SourcedId of School to select Courses from", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws CourseNotFoundException,SchoolNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(courseService.getCoursesBySchool(id,p.getOffset(), p.getLimit()), p);

    }

    @RequestMapping(value="/schools/{id}/enrollments", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of all enrollments for this school.",
            response=Enrollment.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = Enrollment.class, responseContainer = "List")
    })
    public Object getEnrollmentsForSchool(
            @ApiParam(value = "SourcedId of School to select Enrollments from", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws EnrollmentNotFoundException, SchoolNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(enrollmentService.getEnrollmentsForSchool(id, p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/schools/{id}/students", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of students attending this school.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    public Object getStudentsBySchool(
            @ApiParam(value = "SourcedId of School to select Students from", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws UserNotFoundException, SchoolNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(userService.getUsersBySchool(id, "student", p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/schools/{id}/teachers", method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of teachers teaching at this school.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    public Object getTeachersBySchool(
            @ApiParam(value = "SourcedId of School to select Teachers from", required = true)
            @PathVariable("id") String id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws UserNotFoundException, SchoolNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(userService.getUsersBySchool(id,"teacher", p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/enrollments",
            method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of all enrollments into this class.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                response = Enrollment.class, responseContainer = "List")
    })
    public Object getEnrollmentsForClassInSchool(
            @ApiParam(value = "SourcedId of School to select a Class from", required = true)
            @PathVariable("school_id") String school_id,
            @ApiParam(value = "SourcedId of Class to select Enrollments from", required = true)
            @PathVariable("class_id") String class_id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws SchoolNotFoundException, ClassOfCourseNotFoundException, EnrollmentNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(enrollmentService.getEnrollmentsForClassInSchool(class_id, school_id, p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/students",
            method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of students taking this class in this school.",
            response=User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    public Object getStudentsForClassInSchool(
            @ApiParam(value = "SourcedId of School to select a Class from", required = true)
            @PathVariable("school_id") String school_id,
            @ApiParam(value = "SourcedId of Class to select Students from", required = true)
            @PathVariable("class_id") String class_id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws SchoolNotFoundException, ClassOfCourseNotFoundException, UserNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(userService.getUsersForClassInSchool(class_id, school_id, "student", p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value="/schools/{school_id}/classes/{class_id}/teachers",
            method=RequestMethod.GET, produces="application/json")
    @ApiOperation(value="Return the collection of teachers taking this class in this school.",
            response=User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    public Object getTeachersForClassInSchool(
            @ApiParam(value = "SourcedId of School to select a Class from", required = true)
            @PathVariable("school_id") String school_id,
            @ApiParam(value = "SourcedId of Class to select Teachers from", required = true)
            @PathVariable("class_id") String class_id,
            @ApiParam(value = "Specify the offset of the first result to return.", required = false)
            @RequestParam("offset") Optional<String> offset,
            @ApiParam(value = "Specify the number of results to return.", required = false)
            @RequestParam("limit") Optional<String> limit,
            @ApiIgnore HttpServletRequest request)
            throws SchoolNotFoundException, ClassOfCourseNotFoundException, UserNotFoundException, InvalidParameterException {
        SimplePage p = new SimplePage(request);
        return ApiResponseBuilder
                .buildApiResponse(userService.getUsersForClassInSchool(class_id, school_id, "teacher", p.getOffset(), p.getLimit()), p);

    }
}
