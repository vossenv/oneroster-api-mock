package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.CourseRepository;
import com.dm.onerosterapi.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private RosterDao rosterDao;
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(
            RosterDao rosterDao,
            CourseRepository courseRepository
    ){
        this.rosterDao = rosterDao;
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseRepository.findByCourseId(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

}
