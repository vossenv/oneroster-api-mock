package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface RosterService {

    public User getUserById(int userId);
    public List<User> getAllUsers();
    public List<User> getAllStudents();
    public List<User> getAllTeachers();

    public ClassOfCourse getClassById(int classId);
    public List<ClassOfCourse> getAllClasses();

    public Course getCourseById(int courseId);
    public List<Course> getAllCourses();

    public Org getOrgById(int orgId);
    public List<Org> getAllOrgs();

    public Enrollment getEnrollmentById(int enrollmentId);
    public List<Enrollment> getAllEnrollments();

    public List<User> getUsersByClass(String classSourcedId);
    public List<User> getStudentsByClass(String classSourcedId);
    public List<User> getTeachersByClass(String classSourcedId);

}
