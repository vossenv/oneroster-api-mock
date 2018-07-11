package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions1.CourseNotFoundException;
import com.dm.onerosterapi.model.*;

import java.util.List;

public interface CourseService {

    public Course getBySourcedId(String sourcedId) throws CourseNotFoundException;
    public List<Course> getAllCourses() throws CourseNotFoundException;
    public List<Course> getCoursesBySchool(String schoolSourcedId) throws CourseNotFoundException;
}
