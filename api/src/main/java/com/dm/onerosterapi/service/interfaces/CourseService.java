package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.CourseNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.Course;

import java.util.List;

public interface CourseService {

    Course getBySourcedId(String sourcedId) throws CourseNotFoundException;
    List<Course> getAllCourses(int offset, int limit) throws CourseNotFoundException;
    List<Course> getCoursesBySchool(String schoolSourcedId, int offset, int limit) throws CourseNotFoundException, SchoolNotFoundException;
}
