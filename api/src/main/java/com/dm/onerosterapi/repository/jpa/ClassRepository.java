package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassOfCourse, Integer>{

    public ClassOfCourse findByClassId(int classId);
}
