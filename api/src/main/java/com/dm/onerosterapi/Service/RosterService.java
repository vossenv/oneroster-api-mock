package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;

import java.util.List;

public interface RosterService {

    User getUserById(int userId);
    List<User> getAllUsers();

    ClassOfCourse getClassById(int classId);
    List<ClassOfCourse> getAllClasses();

}
