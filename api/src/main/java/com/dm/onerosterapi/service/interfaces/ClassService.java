package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface ClassService {

    public ClassOfCourse getClassById(int classId);
    public List<ClassOfCourse> getAllClasses();

}
