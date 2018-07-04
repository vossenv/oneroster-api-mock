package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;

import java.util.List;



public interface RosterDao {

    public List<User> getAllUsers();
    public User getUserById(int userId);
    public ClassOfCourse getClassById(int classId);
    public List<ClassOfCourse> getAllClasses();

}
