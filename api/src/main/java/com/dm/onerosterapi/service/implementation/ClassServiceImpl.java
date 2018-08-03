package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.apiconfig.ApiMessageConfig;
import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.ClassRepository;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.utility.AllowedTypes;
import com.dm.onerosterapi.utility.AttributeTransformer;
import com.dm.onerosterapi.utility.Validator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class ClassServiceImpl implements ClassService {

    final private Validator v;
    final private AttributeTransformer h;
    final private RosterDao rosterDao;
    final private ClassRepository classRepository;


    @Inject
    public ClassServiceImpl(
            RosterDao rosterDao,
            ClassRepository classRepository,
            AttributeTransformer h,
            Validator v
    ) {
        this.v = v;
        this.h = h;
        this.rosterDao = rosterDao;
        this.classRepository = classRepository;
    }

    @Override
    public List<ClassOfCourse> getAllClasses(int offset, int limit) throws ClassOfCourseNotFoundException {
        try {
            return (List<ClassOfCourse>) h.processResults(rosterDao.getAll(AllowedTypes.ClassOfCourse, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessageConfig.NO_CLASS_MESSAGE);
        }
    }

    @Override
    public ClassOfCourse getBySourcedId(String classId) throws ClassOfCourseNotFoundException {
        try {
            return (ClassOfCourse) h.processResults(classRepository.findBySourcedIdIgnoreCase(classId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessageConfig.NO_CLASSES_FOR_ID + classId);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId, int offset, int limit) throws ClassOfCourseNotFoundException, CourseNotFoundException {
        try {
            v.validateCourse(courseSourcedId);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByCourse(courseSourcedId, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessageConfig.NO_CLASSES_FOR_COURSE + courseSourcedId);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByTerm(String term, int offset, int limit) throws ClassOfCourseNotFoundException, TermNotFoundException {
        try {
            v.validateClassTerm(term);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByTerm(term, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessageConfig.NO_CLASSES_FOR_TERM + term);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId, int offset, int limit) throws ClassOfCourseNotFoundException, SchoolNotFoundException {
        try {
            v.validateSchool(schoolSourcedId);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesBySchool(schoolSourcedId, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessageConfig.NO_CLASSES_FOR_SCHOOL + schoolSourcedId);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByUser(String userSourcedId, String role, int offset, int limit) throws ClassOfCourseNotFoundException, UserNotFoundException {
        try {
            v.validateUser(userSourcedId, role);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByUser(userSourcedId, role, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessageConfig.NO_CLASSES_FOR_USER + userSourcedId);
        }
    }


}
