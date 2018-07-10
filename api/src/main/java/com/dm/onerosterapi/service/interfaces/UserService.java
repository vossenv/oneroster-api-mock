package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.model.*;

import java.util.List;

public interface UserService {

    public User getUserBySourcedId(String userId) throws UserNotFoundException;
    public User getStudentBySourcedId(String userId) throws UserNotFoundException;
    public User getTeacherBySourcedId(String userId) throws UserNotFoundException;

    public List<User> getAllUsers() throws UserNotFoundException;
    public List<User> getAllStudents() throws UserNotFoundException;
    public List<User> getAllTeachers() throws UserNotFoundException;

    public List<User> getUsersByClass(String classSourcedId) throws UserNotFoundException;
    public List<User> getStudentsByClass(String classSourcedId) throws UserNotFoundException;
    public List<User> getTeachersByClass(String classSourcedId) throws UserNotFoundException;

    public List<User> getUsersBySchool(String schoolId) throws UserNotFoundException;
    public List<User> getStudentsBySchool(String schoolId) throws UserNotFoundException;
    public List<User> getTeachersBySchool(String schoolId) throws UserNotFoundException;

    public List<User> getUsersForClassInSchool(String classId, String schoolId) throws UserNotFoundException;
    public List<User> getStudentsForClassInSchool(String classId, String schoolId) throws UserNotFoundException;
    public List<User> getTeachersForClassInSchool(String classId, String schoolId) throws UserNotFoundException;

}
