package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String>{

    Course findByCourseIdIgnoreCase(String id);
    Course findBySourcedIdIgnoreCase(String id);
    boolean existsBySourcedIdIgnoreCase(String id);

}
