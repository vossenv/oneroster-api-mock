package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.model.User;

import java.util.List;



public interface RosterDao {

    public List<User> getUsersByClass(String classSourcedId);
    public List<ClassOfCourse> getClassesByUser(String userSourcedId, String role);
    public List<ClassOfCourse> getClassesByCourse(String courseId);

    public List<ClassOfCourse> getClassesBySchool(String schoolId);
    public List<Course> getCoursesBySchool(String schoolId);
    public List<Enrollment> getEnrollmentsForSchool(String schoolId);
    public List<User> getUsersForSchool(String schoolId);

}
