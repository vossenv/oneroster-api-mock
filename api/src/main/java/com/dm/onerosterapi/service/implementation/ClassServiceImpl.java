package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
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
            return (List<ClassOfCourse>) h.checkListSize(h.idFieldSwap(classRepository.findAll()));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassNotFoundException(HelperService.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public ClassOfCourse getBySourcedId(String classId) throws ClassNotFoundException {
        try {
            return (ClassOfCourse) h.idFieldSwap(classRepository.findBySourcedId(classId));
        } catch (NullPointerException e) {
            throw new ClassNotFoundException(HelperService.NO_RESULTS_MESSAGE);
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
            return (List<ClassOfCourse>) h.checkListSize(h.idFieldSwap(rosterDao.getClassesByCourse(courseSourcedId)));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassNotFoundException(HelperService.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByTerm(String term) throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.checkListSize(h.idFieldSwap(classRepository.findByTerm(term)));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassNotFoundException(HelperService.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId) throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.checkListSize(h.idFieldSwap(rosterDao.getClassesBySchool(schoolSourcedId)));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassNotFoundException(HelperService.NO_RESULTS_MESSAGE);
        }
    }

    private List<ClassOfCourse> getClassesByUser(String userSourcedId, String role) throws ClassNotFoundException {
        try {
            return (List<ClassOfCourse>) h.checkListSize(h.idFieldSwap(rosterDao.getClassesByUser(userSourcedId, role)));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassNotFoundException(HelperService.NO_RESULTS_MESSAGE);
        }
    }


}
