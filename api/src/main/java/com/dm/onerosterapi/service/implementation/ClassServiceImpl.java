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
            HelperService h
    ) {
        this.rosterDao = rosterDao;
        this.classRepository = classRepository;
        this.h = h;
    }


    @Override
    public List<ClassOfCourse> getAllClasses() throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.idFieldSwap(classRepository.findAll());
        } catch (NullPointerException e) {
            throw new ClassNotFoundException("Search returned no results..." + e.getMessage());
        }
    }

    @Override
    public ClassOfCourse getBySourcedId(String classId) throws ClassNotFoundException {
        try {
            return (ClassOfCourse) h.idFieldSwap(classRepository.findBySourcedId(classId));
        } catch (NullPointerException e) {
            throw new ClassNotFoundException("Search returned no results..." + e.getMessage());
        }
    }

    public List<ClassOfCourse> getClassesByUser(String userSourcedId) throws ClassNotFoundException {
        return getClassesByUser(userSourcedId, "any");
    }

    @Override
    public List<ClassOfCourse> getClassesByStudent(String userSourcedId) throws ClassNotFoundException {
        return getClassesByUser(userSourcedId, "student");
    }

    @Override
    public List<ClassOfCourse> getClassesByTeacher(String userSourcedId) throws ClassNotFoundException {
        return getClassesByUser(userSourcedId, "teacher");
    }

    @Override
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId) throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.idFieldSwap(rosterDao.getClassesByCourse(courseSourcedId));
        } catch (NullPointerException e) {
            throw new ClassNotFoundException("Search returned no results..." + e.getMessage());
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByTerm(String term) throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.idFieldSwap(classRepository.findByTerm(term));
        } catch (NullPointerException e) {
            throw new ClassNotFoundException("Search returned no results..." + e.getMessage());
        }
    }

    @Override
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId) throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.idFieldSwap(rosterDao.getClassesBySchool(schoolSourcedId));
        } catch (NullPointerException e) {
            throw new ClassNotFoundException("Search returned no results..." + e.getMessage());
        }
    }

    private List<ClassOfCourse> getClassesByUser(String userSourcedId, String role) throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.idFieldSwap(rosterDao.getClassesByUser(userSourcedId, role));
        } catch (NullPointerException e) {
            throw new ClassNotFoundException("Search returned no results..." + e.getMessage());
        }
    }


}
