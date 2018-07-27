package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.model.User;

import java.util.List;

public interface UserService {

    User getUserBySourcedId(String userId) throws UserNotFoundException;
    User getStudentBySourcedId(String userId) throws UserNotFoundException;
    User getTeacherBySourcedId(String userId) throws UserNotFoundException;

    List<User> getAllUsers(String role, int offset, int limit) throws UserNotFoundException;
    List<User> getUsersByClass(String classSourcedId, String role, int offset, int limit) throws UserNotFoundException, ClassOfCourseNotFoundException;
    List<User> getUsersBySchool(String schoolId, String role, int offset, int limit) throws UserNotFoundException, SchoolNotFoundException;
    List<User> getUsersForClassInSchool(String classId, String schoolId, String role, int offset, int limit)
            throws UserNotFoundException, ClassOfCourseNotFoundException, SchoolNotFoundException;

}
