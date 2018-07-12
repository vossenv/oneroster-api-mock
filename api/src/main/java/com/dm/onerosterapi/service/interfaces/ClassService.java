package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.*;

import java.util.List;

public interface ClassService {

    public ClassOfCourse getBySourcedId(String classId) throws ClassOfCourseNotFoundException;
    public List<ClassOfCourse> getAllClasses() throws ClassOfCourseNotFoundException;
    public List<ClassOfCourse> getClassesByUser(String userSourcedId) throws ClassOfCourseNotFoundException, UserNotFoundException;
    public List<ClassOfCourse> getClassesByStudent(String userSourcedId) throws ClassOfCourseNotFoundException, UserNotFoundException;
    public List<ClassOfCourse> getClassesByTeacher(String userSourcedId) throws ClassOfCourseNotFoundException , UserNotFoundException;
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId) throws ClassOfCourseNotFoundException, CourseNotFoundException;
    public List<ClassOfCourse> getClassesByTerm(String term) throws ClassOfCourseNotFoundException, TermNotFoundException;
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId) throws ClassOfCourseNotFoundException, SchoolNotFoundException;

}
