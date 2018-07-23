package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.*;

import java.util.List;

public interface ClassService {

    ClassOfCourse getBySourcedId(String classId) throws ClassOfCourseNotFoundException;
    
    List<ClassOfCourse> getAllClasses(int offset, int limit) throws ClassOfCourseNotFoundException;
    List<ClassOfCourse> getClassesByUser(String userSourcedId, String role, int offset, int limit) throws ClassOfCourseNotFoundException, UserNotFoundException;
    List<ClassOfCourse> getClassesByCourse(String courseSourcedId, int offset, int limit) throws ClassOfCourseNotFoundException, CourseNotFoundException;
    List<ClassOfCourse> getClassesByTerm(String term, int offset, int limit) throws ClassOfCourseNotFoundException, TermNotFoundException;
    List<ClassOfCourse> getClassesBySchool(String schoolSourcedId, int offset, int limit) throws ClassOfCourseNotFoundException, SchoolNotFoundException;

}
