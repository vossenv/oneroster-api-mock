package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface ClassService {

    public ClassOfCourse getBySourcedId(String classId);
    public List<ClassOfCourse> getAllClasses();
    public List<ClassOfCourse> getClassesByUser(String userSourcedId);
    public List<ClassOfCourse> getClassesByStudent(String userSourcedId);
    public List<ClassOfCourse> getClassesByTeacher(String userSourcedId);
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId);
    public List<ClassOfCourse> getClassesByTerm(String term);
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId);

}
