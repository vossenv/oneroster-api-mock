package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.ApiMessages;
import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.UserNotFoundException;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.ClassRepository;
import com.dm.onerosterapi.service.interfaces.ClassService;
import com.dm.onerosterapi.service.interfaces.UserService;
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
            HelperService h,
            UserService userService
    ) {
        this.h = h;
        this.rosterDao = rosterDao;
        this.classRepository = classRepository;
    }

    @Override
    public List<ClassOfCourse> getClassesByStudent(String userSourcedId) throws ClassOfCourseNotFoundException, UserNotFoundException{
        return getClassesByUser(userSourcedId, "student");
    }

    @Override
    public List<ClassOfCourse> getClassesByTeacher(String userSourcedId) throws ClassOfCourseNotFoundException, UserNotFoundException {
        return getClassesByUser(userSourcedId, "teacher");
    }

    @Override
    public List<ClassOfCourse> getAllClasses() throws ClassOfCourseNotFoundException {
        try {
            return (List<ClassOfCourse>) h.processResults(classRepository.findAll());
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASS_MESSAGE);
        }
    }

    public List<ClassOfCourse> getClassesByUser(String userSourcedId) throws ClassOfCourseNotFoundException, UserNotFoundException {
        return getClassesByUser(userSourcedId, "any");
    }

    @Override
    public ClassOfCourse getBySourcedId(String classId) throws ClassOfCourseNotFoundException {
        try {
            return (ClassOfCourse) h.processResults(classRepository.findBySourcedId(classId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASS_MESSAGE);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByCourse(String courseSourcedId) throws ClassOfCourseNotFoundException {
        try {
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByCourse(courseSourcedId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASS_MESSAGE);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesByTerm(String term) throws ClassOfCourseNotFoundException {
        try {
            return (List<ClassOfCourse>) h.processResults(classRepository.findByTerm(term));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASS_MESSAGE);
        }
    }

    @Override
    public List<ClassOfCourse> getClassesBySchool(String schoolSourcedId) throws ClassOfCourseNotFoundException {
        try {

            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesBySchool(schoolSourcedId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException(ApiMessages.NO_CLASS_MESSAGE);
        }
    }

    private List<ClassOfCourse> getClassesByUser(String userSourcedId, String role) throws ClassOfCourseNotFoundException, UserNotFoundException {
        try {
            h.validateUser(userSourcedId);
            return (List<ClassOfCourse>) h.processResults(rosterDao.getClassesByUser(userSourcedId, role));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new ClassOfCourseNotFoundException("No classes were found for user: " + userSourcedId);
        }
    }


}
