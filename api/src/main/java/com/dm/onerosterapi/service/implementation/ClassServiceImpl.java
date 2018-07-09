package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.ClassRepository;
import com.dm.onerosterapi.repository.jpa.CourseRepository;
import com.dm.onerosterapi.service.interfaces.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class ClassServiceImpl implements ClassService {

    private HelperService h;
    private RosterDao rosterDao;
    private ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(
            RosterDao rosterDao,
            ClassRepository classRepository,
            CourseRepository courseRepository,
            HelperService h
    ){
        this.rosterDao = rosterDao;
        this.classRepository = classRepository;
        this.h = h;
    }


    @Override
    public List<ClassOfCourse> getAllClasses() {
        return (List<ClassOfCourse>) h.idFieldSwap(classRepository.findAll());
    }

    @Override
    public ClassOfCourse getBySourcedId(String classId) {
        return (ClassOfCourse) h.idFieldSwap(classRepository.findBySourcedId(classId));
    }

    public List<ClassOfCourse> getClassesByUser(String userSourcedId){
        return getClassesByUser(userSourcedId,"any");
    }

    @Override
    public List<ClassOfCourse> getClassesByStudent(String userSourcedId) {
        return getClassesByUser(userSourcedId,"student");
    }

    @Override
    public List<ClassOfCourse> getClassesByTeacher(String userSourcedId) {
        return getClassesByUser(userSourcedId,"teacher");
    }

    @Override
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId) {
        return (List<ClassOfCourse>) h.idFieldSwap(rosterDao.getClassesByCourse(courseSourcedId));
    }

    @Override
    public List<ClassOfCourse> getClassesByTerm(String term) {
        return (List<ClassOfCourse>) h.idFieldSwap(classRepository.findByTerm(term));
    }

    @Override
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId) {
        return (List<ClassOfCourse>) h.idFieldSwap(rosterDao.getClassesBySchool(schoolSourcedId));
    }

    private List<ClassOfCourse> getClassesByUser(String userSourcedId, String role) {
        return (List<ClassOfCourse>) h.idFieldSwap(rosterDao.getClassesByUser(userSourcedId, role));
    }



}
