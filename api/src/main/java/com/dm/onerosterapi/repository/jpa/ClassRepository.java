package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.ClassOfCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassOfCourse, String>{

    public ClassOfCourse findByClassIdIgnoreCase(String id);
    public ClassOfCourse findBySourcedIdIgnoreCase(String id);
    public boolean existsBySourcedIdIgnoreCase(String id);
    public boolean existsByTermIgnoreCase(String id);

}
