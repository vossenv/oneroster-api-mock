package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.ApiMessages;
import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.CourseRepository;
import com.dm.onerosterapi.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class CourseServiceImpl implements CourseService {

    private HelperService h;
    private RosterDao rosterDao;
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(
            RosterDao rosterDao,
            CourseRepository courseRepository,
            HelperService h
    ) {
        this.rosterDao = rosterDao;
        this.courseRepository = courseRepository;
        this.h = h;
    }

    @Override
    public List<Course> getAllCourses() throws CourseNotFoundException {
        try {
            return (List<Course>) h.processResults(courseRepository.findAll());
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new CourseNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public Course getBySourcedId(String sourcedId) throws CourseNotFoundException {
        try {
            return (Course) h.processResults(courseRepository.findBySourcedId(sourcedId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new CourseNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public List<Course> getCoursesBySchool(String schoolSourcedId) throws CourseNotFoundException {
        try {
            return (List<Course>) h.processResults(rosterDao.getCoursesBySchool(schoolSourcedId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new CourseNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }
}
