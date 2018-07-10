package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface UserService {

    public User getBySourcedId(String userId);

    public List<User> getAllUsers();
    public List<User> getAllStudents();
    public List<User> getAllTeachers();

    public List<User> getUsersByClass(String classSourcedId);
    public List<User> getStudentsByClass(String classSourcedId);
    public List<User> getTeachersByClass(String classSourcedId);

    public List<User> getUsersBySchool(String schoolId);
    public List<User> getStudentsBySchool(String schoolId);
    public List<User> getTeachersBySchool(String schoolId);

    public List<User> getUsersForClassInSchool(String classId, String schoolId);
    public List<User> getStudentsForClassInSchool(String classId, String schoolId);
    public List<User> getTeachersForClassInSchool(String classId, String schoolId);

}
