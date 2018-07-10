package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface ClassService {

    public ClassOfCourse getBySourcedId(String classId) throws ClassNotFoundException;
    public List<ClassOfCourse> getAllClasses() throws ClassNotFoundException;
    public List<ClassOfCourse> getClassesByUser(String userSourcedId) throws ClassNotFoundException;
    public List<ClassOfCourse> getClassesByStudent(String userSourcedId) throws ClassNotFoundException;
    public List<ClassOfCourse> getClassesByTeacher(String userSourcedId) throws ClassNotFoundException;
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId) throws ClassNotFoundException;
    public List<ClassOfCourse> getClassesByTerm(String term) throws ClassNotFoundException;
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId) throws ClassNotFoundException;

}
