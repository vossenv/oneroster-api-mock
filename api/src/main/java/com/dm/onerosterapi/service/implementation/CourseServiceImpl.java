package com.dm.onerosterapi.service.implementation;

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
    ){
        this.rosterDao = rosterDao;
        this.courseRepository = courseRepository;
        this.h = h;
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) h.idFieldSwap(courseRepository.findAll());
    }

    @Override
    public Course getBySourcedId(String sourcedId) {
        return (Course) h.idFieldSwap(courseRepository.findBySourcedId(sourcedId));
    }
}
