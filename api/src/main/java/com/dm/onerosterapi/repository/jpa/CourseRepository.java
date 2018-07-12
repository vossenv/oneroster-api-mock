package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String>{

    public Course findByCourseIdIgnoreCase(String id);
    public Course findBySourcedIdIgnoreCase(String id);
    public boolean existsBySourcedIdIgnoreCase(String id);

}
