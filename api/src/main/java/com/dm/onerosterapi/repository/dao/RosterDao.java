package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.*;
import com.dm.onerosterapi.utility.AllowedTypes;
import java.util.List;

public interface RosterDao {

    List<?> getAll(AllowedTypes type, int offset, int limit);

    List<User> getAllUsersOfType(String role, int offset, int limit);
    List<User> getUsersByClass(String classSourcedId, String role, int offset, int limit);
    List<User> getUsersBySchool(String schoolSourcedId, String role, int offset, int limit);
    List<User> getUsersForClassInSchool(String classId, String schoolId, String role, int offset, int limit);

    List<ClassOfCourse> getClassesByUser(String userSourcedId, String role, int offset, int limit);
    List<ClassOfCourse> getClassesByCourse(String courseId, int offset, int limit);
    List<ClassOfCourse> getClassesBySchool(String schoolSourcedId, int offset, int limit);
    List<ClassOfCourse> getClassesByTerm(String term, int offset, int limit);

    List<Course> getCoursesBySchool(String schoolSourcedId, int offset, int limit);

    List<Enrollment> getEnrollmentsBySchool(String schoolSourcedId, int offset, int limit);
    List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId, int offset, int limit);


}
