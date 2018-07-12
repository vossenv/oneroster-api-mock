package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String>{

    public Course findByCourseId(String id);
    public Course findBySourcedId(String id);
    public boolean existsBySourcedId(String id);

}
