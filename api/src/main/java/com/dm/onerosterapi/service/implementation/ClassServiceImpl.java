package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.ClassRepository;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.utility.AllowedTypes;
import com.dm.onerosterapi.utility.ApiMessages;
import com.dm.onerosterapi.utility.HelperService;
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
        this.h = h;
        this.rosterDao = rosterDao;
        this.classRepository = classRepository;
    }

    @Override
    public List<ClassOfCourse> getAllClasses(int offset, int limit) throws ClassOfCourseNotFoundException {
        try {
            return (List<ClassOfCourse>) h.processResults(rosterDao.getAll(AllowedTypes.ClassOfCourse, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASS_MESSAGE);
        }
    }

    @Override
    public ClassOfCourse getBySourcedId(String classId) throws ClassOfCourseNotFoundException {
        try {
            return (ClassOfCourse) h.processResults(classRepository.findBySourcedIdIgnoreCase(classId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASSES_FOR_ID + classId);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId, int offset, int limit) throws ClassOfCourseNotFoundException, CourseNotFoundException {
        try {
            h.validateCourse(courseSourcedId);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByCourse(courseSourcedId, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASSES_FOR_COURSE + courseSourcedId);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByTerm(String term, int offset, int limit) throws ClassOfCourseNotFoundException, TermNotFoundException {
        try {
            h.validateClassTerm(term);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByTerm(term, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASSES_FOR_TERM + term);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId, int offset, int limit) throws ClassOfCourseNotFoundException, SchoolNotFoundException {
        try {
            h.validateSchool(schoolSourcedId);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesBySchool(schoolSourcedId, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASSES_FOR_SCHOOL + schoolSourcedId);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByUser(String userSourcedId, String role, int offset, int limit) throws ClassOfCourseNotFoundException, UserNotFoundException {
        try {
            h.validateUser(userSourcedId, role);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByUser(userSourcedId, role, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASSES_FOR_USER + userSourcedId);
        }
    }


}
