package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public User getUserBySourcedId(String userId) throws UserNotFoundException;
    public User getStudentBySourcedId(String userId) throws UserNotFoundException;
    public User getTeacherBySourcedId(String userId) throws UserNotFoundException;

    public List<User> getAllUsers(int offset, int limit) throws UserNotFoundException;
    public List<User> getAllStudents(int offset, int limit) throws UserNotFoundException;
    public List<User> getAllTeachers(int offset, int limit) throws UserNotFoundException;

    public List<User> getAllUsers() throws UserNotFoundException;
    public List<User> getAllStudents() throws UserNotFoundException;
    public List<User> getAllTeachers() throws UserNotFoundException;

    public List<User> getUsersByClass(String classSourcedId) throws UserNotFoundException, ClassOfCourseNotFoundException;
    public List<User> getStudentsByClass(String classSourcedId) throws UserNotFoundException, ClassOfCourseNotFoundException;
    public List<User> getTeachersByClass(String classSourcedId) throws UserNotFoundException, ClassOfCourseNotFoundException;

    public List<User> getUsersBySchool(String schoolId) throws UserNotFoundException, SchoolNotFoundException;
    public List<User> getStudentsBySchool(String schoolId) throws UserNotFoundException, SchoolNotFoundException;
    public List<User> getTeachersBySchool(String schoolId) throws UserNotFoundException, SchoolNotFoundException;

    public List<User> getUsersForClassInSchool(String classId, String schoolId) throws UserNotFoundException, ClassOfCourseNotFoundException, SchoolNotFoundException;
    public List<User> getStudentsForClassInSchool(String classId, String schoolId) throws UserNotFoundException, ClassOfCourseNotFoundException, SchoolNotFoundException;
    public List<User> getTeachersForClassInSchool(String classId, String schoolId) throws UserNotFoundException, ClassOfCourseNotFoundException, SchoolNotFoundException;

}
