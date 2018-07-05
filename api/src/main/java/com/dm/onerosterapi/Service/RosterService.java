package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.model.User;

import java.util.List;

public interface RosterService {

    public User getUserById(int userId);
    public List<User> getAllUsers();

    public ClassOfCourse getClassById(int classId);
    public List<ClassOfCourse> getAllClasses();

    public Enrollment getEnrollmentById(int enrollmentId);
    public List<Enrollment> getAllEnrollments();

}
