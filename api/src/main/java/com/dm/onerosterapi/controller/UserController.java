package com.dm.onerosterapi.controller;


import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.UserService;
import com.dm.onerosterapi.utility.AllowedTypes;
import com.dm.onerosterapi.utility.ApiResponseHandler;
import com.dm.onerosterapi.utility.SimplePage;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "User Controller", description = "Set of endpoints for reading Users")
public class UserController {

    private UserService userService;
    private ClassService classService;


    @Autowired
    UserController(UserService userService, ClassService classService) {
        this.userService = userService;
        this.classService = classService;
    }

    @ApiOperation(value = "Return collection of users.", response = User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public Object getAllUsers(
            @RequestParam("offset") Optional<Integer> offset,
            @RequestParam("limit") Optional<Integer> limit)
            throws UserNotFoundException {

        SimplePage p = new SimplePage(offset, limit, AllowedTypes.User);
        return ApiResponseHandler
                .buildApiResponse(userService.getAllUsers(p.getOffset(), p.getLimit()), p);

    }

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return collection of students.", response = User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    public Object getAllStudents(
            @RequestParam("offset") Optional<Integer> offset,
            @RequestParam("limit") Optional<Integer> limit)
            throws UserNotFoundException {
        SimplePage p = new SimplePage(offset, limit, AllowedTypes.Student);
        return ApiResponseHandler
                .buildApiResponse(userService.getAllStudents(p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return collection of teachers.", response = User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    public Object getAllTeachers(
            @RequestParam("offset") Optional<Integer> offset,
            @RequestParam("limit") Optional<Integer> limit)
            throws UserNotFoundException {
        SimplePage p = new SimplePage(offset, limit, AllowedTypes.Teacher);
        return ApiResponseHandler
                .buildApiResponse(userService.getAllTeachers(p.getOffset(), p.getLimit()), p);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return specific user.", response = User.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = User.class, responseContainer = "List")
    })
    public Object getUserById(
            @ApiParam(value = "String of the User to be selected.", required = true)
            @PathVariable("id") String id
    ) throws UserNotFoundException {
        return userService.getUserBySourcedId(id);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return specific student.", response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class)
    })
    public Object getStudentById(
            @ApiParam(value = "SourcedId of Student to be selected.", required = true)
            @PathVariable("id") String id
    ) throws UserNotFoundException {
        return userService.getStudentBySourcedId(id);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return specific teacher.", response = User.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = User.class)
    })
    public Object getTeacherById(
            @ApiParam(value = "SourcedId of Teacher to be selected.", required = true)
            @PathVariable("id") String id
    ) throws UserNotFoundException {
        return userService.getTeacherBySourcedId(id);
    }

    @RequestMapping(value = "/users/{id}/classes", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return the collection of classes attended by this user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = ClassOfCourse.class, responseContainer = "List")
    })
    public List<?> getClassesForUser(
            @ApiParam(value = "SourcedId of User to select Classes from.", required = true)
            @PathVariable("id") String id) throws ClassOfCourseNotFoundException, UserNotFoundException {
        return classService.getClassesByUser(id);
    }

    @RequestMapping(value = "/students/{id}/classes", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return the collection of classes that this student is taking.",
            response = ClassOfCourse.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = ClassOfCourse.class, responseContainer = "List")
    })
    public List<?> getClassesForStudent(
            @ApiParam(value = "SourcedId of the Student to select Classes from", required = true)
            @PathVariable("id") String id
    ) throws ClassOfCourseNotFoundException, UserNotFoundException {
        return classService.getClassesByStudent(id);
    }

    @RequestMapping(value = "/teachers/{id}/classes", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return the collection of classes that this teacher is teaching.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",
                    response = ClassOfCourse.class, responseContainer = "List")
    })
    public List<?> getClassesForTeachers(
            @ApiParam(value = "SourcedId of the Teacher to select Classes from", required = true)
            @PathVariable("id") String id
    ) throws ClassOfCourseNotFoundException, UserNotFoundException {
        return classService.getClassesByTeacher(id);
    }

}
