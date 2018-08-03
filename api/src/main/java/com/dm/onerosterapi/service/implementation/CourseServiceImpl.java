package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.apiconfig.ApiMessageConfig;
import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.CourseRepository;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.utility.AllowedTypes;
import com.dm.onerosterapi.utility.AttributeTransformer;
import com.dm.onerosterapi.utility.Validator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class CourseServiceImpl implements CourseService {

    final private AttributeTransformer h;
    final private RosterDao rosterDao;
    final private CourseRepository courseRepository;
    final private Validator v;

    @Inject
    public CourseServiceImpl(
            RosterDao rosterDao,
            CourseRepository courseRepository,
            AttributeTransformer h,
            Validator v
    ) {
        this.rosterDao = rosterDao;
        this.courseRepository = courseRepository;
        this.h = h;
        this.v = v;
    }

    @Override
    public List<Course> getAllCourses(int offset, int limit) throws CourseNotFoundException {
        try {
            return (List<Course>) h.processResults(rosterDao.getAll(AllowedTypes.Course, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new CourseNotFoundException(ApiMessageConfig.NO_RESULTS);
        }
    }

    @Override
    public Course getBySourcedId(String sourcedId) throws CourseNotFoundException {
        try {
            return (Course) h.processResults(courseRepository.findBySourcedIdIgnoreCase(sourcedId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new CourseNotFoundException(ApiMessageConfig.NO_COURSES_FOR_ID);
        }
    }

    @Override
    public List<Course> getCoursesBySchool(String schoolSourcedId, int offset, int limit) throws CourseNotFoundException, SchoolNotFoundException {
        try {
            v.validateSchool(schoolSourcedId);
            return (List<Course>) h.processResults(rosterDao.getCoursesBySchool(schoolSourcedId, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new CourseNotFoundException(ApiMessageConfig.NO_RESULTS);
        }
    }
}
