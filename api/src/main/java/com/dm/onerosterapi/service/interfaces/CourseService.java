package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface CourseService {

    public Course getBySourcedId(String sourcedId);
    public List<Course> getAllCourses();

}
