package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface UserService {

    public User getUserById(int userId);
    public List<User> getAllUsers();
    public List<User> getAllStudents();
    public List<User> getAllTeachers();

    public List<User> getUsersByClass(String classSourcedId);
    public List<User> getStudentsByClass(String classSourcedId);
    public List<User> getTeachersByClass(String classSourcedId);
}
