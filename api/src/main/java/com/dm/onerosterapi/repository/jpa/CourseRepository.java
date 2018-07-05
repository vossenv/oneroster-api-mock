package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.model.Org;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{

    public Course findByCourseId(int courseId);

}
