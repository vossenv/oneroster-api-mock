package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.ClassOfCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassOfCourse, String>{

    public ClassOfCourse findByClassId(String classId);
    public ClassOfCourse findBySourcedId(String classId);
    public List<ClassOfCourse> findByTerm(String term);

}
