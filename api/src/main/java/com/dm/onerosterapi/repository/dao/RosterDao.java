package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.utility.AllowedTypes;

import java.util.List;



public interface RosterDao {

    public List<User> getUsersByClass(String classSourcedId);
    public List<ClassOfCourse> getClassesByUser(String userSourcedId, String role);
    public List<ClassOfCourse> getClassesByCourse(String courseId);

    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId);
    public List<Course> getCoursesBySchool(String schoolSourcedId);
    public List<Enrollment> getEnrollmentsBySchool(String schoolSourcedId);
    public List<User> getUsersBySchool(String schoolSourcedId);

    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId);
    public List<User> getUsersForClassInSchool(String classId, String schoolId);

    public List<?> getAll(AllowedTypes type, int offset, int limit);

}
