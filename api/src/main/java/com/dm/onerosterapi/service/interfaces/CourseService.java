package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface CourseService {

    public Course getCourseById(int courseId);
    public List<Course> getAllCourses();

}
