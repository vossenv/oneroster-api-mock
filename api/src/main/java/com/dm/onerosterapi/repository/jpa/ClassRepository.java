package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.ClassOfCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassOfCourse, String>{

    ClassOfCourse findByClassIdIgnoreCase(String id);
    ClassOfCourse findBySourcedIdIgnoreCase(String id);
    boolean existsBySourcedIdIgnoreCase(String id);
    boolean existsByTermIgnoreCase(String id);

}
